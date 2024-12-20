// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class ShootAuto extends Command { 
    Shooter autoShooter;
    double shootSpeed, shootTime;
    Timer shootTimer;

  /** Creates a new ShootAuto. */
  public ShootAuto(Shooter shoot, double speed, double time) {
    autoShooter=shoot;
    shootTime=time;
    shootSpeed=speed;
    shootTimer=new Timer();

  
    // Use addRequirements() here to declare subsystem dependencies 
 addRequirements(autoShooter); }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() { 
    shootTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    autoShooter.shoot(shootSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    autoShooter.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return shootTimer.get()>shootTime;

  }
}
