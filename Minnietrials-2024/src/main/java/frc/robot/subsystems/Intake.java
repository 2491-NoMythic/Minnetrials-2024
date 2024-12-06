// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class Intake extends SubsystemBase {
    private final CANSparkMax InMotor;
    private final DigitalInput epicSensor;

    public Intake() {
        InMotor = new CANSparkMax(OperatorConstants.inID,(MotorType.kBrushless));
        InMotor.setIdleMode(IdleMode.kBrake);
        InMotor.setSmartCurrentLimit(20);
        epicSensor = new DigitalInput(9);
        
    }
    public boolean isHeld(){
        return !epicSensor.get();
    }


    public void run(double inspeed) {
        InMotor.set(inspeed);
    }

    public void norun(){
        InMotor.set(0);
    }
}