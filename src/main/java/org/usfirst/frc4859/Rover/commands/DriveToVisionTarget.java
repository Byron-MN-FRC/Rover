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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4859.Rover.Robot;
import org.usfirst.frc4859.Rover.utility.*;
import org.usfirst.frc4859.Rover.utility.VisionTrackingPIDSource.DataSource;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4859.Rover.Robot;

/**
 *
 */
public class DriveToVisionTarget extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // #################################################################################################
    // Define the PID Source objects - These objects provide the PID loops with data from the individual
    // sensors.
    // #################################################################################################
    private DualLidarTrackingPIDSource pidSourceTargetLidar = 
        new DualLidarTrackingPIDSource() ;
    private VisionTrackingPIDSource pidSourceTargetHorizontalOffset = 
        new VisionTrackingPIDSource(VisionTrackingPIDSource.DataSource.TargetHorizontalOffset);
    private VisionTrackingPIDSource pidSourceTargetAreaPercentage = 
        new VisionTrackingPIDSource(VisionTrackingPIDSource.DataSource.TargetAreaPercentage);
    // #################################################################################################
    // #################################################################################################


    // #################################################################################################
    // The following variables will hold the pid output corrections for x, y, and z.
    // #################################################################################################
        private double pidOutSide2Side = 0; // x axis
        private double pidOutApproach = 0;  // y axis
        private double pidOutRotation = 0;  // z axis
    // #################################################################################################
    // #################################################################################################


    // #################################################################################################
    // Define the PID output objects - These objects provide the PID loops a storage location to store
    // the calculated pid value based on the input.
    // #################################################################################################
    private PIDOutput pidOutputSide2Side = new PIDOutput(){
        @Override
        public void pidWrite(double output) {
            pidOutSide2Side = output;
        }
    };
    private PIDOutput pidOutputRotation = new PIDOutput(){
        @Override
        public void pidWrite(double output) {
            //System.out.print("pidOutRotation=");System.out.println(pidOutRotation);
            pidOutRotation = -output;
        }

    };
    private PIDOutput pidOutputApproach = new PIDOutput(){

        @Override
        public void pidWrite(double output) {
            pidOutApproach = output;
        }
    };
    // #################################################################################################
    // #################################################################################################

    private PIDController approachController;   // Y Axis
    private PIDController side2SideController;  // X Axis
    private PIDController rotationController;   // Z Axis


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveToVisionTarget() {
        super("DriveToVisionTarget");
        
        approachController = new PIDController(0.1, 0.0, 0.0, pidSourceTargetAreaPercentage, pidOutputApproach);
        approachController.setName("drivetrain", "ApproachController");

        side2SideController = new PIDController(0.01, 0.0, 0.0, pidSourceTargetLidar, pidOutputSide2Side);
        side2SideController.setName("drivetrain", "side2SideController");

        rotationController = new PIDController(.02, 0.0, 0.0, pidSourceTargetHorizontalOffset, pidOutputRotation);
        rotationController.setName("drivetrain", "RotationController");
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
        LimelightUtility.RefreshTrackingData();
        System.out.println("DriveToVisiontarget initialize()");
        approachController.reset();
        approachController.setInputRange(0, 5);
        approachController.setOutputRange(0, 1);
        approachController.setSetpoint(4);
        approachController.enable();

        rotationController.reset();
        rotationController.setInputRange(-30, 30);
        rotationController.setOutputRange(-1, 1);
        rotationController.setSetpoint(0);
        rotationController.enable();

        side2SideController.reset();
        side2SideController.setInputRange(-60, 60);
        side2SideController.setOutputRange(-1, 1);
        side2SideController.setSetpoint(0);
        side2SideController.enable();
    }


    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        UpdateSmartDashboardValues();

        if (LimelightUtility.ValidTargetFound()){
            Robot.driveTrain.driveToTargetWithVision(
                this.pidOutSide2Side, this.pidOutApproach, this.pidOutRotation);
        }
        else
        {

        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        // When using whilepressed() you dont need to do the next line.  Interupted is called.
        // return (!Robot.oi.getJoystick().getRawButton(6));
        //return !LimelightUtility.ValidTargetFound();
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        System.out.println("DriveToVisiontarget End()");
        approachController.disable();
        rotationController.disable();
        side2SideController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        System.out.println("DriveToVisiontarget interrupted()");
        end();
    }

    private void UpdateSmartDashboardValues(){
        SmartDashboard.putData(approachController);
        SmartDashboard.putData(rotationController);
        SmartDashboard.putNumber("pidOutApproach",  this.pidOutApproach);
        SmartDashboard.putNumber("Camera Area",  LimelightUtility.TargetAreaPercentage);
        SmartDashboard.putNumber("pidOutSide2Side", this.pidOutSide2Side);
        SmartDashboard.putNumber("Straif (0 for now)",  0);
        SmartDashboard.putNumber("pidOutRotation",  this.pidOutRotation);
        SmartDashboard.putNumber("Horizontal Offset",  LimelightUtility.TargetHorizontalOffset);

    }
}
