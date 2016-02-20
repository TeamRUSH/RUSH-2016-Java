package org.usfirst.frc27.Robot.commands;

import org.usfirst.frc27.Robot.Robot;
import org.usfirst.frc27.Robot.RobotMap;
import org.usfirst.frc27.Robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

 
public class EnableShoot extends Command 
    { 
 
    public EnableShoot() 
        { 
        // Use requires() here to declare subsystem dependencies 
        requires(Robot.shooter); 
        } 
 
    // Called just before this Command runs the first time 
    protected void initialize() 
        { 
    	//	 Robot.ballDelivery.extend();
    	Robot.shooter.shooterOn();
        } 
 
    // Called repeatedly when this Command is scheduled to run 
    protected void execute() 
    {
    	//Robot.driveTrain.takeJoystickInputs(Robot.oi.getLeftJoystick(), Robot.oi.getRightJoystick());
		//Robot.ballDelivery.extend();
    	Robot.shooter.shooterOn();
    }
    
    // Make this return true when this Command no longer needs to run execute() 
    protected boolean isFinished() 
        { 
        return false; 
        } 
 
    // Called once after isFinished returns true 
    protected void end() 
        { 
        //Robot.driveTrain.stop(); 
		//Robot.ballDelivery.retract();    	
    	Robot.shooter.shooterOff();
        } 
 
    // Called when another command which requires one or more of the same 
    // subsystems is scheduled to run 
    protected void interrupted() 
        { 
        end(); 
        } 
    }
