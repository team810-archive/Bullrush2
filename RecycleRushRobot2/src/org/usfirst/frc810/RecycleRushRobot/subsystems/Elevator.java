// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc810.RecycleRushRobot.subsystems;

import org.usfirst.frc810.RecycleRushRobot.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Elevator extends PIDSubsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput lowSwitch = RobotMap.elevatorLowSwitch;
    DigitalInput highSwitch = RobotMap.elevatorHighSwitch;
    SpeedController elevatorSpeedController1 = (Talon) RobotMap.elevatorElevatorSpeedController1;
    AnalogInput analogPotentiometer1 = RobotMap.elevatorAnalogPotentiometer1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  

    // Initialize your subsystem here
    public Elevator() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("Elevator", 2.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(true);
        LiveWindow.addActuator("Elevator", "PIDSubsystem Controller", getPIDController());
      
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    
        // Set the default command for a subsystem here.
        //setDefaultCommand(new ElevatorRun());
    	
    }
    
    public void joystickrun(Joystick manipulator){
    	
    	double speed = 0;
    	double potentval = analogPotentiometer1.getVoltage();
    	boolean buttonpressed = false;
    	for (int button = 1; button <= 4; button ++){
    		if(manipulator.getRawButton(button)) buttonpressed = true;
    	}
    	if (buttonpressed){
    		if(manipulator.getRawButton(1))
    				speed = PotenOps.getValue(potentval, PotenOps.LOW_POSITION);
    		else if(manipulator.getRawButton(2))
    			speed = PotenOps.getValue(potentval, PotenOps.TOTE_2);
    		else if(manipulator.getRawButton(3))
    			speed = PotenOps.getValue(potentval, PotenOps.CAN_1);
    		else if(manipulator.getRawButton(4))
    			speed = PotenOps.getValue(potentval, PotenOps.CAN_2);
    	}
    	else{
    		speed = manipulator.getRawAxis(3) + manipulator.getRawAxis(1);
    		if (speed > 1) speed = 1;
    		if (speed < -1) speed = -1;


    		/* if (RobotMap.elevatorHighSwitch.get() && (RobotMap.elevatorLowSwitch.get() || RobotMap.elevatorWarningSwitch.get())){
        	speed = 0;
        } else if (RobotMap.elevatorLowSwitch.get()){
        	speed = -1;
       // } else if (RobotMap.elevatorWarningSwitch.get()){
      //  	speed = (oi.getmanipulator().getRawAxis(3) / 4);
        } else  if (RobotMap.elevatorHighSwitch.get()){
        	speed = 1;
        } else {
        	//speed = speed;
        } */

    		if (RobotMap.elevatorLowSwitch.get()){
    			speed = -1;
    		} else if(RobotMap.elevatorHighSwitch.get()) {
    			speed=1;
    		}

    		
    		
        if(speed>0) {
        	elevatorSpeedController1.set(.5*speed);
        	return;
        }/*
        else if(speed<0) {
        	elevcontroller.set(speed);
        }
        else {
        elevcontroller.set(speed);
        }
    		 */
    	}
    	((SafePWM) elevatorSpeedController1).setSafetyEnabled(true);
    	elevatorSpeedController1.set(speed);
    	
    }
    
    
    
    public double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return analogPotentiometer1.getVoltage();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        elevatorSpeedController1.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }
    
    public boolean setWithPID(double setpoint){
    	return true;
    }
    
    public void setWithPIDWait(double setpoint){
    	
    }
}
