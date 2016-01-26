package org.usfirst.frc27.Robot.commands;

import org.usfirst.frc27.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

 
public class DriveWithJoystick extends Command 
    { 
 
    public DriveWithJoystick() 
        { 
        // Use requires() here to declare subsystem dependencies 
        // eg. requires(chassis); 
        requires(Robot.driveTrain); 
        } 
 
    // Called just before this Command runs the first time 
    protected void initialize() 
        { 
         
        } 
 
    // Called repeatedly when this Command is scheduled to run 
    protected void execute() 
        { 
        //Robot.driveTrain.tankDrive(Robot.oi.get .getLeftDrivePower(), Robot.oi.getRightJoystick_XAxis()); 
        } 
 
    // Make this return true when this Command no longer needs to run execute() 
    protected boolean isFinished() 
        { 
        return false; 
        } 
 
    // Called once after isFinished returns true 
    protected void end() 
        { 
        Robot.driveTrain.stop(); 
        } 
 
    // Called when another command which requires one or more of the same 
    // subsystems is scheduled to run 
    protected void interrupted() 
        { 
        end(); 
        } 
    }
