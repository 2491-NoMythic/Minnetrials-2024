// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Shooter;

public class ShootBot extends InstantCommand {
    private final Joystick commandJoystick;
    private final Shooter commandShooter;

  public ShootBot(Joystick shootjoy, Shooter sshooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    commandJoystick = shootjoy;
    commandShooter = sshooter;  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }
    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Uses the getThrottle function thing to set how much we have moved our throttle(the little switch)
    if(commandJoystick.getRawButton(1))
        commandShooter.shoot(0.5);
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

