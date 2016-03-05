

package org.usfirst.frc27.Robot;

import org.usfirst.frc27.Robot.commands.*;
import org.usfirst.frc27.Robot.commands.Auton.AutonNoMovement;
import org.usfirst.frc27.Robot.commands.DriveTrain.TurnFromHeading;

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

    public OI() {
   /*     leftJoystick = new Joystick(0);
        rightJoystick = new Joystick(1);
        logitechPad = new Joystick(2);
        
        //////////////////////////////////////////////////////////////////////////////////////////////
        //                                                                    ^                     //
        //                Mapping the buttons on the joy stick to their IDs   |                     //
        //      |----------Remember to add constructor at top                 |                     // 
        //      V                                                                                   //
        //////////////////////////////////////////////////////////////////////////////////////////////
        
        stick_Right = new JoystickButton(leftJoystick, 12);
        stick_Left = new JoystickButton(leftJoystick, 11);
        button_Start = new JoystickButton(leftJoystick, 10);
        button_Back = new JoystickButton(leftJoystick, 9);
        trigger_Left = new JoystickButton(leftJoystick, 1);
        trigger_Right = new JoystickButton(rightJoystick, 1);
        bumper_Right = new JoystickButton(leftJoystick, 6);
        bumper_Left = new JoystickButton(leftJoystick, 5);
        logitech_button_A = new JoystickButton(logitechPad, 2);
        button_X = new JoystickButton(logitechPad, 1);
        button_B = new JoystickButton(logitechPad, 3);
        button_Y = new JoystickButton(logitechPad, 4);
      
        //////////////////////////////////////////////////////////////////////////////////////////////
        //                                                                                          //
        //                Defining what code will be called when mapped buttons are pressed         //
        //                                                                                          //
        //////////////////////////////////////////////////////////////////////////////////////////////
        
        trigger_Right.whileHeld(new EnableShoot());
        button_X.whenPressed(new ArmToDrivePosition());
        button_B.whenPressed(new ArmToUpPosition());
        //button_Y.whenPressed(new TurnFromHeading(90));
   */
    }

  /*  
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getLogitechPad() {
        return logitechPad;
    }    
    */
    
}
