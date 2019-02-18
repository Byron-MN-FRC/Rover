// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4859.Rover;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4859.Rover.commands.*;
import org.usfirst.frc4859.Rover.subsystems.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import org.usfirst.frc4859.Rover.utility.LimelightUtility;
import org.usfirst.frc4859.Rover.utility.LimelightUtility.StreamMode;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    public static UsbCamera cameraForward = CameraServer.getInstance().startAutomaticCapture("Forward" , 0 );
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain driveTrain;
    public static BallAcquisition ballAcquisition;
    public static Catapult catapult;
    public static Hatch hatch;
    public static Climb climb;
    public static Lift lift;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        ballAcquisition = new BallAcquisition();
        catapult = new Catapult();
        hatch = new Hatch();
        climb = new Climb();
        lift = new Lift();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        LimelightUtility.EnableDriverCamera(true);
      //  SmartDashboard.putBoolean("PJACS",driveTrain.getLidarProximity());
        
        cameraForward.setVideoMode(VideoMode.PixelFormat.kMJPEG, 320, 340, 10);
        
        cameraForward.setExposureManual(50);

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.addObject("DriveWithJoystick", new DriveWithJoystick());
        chooser.addObject("DriveToVisionTarget", new DriveToVisionTarget());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
        LiveWindow.add(driveTrain);
      //  SmartDashboard.putBoolean("PJACS",driveTrain.getLidarProximity());
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        //Robot.climb.getKickstand().set(Value.kReverse);

    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        LimelightUtility.RefreshTrackingData();
        Scheduler.getInstance().run();
        // SmartDashboard.putNumber("SensorVel", Robot.climb.getFeetMotor().getSelectedSensorVelocity(Constants.kPIDLoopIdx));
        // SmartDashboard.putNumber("SensorPos",  Robot.climb.getFeetMotor().getSelectedSensorPosition(Constants.kPIDLoopIdx));
        // SmartDashboard.putNumber("MotorOutputPercent",  Robot.climb.getFeetMotor().getMotorOutputPercent());
        // SmartDashboard.putNumber("ClosedLoopError",  Robot.climb.getFeetMotor().getClosedLoopError(Constants.kPIDLoopIdx));
        //SmartDashboard.putBoolean("Vision Taget Found", LimelightUtility.ValidTargetFound());
        // int smode = (int) SmartDashboard.getNumber("Streaming Mode", 0);
        // switch (smode){
        //     case 0: LimelightUtility.StreamingMode(StreamMode.Standard);
        //         break;
        //     case 1: LimelightUtility.StreamingMode(StreamMode.PIPMain);
        //         break;
        //     case 2: LimelightUtility.StreamingMode(StreamMode.PIPSecondary);
        //         break;
        //     default: LimelightUtility.StreamingMode(StreamMode.Standard);
        // }
        SmartDashboard.putBoolean("Ready to Climb", Robot.climb.cMode);
        SmartDashboard.putBoolean("Flip Mode", Robot.driveTrain.fMode);
    }
}
