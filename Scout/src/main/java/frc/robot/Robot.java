// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with tank
 * steering and an Xbox controller.
 */
public class Robot extends TimedRobot {
  private static final int kPDPId = 0;

  private final PWMVictorSPX m_leftMotor = new PWMVictorSPX(0);
  private final PWMVictorSPX m_rightMotor = new PWMVictorSPX(1);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);
  private final XboxController m_driverController = new XboxController(0);
  private final PowerDistributionPanel m_pdp = new PowerDistributionPanel(kPDPId);

  Double max_current_2 = 0.0;
  Double max_current_3 = 0.0;
  Double min_voltage = 0.0;

  Double max_total_current = 0.0;
  Double max_total_power = 0.0;

  @Override
  public void teleopInit() {
    // TODO Auto-generated method stub
    super.teleopInit();
    m_leftMotor.setInverted(true);
    m_rightMotor.setInverted(true);

    max_current_2 = 0.0;
    max_current_3 = 0.0;
    min_voltage = 24.0;

    max_total_current = 0.0;
    max_total_power = 0.0;
  }

  @Override
  public void teleopPeriodic() {
    // Drive with tank drive.
    // That means that the Y axis of the left stick moves the left side
    // of the robot forward and backward, and the Y axis of the right stick
    // moves the right side of the robot forward and backward.
    m_robotDrive.tankDrive(
        m_driverController.getY(Hand.kLeft), m_driverController.getY(Hand.kRight));


    /*
     * Get the current going through channel 7, in Amperes. The PDP returns the
     * current in increments of 0.125A. At low currents
     * the current readings tend to be less accurate.
     */

     Double current_current_2 = m_pdp.getCurrent(2);
     Double current_current_3 = m_pdp.getCurrent(3);

     if (current_current_2 > max_current_2) {
       max_current_2 = current_current_2;
     }

     if (current_current_3 > max_current_3) {
       max_current_3 = current_current_3;
     }


    SmartDashboard.putNumber("Current Channel 2", current_current_2);
    SmartDashboard.putNumber("Current Channel 3", current_current_3);

    SmartDashboard.putNumber("Max Current Channel 2", max_current_2);
    SmartDashboard.putNumber("Max Current Channel 3", max_current_3);

    /*
     * Get the voltage going into the PDP, in Volts.
     * The PDP returns the voltage in increments of 0.05 Volts.
     */

    Double current_voltage = m_pdp.getVoltage();

    Double current_total_current = m_pdp.getTotalCurrent();
    Double current_total_power = m_pdp.getTotalPower();

    if (current_total_current > max_total_current){
      max_total_current = current_total_current;
    }

    if (current_total_power > current_total_power){
      max_total_power = current_total_power;
    }

    Double total_energy = m_pdp.getTotalEnergy();

    SmartDashboard.putNumber("Total Current (max)", max_total_current);
    SmartDashboard.putNumber("Total Current", current_total_current);

    SmartDashboard.putNumber("Total Power (max)", max_total_power);
    SmartDashboard.putNumber("Total Power", current_total_power);

    SmartDashboard.putNumber("Total Energy", total_energy);

    

    if (current_voltage < min_voltage){
      min_voltage = current_voltage;
    }

    SmartDashboard.putNumber("Voltage", current_voltage);
    SmartDashboard.putNumber("Min Voltage", min_voltage);

    /*
     * Retrieves the temperature of the PDP, in degrees Celsius.
     */
    SmartDashboard.putNumber("Temperature", m_pdp.getTemperature());
  }
}
