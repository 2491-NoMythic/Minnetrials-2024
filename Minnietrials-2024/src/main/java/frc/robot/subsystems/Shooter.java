// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class Shooter extends SubsystemBase{
    private final TalonFX ShootMotor;
public Shooter(){
    ShootMotor = new TalonFX(OperatorConstants.shootID);
    ShootMotor.setNeutralMode(NeutralModeValue.Brake);
}

    public void shoot(double shootspeed){
        ShootMotor.set(shootspeed);
    }

    public void stop(){
        ShootMotor.set(0);
    }

}