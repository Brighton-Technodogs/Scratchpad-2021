// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.ScoutDriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/** An example command that uses an example subsystem. */
public class ScoutDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final ScoutDriveSubsystem m_subsystem;
  private final XboxController m_driverController = new XboxController(0);

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ScoutDriveCommand(ScoutDriveSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStick = m_driverController.getY(Hand.kLeft);
    double rightStick = m_driverController.getY(Hand.kRight);

    double leftSpeed = leftStick;
    double rightSpeed = rightStick;

    if (m_driverController.getBumper(Hand.kLeft)) {
      leftSpeed = rightSpeed * -1;
      rightSpeed = leftSpeed * -1;
    }
    m_subsystem.drive(leftSpeed, rightSpeed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
