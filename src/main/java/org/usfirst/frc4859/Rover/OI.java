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
    public JoystickButton button10LC;
    public JoystickButton button12DK;
    public JoystickButton button8GP;
    public JoystickButton button3AR;
    public JoystickButton button1AB;
    public JoystickButton button2SC;
    public Joystick joystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        button2SC = new JoystickButton(joystick, 2);
        button2SC.whenPressed(new StartClimb());
        button1AB = new JoystickButton(joystick, 1);
        button1AB.whileHeld(new AquireBall());
        button3AR = new JoystickButton(joystick, 3);
        button3AR.whenPressed(new AquireRetract());
        button8GP = new JoystickButton(joystick, 8);
        button8GP.whenPressed(new GroundPickup());
        button12DK = new JoystickButton(joystick, 12);
        button12DK.whenPressed(new DeployKickstand());
        button10LC = new JoystickButton(joystick, 10);
        button10LC.whenPressed(new LaunchCataplut());
        button9FM = new JoystickButton(joystick, 9);
        button9FM.whenPressed(new FlipMode());
        button7DH = new JoystickButton(joystick, 7);
        button7DH.whenPressed(new MoveHatch(1));
        button4LLV = new JoystickButton(joystick, 4);
        button4LLV.whenPressed(new LogLimelightValues());
        button5FP = new JoystickButton(joystick, 5);
        button5FP.whenPressed(new DriveForwardProximity(0, 0));
        button6VT = new JoystickButton(joystick, 6);
        button6VT.whileHeld(new DriveToVisionTarget());


        // SmartDashboard Buttons
        SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
        SmartDashboard.putData("DriveToVisionTarget", new DriveToVisionTarget());
        SmartDashboard.putData("MoveHatch: Vertical", new MoveHatch(1));
        SmartDashboard.putData("MoveHatch: NearGround", new MoveHatch(2));
        SmartDashboard.putData("MoveHatch: OnGround", new MoveHatch(3));
        SmartDashboard.putData("MoveHatch: Stowed", new MoveHatch(0));
        SmartDashboard.putData("FlipMode", new FlipMode());
        SmartDashboard.putData("DeployKickstand", new DeployKickstand());
        SmartDashboard.putData("ShiftGravity", new ShiftGravity());
        SmartDashboard.putData("AquireBall", new AquireBall());
        SmartDashboard.putData("AquireDeploy", new AquireDeploy());
        SmartDashboard.putData("DeployFeet", new DeployFeet());
        SmartDashboard.putData("StartClimb", new StartClimb());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
   
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

