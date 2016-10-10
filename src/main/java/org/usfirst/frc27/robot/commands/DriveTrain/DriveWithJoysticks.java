package org.usfirst.frc27.robot.commands.DriveTrain;

import org.usfirst.frc27.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

 
public class DriveWithJoysticks extends Command 
    { 
 
    public DriveWithJoysticks() 
        { 
         // Use requires() here to declare subsystem dependencies 
        requires(Robot.driveTrain); 
        //requires(Robot.vision);
        } 
 
    // Called just before this Command runs the first time 
    protected void initialize() 
        { 
         
        } 
 
    // Called repeatedly when this Command is scheduled to run 
    protected void execute()
    {
    	//Robot.driveTrain.takeJoystickInputs(Robot.oi.getLeftJoystick(), Robot.oi.getRightJoystick());
    	SmartDashboard.putNumber("Heading", Robot.driveTrain.getRobotHeading());
    	//SmartDashboard.putNumber("EncoderTest", Robot.driveTrain.getArmPosition());
    	Robot.vision.saveImage();
    	
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
