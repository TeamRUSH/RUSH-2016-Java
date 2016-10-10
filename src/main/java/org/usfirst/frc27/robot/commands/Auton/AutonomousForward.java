// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc27.robot.commands.Auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc27.robot.Robot;
import org.usfirst.frc27.robot.commands.DriveTrain.Drive;
import org.usfirst.frc27.robot.commands.DriveTrain.Turn;
import org.usfirst.frc27.robot.commands.DriveTrain.TurnToHeading;

/**
 *
 

/**
 *
 */
public class AutonomousForward extends CommandGroup {
    
    public  AutonomousForward() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
    	
        // SmartDashboard.getNumber("Turn To x Degree"
    	
    	//Normal
    	//addSequential(new Drive(.4, 2));
    	addSequential(new TurnToHeading(0.5, 60, Robot.TURN_RIGHT));
    	//addSequential(new TurnWithHeading(.5, 120, Robot.TURN_LEFT));
    	//addSequential(new Drive(-.4, 2));
    	
    }
}