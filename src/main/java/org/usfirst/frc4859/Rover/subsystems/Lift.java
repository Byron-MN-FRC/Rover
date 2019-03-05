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
import edu.wpi.first.wpilibj.DigitalInput;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import org.usfirst.frc4859.Rover.Constants;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class Lift extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX liftMotor;
    private DigitalInput limitSwitch;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public String target = "NoLift";

    public Lift() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        liftMotor = new WPI_TalonSRX(8);
        
        
        
        limitSwitch = new DigitalInput(0);
        addChild("limitSwitch",limitSwitch);
        
        

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
   // public void liftToHeight(String inTarget) {
   //     double encoderUnits = Constants.catapultVariables.get(inTarget)[4];
    //    if (encoderUnits > 0) {
    //         liftMotor.set(ControlMode.MotionMagic, encoderUnits); 
    //    }
    //    atHeight = true;
   // }
    
    public void liftToHeight() {
        double encoderUnits = Constants.catapultVariables.get(target)[4];
      //  if (encoderUnits > 0) {
             liftMotor.set(ControlMode.MotionMagic, encoderUnits); 
 //       }
    }
    
   // public void liftUp(double inputSpeed){
   //     System.out.println("lift up");
   //     liftMotor.set(inputSpeed);
   // }
   
   
    public void liftStop(){
       System.out.println("lift stop");
       liftMotor.set(0);
   }

    public void liftDown(){
        System.out.println("lift down");
        //if (!(target.equals("LowRocketBall") || target.equals("LowRocketHatch") || target.equals("CargoHatch"))) {
            liftMotor.set(ControlMode.MotionMagic, 0);
            // liftMotor.set(-2);
    //   }
      }
    public void driveWithXbox(Joystick pJoystick){
        double y = 0 - pJoystick.getRawAxis(1) / 3;
        liftMotor.set(ControlMode.PercentOutput, y);   
    }

    // motor config taken from MotionMagic example at
    // https://github.com/CrossTheRoadElec/Phoenix-Examples-Languages
    private void motorConfig() {
        /* Factory default hardware to prevent unexpected behavior */
        liftMotor.configFactoryDefault();

        /* Configure Sensor Source for Pirmary PID */
        liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx,
                Constants.kTimeoutMs);

        /**
         * Configure Talon SRX Output and Sesnor direction accordingly Invert Motor to
         * have green LEDs when driving Talon Forward / Requesting Postiive Output Phase
         * sensor to have positive increment when driving Talon Forward (Green LED)
         */
        liftMotor.setSensorPhase(false); // required to stop 
        liftMotor.setInverted(false);

        /* Set relevant frame periods to be at least as fast as periodic rate */
        liftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
        liftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);

        /* Set the peak and nominal outputs */
        liftMotor.configNominalOutputForward(0, Constants.kTimeoutMs);
        liftMotor.configNominalOutputReverse(0, Constants.kTimeoutMs);
        liftMotor.configPeakOutputForward(1, Constants.kTimeoutMs);
        liftMotor.configPeakOutputReverse(-1, Constants.kTimeoutMs);

        /* Set Motion Magic gains in slot0 - see documentation */
        liftMotor.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
        liftMotor.config_kF(Constants.kSlotIdx, Constants.kGains.kF, Constants.kTimeoutMs);
        liftMotor.config_kP(Constants.kSlotIdx, Constants.kGains.kP, Constants.kTimeoutMs);
        liftMotor.config_kI(Constants.kSlotIdx, Constants.kGains.kI, Constants.kTimeoutMs);
        liftMotor.config_kD(Constants.kSlotIdx, Constants.kGains.kD, Constants.kTimeoutMs);
        /* Set acceleration and vcruise velocity - see documentation */
        liftMotor.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
        liftMotor.configMotionAcceleration(6000, Constants.kTimeoutMs);

        /* Zero the sensor */
        liftMotor.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
    }
    public TalonSRX getLiftMotor() { return liftMotor; }
    public DigitalInput getLimitSwitch() { return limitSwitch; }
    public Boolean atHeight() {
        double currentEncoderUnits = liftMotor.getSelectedSensorPosition(Constants.kPIDLoopIdx);
        double targetEncoderUnits = Constants.catapultVariables.get(target)[4];
        if (Math.abs(currentEncoderUnits - targetEncoderUnits)  < 1000) {
            return true;
        }
        return false;

    }
    
}
