package tests;

import com.Lock;

/*
 *  File: LockTest.java
 *  Date: 12 July, 2012
 *  Author: Ashish Chopra
 *  -----------------------------------------
 *  LockTest is a unit test suite testing all the interface
 *  functions of Lock class.
 *   
 */

public class LockTest {

	public static void main(String[] args) {
		
		System.out.println("Testing Lock...");
		testIsLocked();
		testTurnClockWise();
		testTurnAntiClockWise();
		System.out.println("All tests passed!! Woohoo..");
	}
	
	private static void testIsLocked() {
		
		Lock lock = new Lock(13, 3, 5, 4, 12, 2);
		assert (!lock.isLocked());  // lock is unlocked initially
		
	}
	private static void testTurnClockWise() {
		System.out.println("lock created....");
		Lock lock = new Lock(13, 3, 5, 4, 12, 2);
		assert (!lock.isLocked());  // lock is unlocked initially
		
		lock.turnClockwise(5);
	}
	
	private static void testTurnAntiClockWise() {
		
	}
}
