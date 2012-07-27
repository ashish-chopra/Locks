package com;
/**
 * Wheel class represents the wheels used in the combinations lock.
 * Each wheel has three things - <em>drive pin, wheel fly and notch.</em>
 * <br>
 * The size (circumference) of each wheel is set to be 20 units and
 * each pin is exactly one unit in size.
 * 
 * @author Ashish Chopra
 * @version 1.0
 */
public class Wheel {

	/* The size of the wheel as circumference in units */
	private static final int WHEEL_SIZE = 20;
	public static final int NOTCH_RESET_POSITION = 0;
	
	/**
	 * Constructor<br>
	 * Creates a new Wheel, provided the positions of pin, 
	 * fly, notch on the wheel.
	 *   
	 * @param pin position of the pin as int.
	 * @param fly position of the fly as int.
	 * @param notch position of the notch as int.
	 */
	public Wheel(int pin, int fly) {
		this.pin = pin;
		this.fly = fly;
		this.notch = NOTCH_RESET_POSITION;
	}
	
	/**
	 * gets the current position of the notch between 0-19.
	 * @return notch value as integer 
	 */
	public int getNotch() {
		return notch;
	}
	
	/**
	 * gets the current position of the pin between 0-19.
	 * @return pin value as integer
	 */
	public int getPin() {
		return pin;
	}
	
	/**
	 * gets the current position of fly between 0-19.
	 * @return fly value as integer.
	 */
	public int getFly() {
		return fly;
	}
	
	/**
	 * returns true if the notch of the wheel is at 0 position.
	 * @return true if notch is at 0 position, false otherwise.
	 */
	public boolean isOpen() {
		return (getNotch() == NOTCH_RESET_POSITION);
	}
	

	/**
	 * turns the wheel in clockwise direction by the given 
	 * distance in units. It also calculates the cascaded distance
	 * by which another wheel needs to be moved in same direction.
	 * 
	 * @param distance distance to move as integer
	 * @param fly_pos  fly value of another wheel whose distance 
	 * 		  needs to be calculated
	 * @return distance in units for other wheel to be moved in cascade
	 * 		   fashion.
	 */
	public int turnClockwise(int distance, int fly_pos) {
		int new_distance = 0;
		int start_pos = getPin();
		int gap = clockwiseDifference(start_pos, fly_pos);
		if (distance >= gap) {
			new_distance = distance - gap + 1;
		}
		clockwiseMove(distance);
		return new_distance;
	}
	
	/**
	 * turns the wheel in anti-clockwise direction by the given 
	 * distance in units. It also calculates the cascaded distance
	 * by which another wheel needs to be moved in same direction.
	 * 
	 * @param distance distance to move as integer
	 * @param fly_pos  fly value of another wheel whose distance 
	 * 		  needs to be calculated
	 * @return distance in units for other wheel to be moved in cascade
	 * 		   fashion.
	 */
	public int turnAntiClockwise(int distance, int fly_pos) {
		int new_distance = 0;
		int start_pos = getPin();
		int gap = antiClockwiseDifference(start_pos, fly_pos);
		if (distance >= gap) {
			new_distance = distance - gap + 1;
		}
		antiClockwiseMove(distance);
		return new_distance;
	}

	private void clockwiseMove(int delta) {
		delta = delta % WHEEL_SIZE;
		pin = pin + delta;
		fly = fly + delta;
		notch = notch + delta;
		pin = pin < WHEEL_SIZE ? pin : pin - WHEEL_SIZE;
		fly = fly < WHEEL_SIZE ? fly : fly - WHEEL_SIZE;
		notch = notch < WHEEL_SIZE ? notch : notch - WHEEL_SIZE;
	}
	
	private void antiClockwiseMove(int delta) {
		delta = delta % WHEEL_SIZE;
		pin = pin - delta;
		fly = fly - delta;
		notch = notch - delta;
		pin = pin < 0 ? WHEEL_SIZE + pin : pin;
		fly = fly < 0 ? WHEEL_SIZE + fly : fly;
		notch = notch < 0 ? WHEEL_SIZE + notch : notch;
	}
	
	/*
	 *  calculates the difference between two points on a
	 *  circular scale in clock wise direction.
	 */
	private int clockwiseDifference(int start, int end) {
		int d = end - start;
		return d < 0 ? WHEEL_SIZE + d : d;
	}
	
	/*
	 * calculates the difference between two points on a 
	 * circular scale in anti-clock wise direction.
	 */
	private int antiClockwiseDifference(int a, int b) {
		return WHEEL_SIZE - clockwiseDifference(a, b);
	}

	/**
	 * returns the string representation of the state of the wheel 
	 * in "pin:fly:notch" pattern
	 */
	public String toString() {
		return pin + ":" + fly + ":" + notch;
	}
	
	
	private int pin;		/* Drive pin location in units */
	private int notch;              /* Notch location in units */
	private int fly;   		/* Wheel fly location in units */
	
}
