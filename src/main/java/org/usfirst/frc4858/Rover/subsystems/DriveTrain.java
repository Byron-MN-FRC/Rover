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


import org.usfirst.frc4858.Rover.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX leftFrontMotor;
    private WPI_TalonSRX leftRearMotor;
    private WPI_TalonSRX rightFrontMotor;
    private WPI_TalonSRX rightRearMotor;
    private MecanumDrive mecanumDrive;
    private DigitalInput lidarProximity;
    private PigeonIMU pigeon;
    private Encoder leftFrontDriveEncoder;
    private Encoder leftRearDriveEncoder;
    private Encoder rightFrontDriveEncoder;
    private Encoder rightRearDriveEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftFrontMotor = new WPI_TalonSRX(3);
        
        
        
        leftRearMotor = new WPI_TalonSRX(4);
        
        
        
        rightFrontMotor = new WPI_TalonSRX(5);
        
        
        
        rightRearMotor = new WPI_TalonSRX(10);
        
        
        
        mecanumDrive = new MecanumDrive(leftFrontMotor, leftRearMotor,
              rightFrontMotor, rightRearMotor);
        addChild("MecanumDrive",mecanumDrive);
        mecanumDrive.setSafetyEnabled(true);
        mecanumDrive.setExpiration(0.1);
        mecanumDrive.setMaxOutput(1.0);

        
        lidarProximity = new DigitalInput(1);
        addChild("lidarProximity",lidarProximity);
        
        
        pigeon = new PigeonIMU(6);
        
        
        
        leftFrontDriveEncoder = new Encoder(0, 2, false, EncodingType.k4X);
        addChild("leftFrontDriveEncoder",leftFrontDriveEncoder);
        leftFrontDriveEncoder.setDistancePerPulse(1.0);
        leftFrontDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        leftRearDriveEncoder = new Encoder(3, 4, false, EncodingType.k4X);
        addChild("leftRearDriveEncoder",leftRearDriveEncoder);
        leftRearDriveEncoder.setDistancePerPulse(1.0);
        leftRearDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        rightFrontDriveEncoder = new Encoder(5, 6, false, EncodingType.k4X);
        addChild("rightFrontDriveEncoder",rightFrontDriveEncoder);
        rightFrontDriveEncoder.setDistancePerPulse(1.0);
        rightFrontDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        
        rightRearDriveEncoder = new Encoder(7, 8, false, EncodingType.k4X);
        addChild("rightRearDriveEncoder",rightRearDriveEncoder);
        rightRearDriveEncoder.setDistancePerPulse(1.0);
        rightRearDriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveWithJoystick());

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
    	mecanumDrive.driveCartesian(0,speed,0,0);
    }
  
     
    public void driveWithJoystick(Joystick pJoystick) {
        // 2017 code has slow/fast speed which should look at adding & has x/y reversed (not sure why)
        mecanumDrive.driveCartesian(pJoystick.getY(), pJoystick.getX(), pJoystick.getTwist(),0);
    }
    
    public void driveStop() {
    	mecanumDrive.driveCartesian(0,0,0,0);
    }
}

