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
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4859.Rover.Constants;
import org.usfirst.frc4859.Rover.Robot;

/**
 *
 */
public class FireCatapult extends Command {

    private double speed;
    private double time;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public FireCatapult() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.catapult);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        speed = Constants.kUpSpeed;
        if (speed > 1) {  speed = 1; }
        System.out.println("UpSpeed = " + speed);
        time = Constants.kUpTime;
        if (time > 1.5) {  time = 1.5; }
        System.out.println("Uptime = " + time);
        setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.catapult.move(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.catapult.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}