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

import org.usfirst.frc4859.Rover.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4859.Rover.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton button6VT;
    public JoystickButton button5FP;
    public JoystickButton button4LLV;
    public JoystickButton button7DH;
    public JoystickButton button9FM;
    public JoystickButton button10LB;
    public JoystickButton button11AS;
    public JoystickButton button12DK;
    public JoystickButton button8GP;
    public JoystickButton button3RS;
    public Joystick joystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        button3RS = new JoystickButton(joystick, 3);
        button3RS.whenPressed(new RetractSystem());
        button8GP = new JoystickButton(joystick, 8);
        button8GP.whenPressed(new GroundPickup());
        button12DK = new JoystickButton(joystick, 12);
        button12DK.whenPressed(new DeployKickstand());
        button11AS = new JoystickButton(joystick, 11);
        button11AS.whenPressed(new AquireSystem());
        button10LB = new JoystickButton(joystick, 10);
        button10LB.whenPressed(new LaunchBall());
        button9FM = new JoystickButton(joystick, 9);
        button9FM.toggleWhenPressed(new FlipMode());
        button7DH = new JoystickButton(joystick, 7);
        button7DH.whenPressed(new DeployHatch());
        button4LLV = new JoystickButton(joystick, 4);
        button4LLV.whenPressed(new LogLimelightValues());
        button5FP = new JoystickButton(joystick, 5);
        button5FP.whenPressed(new DriveForwardProximity(0, 0));
        button6VT = new JoystickButton(joystick, 6);
        button6VT.whenPressed(new DriveToVisionTarget());


        // SmartDashboard Buttons
        SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
        SmartDashboard.putData("DriveForwardTimed: FiveSeconds", new DriveForwardTimed(5, .4));
        SmartDashboard.putData("DriveForwardProximity: TenSeconds", new DriveForwardProximity(10000, .4));
        SmartDashboard.putData("DriveToVisionTarget", new DriveToVisionTarget());
        SmartDashboard.putData("LogLimelightValues", new LogLimelightValues());
        SmartDashboard.putData("DeployHatch", new DeployHatch());
        SmartDashboard.putData("RetractHatch", new RetractHatch());
        SmartDashboard.putData("FlipMode", new FlipMode());
        SmartDashboard.putData("LaunchBall", new LaunchBall());
        SmartDashboard.putData("AquireSystem", new AquireSystem());
        SmartDashboard.putData("DeployKickstand", new DeployKickstand());
        SmartDashboard.putData("ShiftGravity", new ShiftGravity());
        SmartDashboard.putData("GroundPickup", new GroundPickup());
        SmartDashboard.putData("GroundRetract", new GroundRetract());
        SmartDashboard.putData("LaunchRetract", new LaunchRetract());
        SmartDashboard.putData("RetractSystem", new RetractSystem());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

