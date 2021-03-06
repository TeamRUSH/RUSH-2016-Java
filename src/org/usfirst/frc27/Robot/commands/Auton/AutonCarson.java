// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc27.Robot.commands.Auton;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc27.Robot.Robot;
import org.usfirst.frc27.Robot.commands.DriveTrain.Drive;
import org.usfirst.frc27.Robot.commands.DriveTrain.Turn;

/**
 *
 */

/**
 *
 */
public class AutonCarson extends CommandGroup {
    
    public  AutonCarson() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//Normal
    	
    	addSequential(new Turn(0.5, 2, Robot.TURN_LEFT));
    	addSequential(new Drive(0.3, 1));
    	addSequential(new Turn(0.5, 2, Robot.TURN_RIGHT));
    	addSequential(new Drive(-0.4, 1));
    	addSequential(new Turn(0.5, 5, Robot.TURN_LEFT));
    	addSequential(new Turn(0.3, 8, Robot.TURN_RIGHT));
    	
    	
    }
}