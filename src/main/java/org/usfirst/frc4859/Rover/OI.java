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

import org.usfirst.frc4859.Rover.commands.AquireRetract;
import org.usfirst.frc4859.Rover.commands.CargoBall;
import org.usfirst.frc4859.Rover.commands.NoLift;
import org.usfirst.frc4859.Rover.commands.ClimbMode;
import org.usfirst.frc4859.Rover.commands.DeployAcquisition;
import org.usfirst.frc4859.Rover.commands.DeployCatapult;
import org.usfirst.frc4859.Rover.commands.DeployKickstand;
import org.usfirst.frc4859.Rover.commands.DriveToVisionTarget;
import org.usfirst.frc4859.Rover.commands.DriveWithXbox;
import org.usfirst.frc4859.Rover.commands.FlipMode;
import org.usfirst.frc4859.Rover.commands.LiftToHeight;
import org.usfirst.frc4859.Rover.commands.MidRocket;
import org.usfirst.frc4859.Rover.commands.TestingMode;
import org.usfirst.frc4859.Rover.commands.SetClimbTime;
import org.usfirst.frc4859.Rover.commands.StartClimb;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc4859.Rover.commands.LiftDown;
import org.usfirst.frc4859.Rover.commands.SwitchDriveMode;;

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
    public JoystickButton btnDeployCatapult;
    public JoystickButton btnFlipMode;
    public JoystickButton btnDriveVisionTarget;
    public JoystickButton btnStartClimb;
    public JoystickButton btnRetractAcquisition;
    public JoystickButton btnDeployAcquisition;
    public Joystick joystick;
    public JoystickButton setNoLift;
    public JoystickButton setCargoBall;
    public JoystickButton setClimbReady;
    public JoystickButton setClimbLow;
    public JoystickButton setClimbHigh;
    public JoystickButton manualDriveToHeight;
    public JoystickButton setTestingMode;
    public JoystickButton liftDown;
    public JoystickButton setMidRocket;
    public Joystick xBox;
    public JoystickButton switchToDriveMode;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public boolean tMode = false;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xBox = new Joystick(1);
//        switchToDriveMode = new JoystickButton(joystick, 7);
//        switchToDriveMode.whenPressed(new SwitchDriveMode());
        setMidRocket = new JoystickButton(xBox, 2);
        setMidRocket.whenPressed(new MidRocket());
        liftDown = new JoystickButton(xBox, 1);
        liftDown.whenPressed(new LiftDown());
        setTestingMode = new JoystickButton(xBox, 7);
        setTestingMode.toggleWhenPressed(new TestingMode());
        manualDriveToHeight = new JoystickButton(xBox, 9);
        manualDriveToHeight.whileHeld(new DriveWithXbox());
        setClimbHigh = new JoystickButton(xBox, 6);
        setClimbHigh.whenPressed(new SetClimbTime(5));
        setClimbLow = new JoystickButton(xBox, 5);
        setClimbLow.whenPressed(new SetClimbTime(2.5));
        setClimbReady = new JoystickButton(xBox, 10);
        setClimbReady.whenPressed(new ClimbMode());
        setCargoBall = new JoystickButton(xBox, 4);
        setCargoBall.whenPressed(new CargoBall());
        setNoLift = new JoystickButton(xBox, 3);
        setNoLift.whenPressed(new NoLift());
        joystick = new Joystick(0);
        
        btnDeployAcquisition = new JoystickButton(joystick, 6);
        btnDeployAcquisition.whileHeld(new DeployAcquisition());
        btnRetractAcquisition = new JoystickButton(joystick, 6);
        btnRetractAcquisition.whenReleased(new AquireRetract());
        btnStartClimb = new JoystickButton(joystick, 4);
        btnStartClimb.whenPressed(new StartClimb());
        btnDriveVisionTarget = new JoystickButton(joystick, 3);
        btnDriveVisionTarget.whileHeld(new DriveToVisionTarget());
        btnFlipMode = new JoystickButton(joystick, 2);
        btnFlipMode.toggleWhenPressed(new FlipMode());
        btnDeployCatapult = new JoystickButton(joystick, 1);
        btnDeployCatapult.whenPressed(new DeployCatapult());


        // SmartDashboard Buttons

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick() {
        return joystick;
    }

    public Joystick getXBox() {
        return xBox;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

