// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoGroup extends SequentialCommandGroup {
  /** Creates a new AutoGroup. */
  public AutoGroup(Drivetrain driveGroup, Shooter shootGroup) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      //Drive Command(Drivetrain, speed, time)
      new DriveAuto(driveGroup, 0.5, 3.2),

      //Shoot
      new ShootAuto(shootGroup, 1, 1)
      
      );
  }
}
