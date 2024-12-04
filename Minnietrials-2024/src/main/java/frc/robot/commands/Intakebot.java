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
public class IntakeBot extends InstantCommand {
  private final Intake commandIntake;
  private final PS4Controller commandController;

  public IntakeBot(Intake inSystem, PS4Controller inControl) {
    // Use addRequirements() here to declare subsystem dependencies.
    commandIntake = inSystem;
    commandController = inControl;
    addRequirements(inSystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double ps4YAxisL = commandController.getLeftY();

    if (Math.abs(ps4YAxisL) < Constants.deadZone){
      ps4YAxisL = 0;
    }

      commandIntake.run(ps4YAxisL);

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

