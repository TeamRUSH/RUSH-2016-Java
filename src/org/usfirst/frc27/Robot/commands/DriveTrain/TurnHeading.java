package org.usfirst.frc27.Robot.commands.DriveTrain;

import org.usfirst.frc27.Robot.Robot;
import org.usfirst.frc27.Robot.subsystems.DriveTrain;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

 
public class TurnHeading extends Command {
	
	double requestedHeading;
	
    public TurnHeading(double heading ) {
        requires(Robot.driveTrain);
        requestedHeading = heading;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.turnToHeading(requestedHeading);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		//Robot.driveTrain.drive(-speed*direction,speed*direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	SmartDashboard.putNumber("Turn Error", Math.abs(Robot.driveTrain.getRobotHeading() - requestedHeading));
        return Math.abs(Robot.driveTrain.getRobotHeading() - requestedHeading) < .25;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}