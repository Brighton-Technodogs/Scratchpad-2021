/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.clampmotor;

import frc.robot.subsystems.ClampMotorSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * An example command that uses an example subsystem.
 */
public class SpinClampMotorCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

  private final ClampMotorSubsystem m_subsystem;
  double commandedMotorSpeed;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  
  public SpinClampMotorCommand(ClampMotorSubsystem subsystem) {
    m_subsystem = subsystem;
    SmartDashboard.putNumber("desiredMotorSpeed", 0);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    commandedMotorSpeed = SmartDashboard.getNumber("desiredMotorSpeed", 0);
    m_subsystem.spin(commandedMotorSpeed);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return m_subsystem.getMotorVelocity() >= commandedMotorSpeed * 0.9;
    
  }
}
