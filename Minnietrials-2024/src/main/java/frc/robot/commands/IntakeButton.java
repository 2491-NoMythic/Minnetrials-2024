// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeButton extends InstantCommand {
  private final Intake buttonIntake;

  public IntakeButton(Intake inButton) {
    // Use addRequirements() here to declare subsystem dependencies.
    buttonIntake = inButton;
    addRequirements(inButton);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     Boolean held = buttonIntake.isHeld();
     System.out.println(held);

     if(held){
      buttonIntake.norun();
     }
     else
     {
      buttonIntake.run(0.5);
     }
     
  }
   
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    buttonIntake.norun();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

