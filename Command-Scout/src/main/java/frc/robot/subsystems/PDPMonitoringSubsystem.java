// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class PDPMonitoringSubsystem extends SubsystemBase {

    private ShuffleboardTab subsystemShuffleboardTab = Shuffleboard.getTab("PDP Monitoring Subsystem");

    private NetworkTableEntry sbBatteryVoltage = subsystemShuffleboardTab.add("Battery Voltage", 12)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", 10, "max", 14))
    .getEntry();
    private NetworkTableEntry sbTemperature = subsystemShuffleboardTab.add("PDP Temperature", 12)
    .withWidget(BuiltInWidgets.kDial)
    .withProperties(Map.of("min", 15, "max", 50))
    .getEntry();

    // private NetworkTableEntry sbMotorCurrent = subsystemShuffleboardTab.add("Motor Current", 0)
    // .withWidget(BuiltInWidgets.kGraph)
    // .withProperties(Map.of("visibletime", 10))
    // .getEntry();

    private PowerDistributionPanel m_pdp;
  
  /** Creates a new ExampleSubsystem. */
  public PDPMonitoringSubsystem() {
    m_pdp = new PowerDistributionPanel(0);
    m_pdp.clearStickyFaults();
    subsystemShuffleboardTab.add(m_pdp);

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

    sbBatteryVoltage.setDouble(m_pdp.getVoltage());
    sbTemperature.setDouble( m_pdp.getTemperature());   
    // sbMotorCurrent.setDouble(m_pdp.getCurrent(2));
    // sbMotorCurrent.setDouble(m_pdp.getCurrent(2));


  }
}
