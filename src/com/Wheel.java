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
		return 0;
	}
	public void setPin(int p) {
		
	}
	
	public int getNotch() {
		return 0;
	}
	
	public void setNotch(int n) {
		
	}
	
	public int getFly() {
		return 0;
	}
	
	public void setFly(int f) {
		
	}
	
	private int pin;		/* Drive pin location in units */
	private int notch;      /* Notch location in units */
	private int fly;        /* Wheel fly location in units */
}
