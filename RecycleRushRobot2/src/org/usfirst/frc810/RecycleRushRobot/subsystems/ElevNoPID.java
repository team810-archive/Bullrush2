package org.usfirst.frc810.RecycleRushRobot.subsystems;

import org.usfirst.frc810.RecycleRushRobot.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevNoPID extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    DigitalInput lowSwitch = RobotMap.elevatorLowSwitch;
    DigitalInput highSwitch = RobotMap.elevatorHighSwitch;
    SpeedController elevatorSpeedController1 = RobotMap.elevatorElevatorSpeedController1;
    AnalogInput analogPotentiometer1 = RobotMap.elevatorAnalogPotentiometer1;


    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void elevatorAUTO() {
    	
    }

	public void elevatorrun(Joystick manipulator) {
		double speed = manipulator.getRawAxis(3);
    	//if (speed > 1) speed = 1;
    	//if (speed < -1) speed = -1;
    	
    	if (lowSwitch.get() == true){
    		if(speed < 0)
    			elevatorSpeedController1.set(speed);
    	}else if(highSwitch.get() == true){
    		if(speed > 0)
    			elevatorSpeedController1.set(speed);
    	}else {
    		elevatorSpeedController1.set(speed);
    	}
		
	}
}

