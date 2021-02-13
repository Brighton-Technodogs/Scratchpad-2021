// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.PublishPDPToSmartDashboardCommand;
import frc.robot.commands.ScoutDriveCommand;
import frc.robot.subsystems.PDPMonitoringSubsystem;
import frc.robot.subsystems.ScoutDriveSubsystem;

import frc.robot.subsystems.GyroMonitoringSubsystem;
import frc.robot.commands.PublishGyroToSmartDashboardCommand;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ScoutDriveSubsystem m_driveSubsystem = new ScoutDriveSubsystem();
  private final ScoutDriveCommand m_scoutDriveCommand = new ScoutDriveCommand(m_driveSubsystem);

  private final PDPMonitoringSubsystem m_pdpSubsystem = new PDPMonitoringSubsystem();
  private final PublishPDPToSmartDashboardCommand m_pdpCommand = new PublishPDPToSmartDashboardCommand(m_pdpSubsystem);

  private final GyroMonitoringSubsystem m_gyroSubsystem = new GyroMonitoringSubsystem();
  private final PublishGyroToSmartDashboardCommand m_gyroCommand = new PublishGyroToSmartDashboardCommand(m_gyroSubsystem);

  // private final ScoutDriveCommand m_autoCommand = new ScoutDriveCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_driveSubsystem.setDefaultCommand(m_scoutDriveCommand);
    m_pdpSubsystem.setDefaultCommand(m_pdpCommand);
    m_gyroSubsystem.setDefaultCommand(m_gyroCommand);

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
    return null;
  }
}
