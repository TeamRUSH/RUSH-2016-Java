// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc27.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	/*
	* Motor Controllers
	*/
	public static CANTalon driveTrainLeftMotor1;
    public static CANTalon driveTrainLeftMotor2;
    public static CANTalon driveTrainLeftMotor3;
    public static CANTalon driveTrainRightMotor1;
    public static CANTalon driveTrainRightMotor2;
    public static CANTalon driveTrainRightMotor3;
    public static CANTalon shooterShooterWheel1;
    public static CANTalon shooterShooterWheel2;
	public static CANTalon armMotor;

	/*
	 * Pneumatic Solenoids
	 */
    public static DoubleSolenoid ballDeliveryBallDelivery1;
    public static DoubleSolenoid ballDeliveryBallDelivery2;
    public static DoubleSolenoid ballDeliveryBallDelivery3;

    /*
     * Sensors
     */
    public static DigitalInput bannerSensorBall;
    
    /*
     * Camera
     */   
    public static final String CAM_ID = "cam2";
    public static int camCounter = 0;
    public static final int IMAGE_QUALITY = 100;
    public static final int SAVE_IMAGE_QUALITY = 100;
    public static final String IMAGE_PATH = "/images/test.jpg";
    public static final int DISTANCE_CHANNEL = 0;
    public static final int CAMERA_SESSION = NIVision.IMAQdxOpenCamera(CAM_ID, NIVision.IMAQdxCameraControlMode.CameraControlModeController); 
    //this may need to change to "cam1" depending if using test board or multiple cameras
    //public static final Image FRAME = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    

    public static void init() {
    	SmartDashboard.putNumber("Camera Session: ", CAMERA_SESSION);
    	
        driveTrainLeftMotor1 = new CANTalon(12);
        LiveWindow.addActuator("DriveTrain", "LeftMotor1", driveTrainLeftMotor1);
        
        driveTrainLeftMotor2 = new CANTalon(14);
        //LiveWindow.addActuator("DriveTrain", "LeftMotor2", driveTrainLeftMotor2);
        
        driveTrainLeftMotor3 = new CANTalon(16);
        //LiveWindow.addActuator("DriveTrain", "LeftMotor3", driveTrainLeftMotor3);
        
        driveTrainRightMotor1 = new CANTalon(11);
        LiveWindow.addActuator("DriveTrain", "RightMotor1", driveTrainRightMotor1);
        
        driveTrainRightMotor2 = new CANTalon(13);
        //LiveWindow.addActuator("DriveTrain", "RightMotor2", driveTrainRightMotor2);
        
        driveTrainRightMotor3 = new CANTalon(15);
        //LiveWindow.addActuator("DriveTrain", "RightMotor3", driveTrainRightMotor3);
        
        armMotor = new CANTalon(18);
        LiveWindow.addActuator("Arm", "Arm Angle", armMotor);
        
        shooterShooterWheel1 = new CANTalon(20);
        LiveWindow.addActuator("Shooter", "ShooterWheel1", shooterShooterWheel1);
        
        shooterShooterWheel2 = new CANTalon(21);
        LiveWindow.addActuator("Shooter", "ShooterWheel2", shooterShooterWheel2);
        
        ballDeliveryBallDelivery1 = new DoubleSolenoid(2, 0, 1);
        LiveWindow.addActuator("BallDelivery", "BallDelivery1", ballDeliveryBallDelivery1);
        
        ballDeliveryBallDelivery2 = new DoubleSolenoid(2, 2, 3);
        LiveWindow.addActuator("BallDelivery", "BallDelivery2", ballDeliveryBallDelivery2);
        
        ballDeliveryBallDelivery3 = new DoubleSolenoid(2, 4, 5);
        LiveWindow.addActuator("BallDelivery", "BallDelivery3", ballDeliveryBallDelivery3);
        
        bannerSensorBall = new DigitalInput(0);
    }
}
