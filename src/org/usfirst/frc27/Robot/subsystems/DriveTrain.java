// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc27.Robot.subsystems;

import org.usfirst.frc27.Robot.RobotMap;
import org.usfirst.frc27.Robot.commands.*;
import org.usfirst.frc27.Robot.commands.DriveTrain.Drive;
import org.usfirst.frc27.Robot.commands.DriveTrain.DriveWithJoysticks;
import org.usfirst.frc27.Robot.commands.DriveTrain.Turn;
import org.usfirst.frc27.Robot.Robot;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

    private final CANTalon _leftMaster = RobotMap.driveTrainLeftMotor1;
    private final CANTalon _leftSlave1 = RobotMap.driveTrainLeftMotor2;
    private final CANTalon _leftSlave2 = RobotMap.driveTrainLeftMotor3;
    private final CANTalon _rightMaster = RobotMap.driveTrainRightMotor1;
    private final CANTalon _rightSlave1 = RobotMap.driveTrainRightMotor2;
    private final CANTalon _rightSlave2 = RobotMap.driveTrainRightMotor3;

    private final RobotDrive robotDrive;  

	double sensitivity = 0.5;

    public DriveTrain()
    {
    	// super supplies the PID constants (.05, 0, 0)
    	super("DriveTrain", .05, 0, 0);
    	
    	robotDrive = new RobotDrive(_leftMaster, _rightMaster);
  
    	//Invert the appropriate controllers
    	//robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
    	robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    	    	
    	_leftSlave1.changeControlMode(TalonControlMode.Follower);
    	_leftSlave1.set(_leftMaster.getDeviceID());
    	_leftSlave2.changeControlMode(TalonControlMode.Follower);
    	_leftSlave2.set(_leftMaster.getDeviceID());
    	_rightSlave1.changeControlMode(TalonControlMode.Follower);
    	_rightSlave1.set(_rightMaster.getDeviceID());
    	_rightSlave2.changeControlMode(TalonControlMode.Follower);
       	_rightSlave2.set(_rightMaster.getDeviceID());
    	
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() 
    { 
	    // Set the default command for a subsystem here. 
	    setDefaultCommand(new DriveWithJoysticks()); 
    } 

    public void stop(){
    	robotDrive.drive(0, 0);
    }

    
    public void setSensitivity(double value){
    	sensitivity = value;
    }
    

    public double getSensitivity(){
    	return sensitivity;
    }

    
    public void takeJoystickInputs(Joystick leftJoystick, Joystick rightJoystick)
    {
    	//robotDrive.tankDrive(leftJoystick, rightJoystick);
    	SmartDashboard.putNumber("Sensitivity", 1-leftJoystick.getAxis(AxisType.kZ));
    	sensitivity = 1-leftJoystick.getAxis(AxisType.kZ);
    	robotDrive.tankDrive(leftJoystick.getAxis(AxisType.kY)*sensitivity, rightJoystick.getAxis(AxisType.kY)*sensitivity);
    }
    
        
    public void drive(double speedLeft, double speedRight) {
    	robotDrive.tankDrive(speedLeft*sensitivity, speedRight*sensitivity);
    }
    
    
   
    public void drive(double xSpeed, double ySpeed, double yThrottle) {
    	//myRobot.arcadeDrive(sensorIRX(ai.getVoltage(), ySpeed)*yThrottle, sensorIRY(ai.getVoltage(), xSpeed)*yThrottle, true);
    	robotDrive.arcadeDrive(ySpeed*yThrottle*sensitivity, xSpeed*yThrottle*sensitivity);
    	//System.out.println(ai.getVoltage());
    }

    public void perfectDrive(double moveValue, double rotateValue){
        double leftMotorSpeed;
        double rightMotorSpeed;
    	if (moveValue > 0.0) {
            if (rotateValue > 0.0) {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } else {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        } else {
            if (rotateValue > 0.0) {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            } else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }
    	
    	robotDrive.tankDrive(leftMotorSpeed*sensitivity, rightMotorSpeed*sensitivity);
    	//System.out.println("left: "+leftMotorSpeed+"--- right: "+rightMotorSpeed);
    }
    
    public void rotate(int Goal, int Power){
   	
    }
    
    public double getArmPosition() {
    	return _leftMaster.getAnalogInPosition();
    }
    
    

    public double getRobotHeading(){
    	return Robot.ahrs.getAngle();
    }

	public void resetHeading() {
		Robot.ahrs.reset();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}

