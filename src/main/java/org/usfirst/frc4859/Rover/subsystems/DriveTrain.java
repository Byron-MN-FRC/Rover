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


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import org.usfirst.frc4859.Rover.commands.DriveWithJoystick;
import org.usfirst.frc4859.Rover.utility.VisionTrackingPIDSource;

import edu.wpi.first.wpilibj.DigitalInput;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc4859.Rover.Robot;
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

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private VisionTrackingPIDSource pidSourceTargetSkew = 
        new VisionTrackingPIDSource(VisionTrackingPIDSource.DataSource.TargetSkew) ;
    private VisionTrackingPIDSource pidSourceTargetHorizontalOffset = 
        new VisionTrackingPIDSource(VisionTrackingPIDSource.DataSource.TargetHorizontalOffset);
    private VisionTrackingPIDSource pidSourceTargetAreaPercentage = 
        new VisionTrackingPIDSource(VisionTrackingPIDSource.DataSource.TargetAreaPercentage);

    private PIDOutput pidOutputSide2Side = new PIDOutput(){
        @Override
        public void pidWrite(double output) {
            Robot.driveTrain.pidOutApproach = output;
        }
    };
    private PIDOutput pidOutputRotation = new PIDOutput(){
        @Override
        public void pidWrite(double output) {
            pidOutRotation = output;
        }

    };
    private PIDOutput pidOutputApproach = new PIDOutput(){
    
        @Override
        public void pidWrite(double output) {
            System.out.print("pidOutputApproach"); System.out.println(output);
            pidOutApproach = output;
        }
    };
    
    public PIDController approachController = new PIDController(0.01, 0.0, 0.0, pidSourceTargetAreaPercentage, pidOutputApproach);
    private PIDController side2SideController = new PIDController(0.0, 0.0, 0.0, pidSourceTargetSkew, pidOutputSide2Side);
    private PIDController rotationController = new PIDController(0.0, 0.0, 0.0, pidSourceTargetHorizontalOffset, pidOutputRotation);

    private double pidOutSide2Side = 0;
    private double pidOutRotation = 0;
    public double pidOutApproach = 0;

    public boolean fMode = false; 

    public DriveTrain() {
        super("DriveTrain");
        LiveWindow.add(approachController);
        LiveWindow.add(mecanumDrive);

        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftFrontMotor = new WPI_TalonSRX(1);
        
        
        
        leftRearMotor = new WPI_TalonSRX(3);
        
        
        
        rightFrontMotor = new WPI_TalonSRX(2);
        
        
        
        rightRearMotor = new WPI_TalonSRX(4);
        
        
        
        mecanumDrive = new MecanumDrive(leftFrontMotor, leftRearMotor,
              rightFrontMotor, rightRearMotor);
        addChild("MecanumDrive",mecanumDrive);
        mecanumDrive.setSafetyEnabled(true);
        mecanumDrive.setExpiration(0.1);
        mecanumDrive.setMaxOutput(1.0);

        
        lidarProximity = new DigitalInput(1);
        addChild("lidarProximity",lidarProximity);
        
        
        pigeon = new PigeonIMU(12);
        
        
        

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
        double y = -pJoystick.getY();
		double x = pJoystick.getX();
        double twist = pJoystick.getTwist();
        
        if (fMode) {
			y *= -1;
			x *= -1;
		}
        // 2017 code has slow/fast speed which should look at adding & has x/y reversed (not sure why)
        mecanumDrive.setRightSideInverted(true);
        mecanumDrive.driveCartesian(x, y, twist,0);
        
    }

    public void driveToTargetWithVision(double xSpeed, double ySpeed, double zSpeed){
        mecanumDrive.driveCartesian(xSpeed, ySpeed, zSpeed);
    }
    public void driveStop() {
        mecanumDrive.driveCartesian(0,0,0,0);
    }
    
    public void driveForwardProximity(double speed) {
       if (lidarProximity.get()) {
           mecanumDrive.driveCartesian(0, 0, 0, 0);
       } else {
           mecanumDrive.driveCartesian(0, speed, 0, 0);
       }
    }
    public boolean getLidarProximity() {
       return lidarProximity.get();
    }


}

