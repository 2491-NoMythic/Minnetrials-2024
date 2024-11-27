// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class DriveTime extends Command {
  Drivetrain drivetrain;
  double speed, time;
  Timer beepbeep;
  /** Creates a new DriveTime. */
  public DriveTime(Drivetrain drivetrain, double speed, double time) { 
    this.drivetrain=drivetrain;
    this.time=time;
    this.speed=speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
    beepbeep=new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    beepbeep.start();
    drivetrain.adrive(speed, 0);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return beepbeep.get()>time;
   
  }
}
