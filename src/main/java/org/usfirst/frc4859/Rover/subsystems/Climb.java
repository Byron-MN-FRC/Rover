// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4859.Rover.subsystems;


import org.usfirst.frc4859.Rover.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import org.usfirst.frc4859.Rover.Constants;



/**
 *
 */
public class Climb extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private DoubleSolenoid kickStandSolenoid;
    private Solenoid gravityShifterSolenoid;
    private WPI_TalonSRX feetMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Climb() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        kickStandSolenoid = new DoubleSolenoid(10, 6, 7);
        addChild("kickStandSolenoid",kickStandSolenoid);
        
        
        gravityShifterSolenoid = new Solenoid(10, 2);
        addChild("gravityShifterSolenoid",gravityShifterSolenoid);
        
        
        feetMotor = new WPI_TalonSRX(8);
        
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        motorConfig();
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


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

    //Method for deploying kickstand
    public void deployKickstand() {
         System.out.println("deployKickstand");
         kickStandSolenoid.set(Value.kForward);
    }
    //Method for pushing drivetrain forward
    public void shiftGravity() {
        System.out.println("shiftGravity");
        gravityShifterSolenoid.set(true);
        
    }
     //Method for deploying feet
     public void deployFeet() {
       System.out.println("shiftGravity"); 
       
       /*4096 ticks/rev * 10 Rotations in either direction */
        double targetPos = .2 * 4096 * 5.75;
        System.out.println("Target position =" + targetPos);
		feetMotor.set(ControlMode.MotionMagic, targetPos);
         		/* Zero the sensor */
		feetMotor.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
      
    }
    
    //motor config taken from MotionMagic example at https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages
    private void motorConfig() {
        	/* Factory default hardware to prevent unexpected behavior */
		feetMotor.configFactoryDefault();

		/* Configure Sensor Source for Pirmary PID */
		feetMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative,
											Constants.kPIDLoopIdx, 
											Constants.kTimeoutMs);

		/**
		 * Configure Talon SRX Output and Sesnor direction accordingly
		 * Invert Motor to have green LEDs when driving Talon Forward / Requesting Postiive Output
		 * Phase sensor to have positive increment when driving Talon Forward (Green LED)
		 */
		feetMotor.setSensorPhase(true);
		feetMotor.setInverted(false);

		/* Set relevant frame periods to be at least as fast as periodic rate */
		feetMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		feetMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);

		/* Set the peak and nominal outputs */
		feetMotor.configNominalOutputForward(0, Constants.kTimeoutMs);
		feetMotor.configNominalOutputReverse(0, Constants.kTimeoutMs);
		feetMotor.configPeakOutputForward(1, Constants.kTimeoutMs);
		feetMotor.configPeakOutputReverse(-1, Constants.kTimeoutMs);

		/* Set Motion Magic gains in slot0 - see documentation */
		feetMotor.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		feetMotor.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
		feetMotor.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
		feetMotor.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
		feetMotor.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);
		/* Set acceleration and vcruise velocity - see documentation */
		feetMotor.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
		feetMotor.configMotionAcceleration(6000, Constants.kTimeoutMs);

		/* Zero the sensor */
		feetMotor.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
	}
}


