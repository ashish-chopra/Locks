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
	
	public int getPin() {
		return this.pin;
	}
	public void setPin(int p) {
		this.pin = p;
	}
	
	public int getNotch() {
		return this.notch;
	}
	
	public void setNotch(int n) {
		this.notch = n;
	}
	
	public int getFly() {
		return this.fly;
	}
	
	public void setFly(int f) {
		this.fly = f;
	}
	
	public boolean isOpen() {
		return (getNotch() == NOTCH_RESET_POSITION);
	}
	
	public void clockwiseMove(int delta) {
		delta = delta % 20;
		pin = pin + delta;
		fly = fly + delta;
		notch = notch + delta;
		pin = pin < 20 ? pin : pin - 20;
		fly = fly < 20 ? fly : fly - 20;
		notch = notch < 20 ? notch : notch - 20;
	}
	
	public void antiClockwiseMove(int delta) {
		delta = delta % 20;
		pin = pin - delta;
		fly = fly - delta;
		notch = notch - delta;
		pin = pin < 0 ? 20 - pin : pin;
		fly = fly < 0 ? 20 - fly : fly;
		notch = notch < 0 ? 20 - notch : notch;
	}
	
	public int turnClockwise(int distance, int fly_pos) {
		int new_distance = 0;
		int start_pos = getPin();
		int gap = cyclicDifference(start_pos, fly_pos);
		if (distance >= gap) {
			new_distance = distance - gap + 1;
		}
		clockwiseMove(distance);
		return new_distance;
	}
	
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
	
	private int cyclicDifference(int a, int b) {
		int c = b - a;
		return c < 0 ? 20 + c : c;
	}
	
	private int antiClockwiseDifference(int a, int b) {
		int c = b - a;
		return c < 0 ?  -c : 20 - c;
	} 
	
	private int pin;		/* Drive pin location in units */
	private int notch;      /* Notch location in units */
	private int fly;   		/* Wheel fly location in units */
	
	public String toString() {
		return "pin : " + pin + "fly : " + fly + "notch : " + notch;
	}
}
