// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4858.Rover.subsystems;


import org.usfirst.frc4858.Rover.Robot;
import org.usfirst.frc4858.Rover.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class DriveTrainTank extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX leftMotor;
    private WPI_TalonSRX rightMotor;
    private DifferentialDrive differentialDrive;
    private Encoder rightDriveEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    public DriveTrainTank() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftMotor = new WPI_TalonSRX(2);
        
        
        
        rightMotor = new WPI_TalonSRX(5);
        
        
        
        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        addChild("DifferentialDrive",differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

        
        rightDriveEncoder = new Encoder(9, 10, false, EncodingType.k4X);
        addChild("rightDriveEncoder",rightDriveEncoder);
        rightDriveEncoder.setDistancePerPulse(1.0);
        rightDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveWithJoystickTank());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void driveTimedForward(double speed) {
    	differentialDrive.arcadeDrive(speed, 0);
    }
  
    // public void driveEncodersForward(double distance) {
    //     distance = 1000;
    // 	leftMotor.set(ControlMode.MotionMagic, distance);
    // 	rightMotor.set(ControlMode.MotionMagic, distance);
    // }
     
    public void driveWithJoystick(Joystick pJoystick) {
        differentialDrive.arcadeDrive(pJoystick.getY(), pJoystick.getTwist());
    }
    
    public void driveStop() {
    	differentialDrive.arcadeDrive(0, 0);
    }

    // private void motorConfig1(WPI_TalonSRX talon){
        // talon.configContinuousCurrentLimit(RobotMap.kDriveContinuousCurrentLimit, RobotMap.kTimeoutMs);
        // talon.setSensorPhase(true);
        // talon.setInverted(false);
		// talon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 2, RobotMap.kTimeoutMs);
		// talon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 2, RobotMap.kTimeoutMs);
        // talon.configNominalOutputForward(0, RobotMap.kTimeoutMs);
        // talon.configNominalOutputReverse(0, RobotMap.kTimeoutMs);
        // talon.configPeakOutputForward(1, RobotMap.kTimeoutMs);
        // talon.configPeakOutputReverse(-1,RobotMap.kTimeoutMs);
        // talon.config_kF(0, RobotMap.kF, RobotMap.kTimeoutMs);
		// talon.config_kP(0, RobotMap.kP, RobotMap.kTimeoutMs);
		// talon.config_kI(0, RobotMap.kI, RobotMap.kTimeoutMs);
		// talon.config_kD(0, RobotMap.kD, RobotMap.kTimeoutMs);
        // talon.configMotionCruiseVelocity(15000, RobotMap.kTimeoutMs);
        // talon.configMotionAcceleration(6000,RobotMap.kTimeoutMs);
        // talon.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
        
    // }
    // private void motorConfig(){
		
		// Set current limits
		// leftTalon.configContinuousCurrentLimit(RobotMap.kDriveContinuousCurrentLimit, RobotMap.kTimeoutMs);
		// rightTalon.configContinuousCurrentLimit(RobotMap.kDriveContinuousCurrentLimit, RobotMap.kTimeoutMs);
		
		// leftTalon.configPeakCurrentDuration(RobotMap.kDriveCurrentPeakDuration, RobotMap.kTimeoutMs);
		// rightTalon.configPeakCurrentDuration(RobotMap.kDriveCurrentPeakDuration, RobotMap.kTimeoutMs);
		
		// leftTalon.enableCurrentLimit(true);
		// rightTalon.enableCurrentLimit(true);
		
		// // Configure feedback devices
		// leftTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);
		// rightTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, RobotMap.kTimeoutMs);

		// // Set relevant frame periods to be at least as fast as periodic rate
		// leftTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 2, RobotMap.kTimeoutMs);
		// leftTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 2, RobotMap.kTimeoutMs);
		// leftTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_9_MotProfBuffer, 2, RobotMap.kTimeoutMs);
		
		// rightTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 2, RobotMap.kTimeoutMs);
		// rightTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 2, RobotMap.kTimeoutMs);
		// rightTalon.setStatusFramePeriod(StatusFrameEnhanced.Status_9_MotProfBuffer, 2, RobotMap.kTimeoutMs);

		// // Set closed loop gains in slot 0
		// leftTalon.selectProfileSlot(RobotMap.kPIDSlot, 0);
		// leftTalon.config_kF(0, RobotMap.kF, RobotMap.kTimeoutMs);
		// leftTalon.config_kP(0, RobotMap.kP, RobotMap.kTimeoutMs);
		// leftTalon.config_kI(0, RobotMap.kI, RobotMap.kTimeoutMs);
		// leftTalon.config_kD(0, RobotMap.kD, RobotMap.kTimeoutMs);
		// leftTalon.config_IntegralZone(0, 0, RobotMap.kTimeoutMs);
		// leftTalon.configAllowableClosedloopError(RobotMap.kPIDSlot, RobotMap.kDriveAllowableError, RobotMap.kTimeoutMs);
		
		// rightTalon.selectProfileSlot(RobotMap.kPIDSlot, 0);
		// rightTalon.config_kF(0, RobotMap.kF, RobotMap.kTimeoutMs);
		// rightTalon.config_kP(0, RobotMap.kP, RobotMap.kTimeoutMs);
		// rightTalon.config_kI(0, RobotMap.kI, RobotMap.kTimeoutMs);
		// rightTalon.config_kD(0, RobotMap.kD, RobotMap.kTimeoutMs);
		// rightTalon.config_IntegralZone(0, 0, RobotMap.kTimeoutMs);
		// rightTalon.configAllowableClosedloopError(RobotMap.kPIDSlot, RobotMap.kDriveAllowableError, RobotMap.kTimeoutMs);

		// // Set acceleration and cruise velocity
		// leftTalon.configMotionAcceleration(RobotMap.kLowGearAcceleration, RobotMap.kTimeoutMs);
		// leftTalon.configMotionCruiseVelocity(RobotMap.kLowGearCruiseVelocity, RobotMap.kTimeoutMs);
		// rightTalon.configMotionAcceleration(RobotMap.kLowGearAcceleration, RobotMap.kTimeoutMs);
		// rightTalon.configMotionCruiseVelocity(RobotMap.kLowGearCruiseVelocity, RobotMap.kTimeoutMs);
		
		// // Zero encoder
		// leftTalon.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		// rightTalon.setSelectedSensorPosition(0, 0, RobotMap.kTimeoutMs);
		
		// // Set ramp rates
		// leftTalon.configOpenloopRamp(RobotMap.kRampRate,RobotMap.kTimeoutMs);
		// rightTalon.configOpenloopRamp(RobotMap.kRampRate,RobotMap.kTimeoutMs);
		
    //  }
}


