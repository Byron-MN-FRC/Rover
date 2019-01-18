// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4859.Rover.commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc4859.Rover.Robot;
import org.usfirst.frc4859.Rover.utility.*;
import org.usfirst.frc4859.Rover.utility.VisionTrackingPIDSource.DataSource;

/**
 *
 */
public class DriveToVisionTarget extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    private VisionTrackingPIDSource pidSourceTargetSkew = new VisionTrackingPIDSource(DataSource.TargetSkew) ;
    private VisionTrackingPIDSource pidSourceTargetHorizontalOffset = new VisionTrackingPIDSource(DataSource.TargetHorizontalOffset);
    private VisionTrackingPIDSource pidSourceTargetAreaPercentage = new VisionTrackingPIDSource(DataSource.TargetAreaPercentage);

    private PIDOutput pidOutputSide2Side = new PIDOutput(){
        @Override
        public void pidWrite(double output) {
            pidOutSide2Side = output;
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
            pidOutApproach = output;
        }
    };
    
    private PIDController approachController = new PIDController(0.0, 0.0, 0.0, pidSourceTargetAreaPercentage, pidOutputApproach);
    private PIDController side2SideController = new PIDController(0.0, 0.0, 0.0, pidSourceTargetSkew, pidOutputSide2Side);
    private PIDController rotationController = new PIDController(0.0, 0.0, 0.0, pidSourceTargetHorizontalOffset, pidOutputRotation);

    private double pidOutSide2Side = 0;
    private double pidOutRotation = 0;
    private double pidOutApproach = 0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveToVisionTarget() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        approachController.enable();
        //side2SideController.enable();
        //rotationController.enable();

        approachController.setInputRange(0, 100);
        approachController.setOutputRange(0, 1);

        LiveWindow.add(approachController);
        //LiveWindow.add(side2SideController);
        //LiveWindow.add(rotationController);
        System.out.println("Init");
    }


    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        System.out.println("isFinished");
        // When using whilepressed() you dont need to do the next line.  Interupted is called.
        // return (!Robot.oi.getJoystick().getRawButton(6));
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        System.out.println("end");
        side2SideController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        System.out.println("interupted");

        end();
    }
}
