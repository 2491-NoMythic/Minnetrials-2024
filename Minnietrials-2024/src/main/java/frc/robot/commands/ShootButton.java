// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootButton extends InstantCommand {
  private final Shooter buttonShooter;
  private final Intake butInShooter;

  public ShootButton(Shooter shootButton, Intake shootIn) {
    // Use addRequirements() here to declare subsystem dependencies.
    buttonShooter = shootButton;
    butInShooter = shootIn;
    addRequirements(shootButton, shootIn);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
    // Called every time the scheduler runs while the command is scheduled.
  @Override 
  public void execute() {
    buttonShooter.shoot(1); 
    butInShooter.run(0.5);    
  }
   
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    buttonShooter.stop();
    butInShooter.norun();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
