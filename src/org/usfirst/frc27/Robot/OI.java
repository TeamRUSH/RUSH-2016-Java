

package org.usfirst.frc27.Robot;

import org.usfirst.frc27.Robot.commands.*;
import org.usfirst.frc27.Robot.commands.Auton.AutonNoMovement;
import org.usfirst.frc27.Robot.commands.DriveTrain.TurnHeading;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
    public JoystickButton button_X;
    public JoystickButton button_A;
    public JoystickButton button_B;
    public JoystickButton button_Y;
    public JoystickButton bumper_Left;
    public JoystickButton bumper_Right;
    public JoystickButton trigger_Left;
    public JoystickButton trigger_Right;
    public JoystickButton button_Back;
    public JoystickButton button_Start;
    public JoystickButton stick_Left;
    public JoystickButton stick_Right;
    public Joystick leftJoystick;
    public Joystick rightJoystick;
    public Joystick logitechPad;
	private JoystickButton logitech_button_A;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        leftJoystick = new Joystick(0);
        rightJoystick = new Joystick(1);
        logitechPad = new Joystick(2);
        
        stick_Right = new JoystickButton(leftJoystick, 12);
        stick_Right.whileHeld(new AutonNoMovement());
        stick_Left = new JoystickButton(leftJoystick, 11);
        stick_Left.whileHeld(new AutonNoMovement());
        button_Start = new JoystickButton(leftJoystick, 10);
        button_Start.whileHeld(new AutonNoMovement());
        button_Back = new JoystickButton(leftJoystick, 9);
        button_Back.whileHeld(new AutonNoMovement());
        trigger_Right = new JoystickButton(leftJoystick, 8);
        trigger_Right.whileHeld(new AutonNoMovement());
        trigger_Left = new JoystickButton(leftJoystick, 7);
        trigger_Left.whileHeld(new AutonNoMovement());
        bumper_Right = new JoystickButton(leftJoystick, 6);
        bumper_Right.whileHeld(new AutonNoMovement());
        bumper_Left = new JoystickButton(leftJoystick, 5);
        bumper_Left.whileHeld(new AutonNoMovement());

        logitech_button_A = new JoystickButton(logitechPad, 2);
        logitech_button_A.whileHeld(new PneumaticTest());
        button_X = new JoystickButton(logitechPad, 1);
        button_X.whenPressed(new ArmToDrivePosition());
        button_B = new JoystickButton(logitechPad, 3);
        button_B.whenPressed(new ArmToUpPosition());
        button_Y = new JoystickButton(logitechPad, 4);
        button_Y.whenPressed(new TurnHeading(90));

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonNoMovement());

    }

    
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getLogitechPad() {
        return logitechPad;
    }    
    
}

