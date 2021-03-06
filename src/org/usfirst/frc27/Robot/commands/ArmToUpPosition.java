package org.usfirst.frc27.Robot.commands;

import org.usfirst.frc27.Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

 
public class ArmToUpPosition extends Command 
    { 
 
    public ArmToUpPosition() 
        { 
        // Use requires() here to declare subsystem dependencies 
        requires(Robot.arm); 
        } 
 
    // Called just before this Command runs the first time 
    protected void initialize() 
        { 
         	Robot.arm.setSetpoint(800);
        } 
 
    // Called repeatedly when this Command is scheduled to run 
    protected void execute()
    {
    	//Robot.arm.armOn();
    	//SmartDashboard.putNumber("EncoderTest", Robot.driveTrain.getArmPosition());
    }
    
    // Make this return true when this Command no longer needs to run execute() 
    protected boolean isFinished() 
        { 
        return Math.abs(Robot.arm.getSetpoint() - Robot.arm.getPosition()) < .1; 
        } 
 
    // Called once after isFinished returns true 
    protected void end() 
        { 
        //Robot.arm.armOff(); 
        } 
 
    // Called when another command which requires one or more of the same 
    // subsystems is scheduled to run 
    protected void interrupted() 
        { 
        end(); 
        } 
    }
