// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;
 

public class Drivetrain extends SubsystemBase {
  private final TalonFX LeftDrive; 
  private final TalonFX RightDrive;
  private final DifferentialDrive BothDrive;

  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {
    LeftDrive = new TalonFX((OperatorConstants.leftDriveID));
    RightDrive = new TalonFX((OperatorConstants.rightDriveID));
    BothDrive = new DifferentialDrive(RightDrive, LeftDrive);
    
    LeftDrive.setNeutralMode(NeutralModeValue.Brake);
    LeftDrive.setSafetyEnabled(false);
    RightDrive.setNeutralMode(NeutralModeValue.Brake);
    RightDrive.setSafetyEnabled(false);

   // PID 
   // VelocityVoltage(0-12) 
   // Option 2: Know our maximum allowed speed(10.5ft per second, about 7 mph). Find out what is the max motor voltage that will NEVER go above 10.5ft per second. Maybe - a bit from that,
   // monitor our speed and cap it at our Max voltage


  }

  public void adrive(double speed, double rotation){
     BothDrive.arcadeDrive(speed, rotation);
  }

  public void tdrive(double lspeed, double rspeed){
    BothDrive.tankDrive(lspeed, rspeed);
  }

  public void stop(){
    BothDrive.tankDrive(0, 0);
  }

  public Double GetPosition(){
   return LeftDrive.getPosition().getValueAsDouble(); 
  }

  public Double GetSpeed(){
   return LeftDrive.getVelocity().getValueAsDouble()/12*-1; 
  }


 





  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
