// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class GyroMonitoringSubsystem extends SubsystemBase {

    private ShuffleboardTab subsystemShuffleboardTab = Shuffleboard.getTab("Gyro Monitoring Subsystem");
    private ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    // private NetworkTableEntry sbBatteryVoltage = subsystemShuffleboardTab.add("Battery Voltage", 12)
    // .withWidget(BuiltInWidgets.kDial)
    // .withProperties(Map.of("min", 10, "max", 14))
    // .getEntry();
    // private NetworkTableEntry sbTemperature = subsystemShuffleboardTab.add("PDP Temperature", 12)
    // .withWidget(BuiltInWidgets.kDial)
    // .withProperties(Map.of("min", 15, "max", 50))
    // .getEntry();

    // private NetworkTableEntry sbMotorCurrent = subsystemShuffleboardTab.add("Motor Current", 0)
    // .withWidget(BuiltInWidgets.kGraph)
    // .withProperties(Map.of("visibletime", 10))
    // .getEntry();
  
  /** Creates a new ExampleSubsystem. */
  public GyroMonitoringSubsystem() {
    // m_pdp = new PowerDistributionPanel(0);
    // m_pdp.clearStickyFaults();
    subsystemShuffleboardTab.add(gyro);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void populateShuffleboard() {


  }
}
