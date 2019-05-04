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
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
    import org.usfirst.frc4859.Rover.Robot;

/**
 *
 */
public class Catapult extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    public boolean tMode;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private Talon catapultMotor;
    private Servo catapultServo;
    private Servo catapultServo2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Catapult() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        catapultMotor = new Talon(1);
        addChild("catapultMotor",catapultMotor);
        catapultMotor.setInverted(false);
        
        catapultServo = new Servo(2);
        addChild("catapultServo",catapultServo);
        
        
        catapultServo2 = new Servo(3);
        addChild("catapultServo2",catapultServo2);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
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
     
    
    public void move(double speed) {
        System.out.println("Catapult Move");
        //driving to acomidate motor backwards
        if (Robot.lift.target.equals("NoLift")) {
            catapultServo.set(0);
            catapultServo2.set(1);
        }
        catapultMotor.set(speed);
    }
    public void stop() {
        System.out.println("Catapult Stop");
        catapultMotor.set(0);
        //catapultServo.set(.5);
        //catapultServo2.set(.45);
    }

    public void moveServo() {
        if (tMode) {
            catapultServo.set(0);
            catapultServo2.set(1);
        } else {
            catapultServo.set(.4);
            catapultServo2.set(.55);
        }
    }
}


