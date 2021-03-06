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

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.*;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc27.Robot.commands.*;
import org.usfirst.frc27.Robot.commands.Auton.AutonBrandon;
import org.usfirst.frc27.Robot.commands.Auton.AutonCarson;
import org.usfirst.frc27.Robot.commands.Auton.AutonNoMovement;
import org.usfirst.frc27.Robot.commands.Auton.AutonomousForward;
import org.usfirst.frc27.Robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Preferences prefs;
	Command autonomousCommand;
    SendableChooser autoChooser;
    
    //CameraServer server;
    public static AHRS ahrs;
    public static OI oi;
    public static DriveTrain driveTrain;
    public static Shooter shooter;
    public static BallDelivery ballDelivery;
    public static Arm arm;
    public static Vision vision;
    public static final int TURN_LEFT = 0;
    public static final int TURN_RIGHT = 1;
    
    private double driveTrainP;
    private double driveTrainI;
    private double driveTrainD;
    
    public Robot() {
        try {
            /* Communicate w/navX MXP via the MXP SPI Bus.                                     
            Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     
            See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
            ahrs = new AHRS(SPI.Port.kMXP); 
            	
            SmartDashboard.putBoolean("isconnected", ahrs.isConnected());
            
        } catch (RuntimeException ex ) {
        	SmartDashboard.putString("Nav X", "Not Initialized");
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
        //ahrs.reset();
    }
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new DriveTrain();
        shooter = new Shooter();
        ballDelivery = new BallDelivery();
        arm = new Arm();
        vision = new Vision();
                
        //server = CameraServer.getInstance();
        //server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        //server.startAutomaticCapture("cam0");
        prefs = Preferences.getInstance();
		driveTrainP = prefs.getDouble("driveTrainP", 1.0);
		driveTrainI = prefs.getDouble("driveTrainI", 1.0);
		driveTrainD = prefs.getDouble("driveTrainD", 1.0);
		// OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
        
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Default Auton", new AutonomousForward());
        autoChooser.addDefault("Brandon's Auton", new AutonBrandon());
      //autoChooser.addDefault("(Program Name)", new (Program Name File)());
      //autoChooser.addDefault("(Program Name)", new (Program Name File)());

        
        SmartDashboard.putData("Selected Auton", autoChooser);

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        //autonomousCommand = new AutonNoMovement();
        autonomousCommand = new AutonCarson();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
