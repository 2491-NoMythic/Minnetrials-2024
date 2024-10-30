// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class DriveBot extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drivetrain commandDrivetrain;
  private final Joystick commandJoystick;

  /** 
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveBot(Drivetrain drivesystem, Joystick drivejoy) {
    commandDrivetrain = drivesystem;
    commandJoystick = drivejoy;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivesystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Uses the getThrottle function thing to set how much we have moved our throttle(the little switch)
    double throttle = commandJoystick.getThrottle();
    // Uses our previously made Arcade drive and throttle to set how much moving the joystick will rotate or move the robot)
    commandDrivetrain.adrive(commandJoystick.getY()*(throttle + 1.3), commandJoystick.getZ()*0.50);
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
