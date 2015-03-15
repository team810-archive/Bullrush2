package org.usfirst.frc810.RecycleRushRobot;

public class PotenOps {

	public static double LOW_POSITION = 4.62;
	public static double HIGH_POSITION = 4.12;
	public static double TOTE_2 = 3.95;
	public static double CAN_1 = 3.5;//
	public static double CAN_2 = 3.1;//
	public static double TOLERANCE = .02;//
	public static double invert = (HIGH_POSITION > LOW_POSITION) ? 1 : -1;
	
	public static double getValue(double potentval,double setval){
		if (Math.abs(setval-potentval) <= TOLERANCE) return 0;
		else if (setval > potentval) return (-1 * invert);
		else return (1 * invert);
	}
	
}
