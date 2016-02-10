package org.usfirst.frc27.Robot.commands.DriveTrain;

import org.usfirst.frc27.Robot.Robot;
import org.usfirst.frc27.Robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

 
public class TurnWithHeading extends Command {

	public double speed=0.00;
	private double timeFinal = 0;
	private double direction;
	private double curHeading;
	private double desiredHeading;
	
	
    public TurnWithHeading(double power, double headTo, int turnDirection) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        speed=power;
        desiredHeading=headTo;
        if (turnDirection == Robot.TURN_LEFT){
        direction=-1;
        }
        else {
        	direction=1;
        }
    }

    protected void initialize() {
    	timeFinal=Timer.getFPGATimestamp()+5;
    }
    protected void execute() {
    		Robot.driveTrain.drive(-speed*direction,speed*direction);
    		curHeading = Robot.driveTrain.getRobotHeading();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(curHeading - desiredHeading) < 10) {
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