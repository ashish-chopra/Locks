package com;
/*
 *  File : Lock.java
 *  Date: 12 July, 2012
 *  Author: Ashish Chopra
 *  ----------------------------------------------------
 *  This code is the solution to design task 02 given in the class.
 */

/**
 * Lock class is a representation of combinations lock design 
 * which is used for 100 of years. This Lock consists of three wheels, 
 * each wheel has a notch, a drive pin and a wheel fly. In order to 
 * create a new lock, we specify the pin locations on wheels as,<br><br>
 * <code>
 * Lock = new Lock( rearPin, rearFly, 
 * 				    middlePin, middleFly, 
 * 				    frontPin, fronFly);
 * </code>  
 * <br><br>
 * where pin values lie between 0-19 as each wheel's circumference is 
 * of 20 units. The lock is unlocked when created, i.e. all notches 
 * and drive cam's notch are at 0 position.<br>
 * Each wheel corresponds to each number in the Lock code and 
 * these are represented as rear to front wheel from left to right 
 * direction.
 * 
 * @author Ashish Chopra
 * @version 1.0
 */
public class Lock {
	
	public Lock(int rearPin, int rearFly, 
				int middlePin, int middleFly,int frontPin, int frontFly) {

		rearWheel = new Wheel(rearPin, rearFly);
		middleWheel = new Wheel(middlePin, middleFly);
		frontWheel = new Wheel(frontPin, frontFly);
		driveCam = new Wheel(0, 0);
		
	}
	
	/**
	 * returns <code>true</code> if the lock is locked.
	 * @return <code>true</code> if the lock is locked, 
	 * <code>false</code> otherwise.
	 */
	public boolean isLocked() {
		return !(rearWheel.isOpen() && middleWheel.isOpen() && frontWheel.isOpen());
	}
	
	/**
	 * turns the lock wheels in clockwise direction by 
	 * the given number of units.
	 * @param units a positive <code>int</code> as number of units.
	 */
	public void turnClockwise(int units) {
		
		int a = driveCam.testMove(units, rearWheel.getFly());
		int b = rearWheel.testMove(a, middleWheel.getFly());
		int c = middleWheel.testMove(b, frontWheel.getFly());
		frontWheel.testMove(c, 0);
		
	}
	
	/**
	 * turns the lock wheels in anti clockwise direction by 
	 * the given number of units. 
	 * @param units a positive integer as number of units
	 */
	public void turnAntiClockwise(int units) {
		int a = driveCam.testAntiMove(units, rearWheel.getFly());
		int b = rearWheel.testAntiMove(a, middleWheel.getFly());
		int c = middleWheel.testAntiMove(b, frontWheel.getFly());
		frontWheel.testAntiMove(c, 0);
	}
	
	private Wheel rearWheel; 		/* represents the rear wheel of the lock */
	private Wheel middleWheel;      /* represents the middle wheel of the lock */
	private Wheel frontWheel;       /* represents the front wheel of the lock */
	private Wheel driveCam; 		/* a drive cam connected to dial, helps in turning wheels */
}
