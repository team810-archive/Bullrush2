package org.usfirst.frc810.RecycleRushRobot.commands;

import org.usfirst.frc810.RecycleRushRobot.Robot;
import org.usfirst.frc810.RecycleRushRobot.subsystems.DriveSystem;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAUTO extends Command {
	DriveSystem drivesystem;
    public DriveAUTO() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(4);
    	drivesystem = Robot.driveSystem;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivesystem.autoMode(0, 1,0,.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivesystem.autoMode(0,0,0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
