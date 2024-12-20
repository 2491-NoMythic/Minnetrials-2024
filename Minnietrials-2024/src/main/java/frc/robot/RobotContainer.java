// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.AutoGroup;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveBot;
import frc.robot.commands.IntakeBot;
import frc.robot.commands.IntakeButton;
import frc.robot.commands.ShootBot;
import frc.robot.commands.ShootButton;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj.simulation.PS4ControllerSim;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain conDrivetrain = new Drivetrain();
  private final Shooter conShooter = new Shooter();
  private final Intake conIntake = new Intake();
  private final Joystick conJoystick = new Joystick(OperatorConstants.joystickPort);
  private final PS4Controller conPS4 = new PS4Controller(OperatorConstants.ps4Port);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
      
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
   // new Trigger(Drivetrain::exampleCondition)
       // .onTrue(new DriveBot(Drivetrain));

   new Trigger(conPS4::getR2Button).whileTrue(new IntakeButton(conIntake));
   new Trigger(conPS4::getL2Button).whileTrue(new ShootButton(conShooter, conIntake));
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    conDrivetrain.setDefaultCommand(new DriveBot(conDrivetrain, conJoystick));
    conShooter.setDefaultCommand(new ShootBot(conPS4, conShooter));
    conIntake.setDefaultCommand(new IntakeBot(conIntake, conPS4));
    //m_driverController.b().whileTrue(Drivetrain.exampleMethodCommand());
  } 

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new AutoGroup(conDrivetrain, conShooter);
  }
}
