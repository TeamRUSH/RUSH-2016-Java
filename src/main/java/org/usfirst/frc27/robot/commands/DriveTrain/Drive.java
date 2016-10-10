package org.usfirst.frc27.robot.commands.DriveTrain;

import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

 
public class Drive extends Command {

	public double speed=0.00;
	private double timeFinal = 0;
	private double seconds=0;
    public Drive(double vReq, double tReq) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        speed=vReq;
        seconds=tReq;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timeFinal=Timer.getFPGATimestamp()+seconds;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		Robot.driveTrain.drive(speed,speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timeFinal<=Timer.getFPGATimestamp()){
        	return true;
        }else{
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	((DriveTrain) Robot.driveTrain).drive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.drive(0,0);
    }
}