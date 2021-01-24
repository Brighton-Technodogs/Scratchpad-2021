/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClampMotorSubsystem extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

   CANSparkMax m_MotorController;
   CANPIDController m_PIDController;
   CANEncoder m_Encoder;
   public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;


   
  public ClampMotorSubsystem() {
    //Instantiate the motor controller (spark max!!) here
    m_MotorController = new CANSparkMax(Constants.clampMotorControllerID,MotorType.kBrushless);
    

    m_PIDController = m_MotorController.getPIDController();
    m_Encoder = m_MotorController.getEncoder();

    // PID coefficients
    kP = 6e-5; 
    kI = 0;
    kD = 0; 
    kIz = 0; 
    kFF = 0.00015;
    kMaxOutput = 1; 
    kMinOutput = -1;
    maxRPM = 5700;

    // set PID coefficients
    m_PIDController.setP(kP);
    m_PIDController.setI(kI);
    m_PIDController.setD(kD);
    m_PIDController.setIZone(kIz);
    m_PIDController.setFF(kFF);
    m_PIDController.setOutputRange(kMinOutput, kMaxOutput);
    m_MotorController.stopMotor();

  }

  @Override
  public void periodic() {

    SmartDashboard.putNumber("currentMotorSpeed", getMotorVelocity());
    // This method will be called once per scheduler run
  }

  public void spin(double spinVelocity) {

    System.out.println("Running spin clamp motor");
    m_PIDController.setReference(spinVelocity, ControlType.kVelocity);
    
    
  }

  public void stop() {
    System.out.println("Stopping spin clamp motor");
    m_MotorController.stopMotor();
  }

  public double getMotorVelocity(){
    return m_Encoder.getVelocity();
  }
}
