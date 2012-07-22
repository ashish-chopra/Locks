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
		System.out.println("Design02 unit tests starting....");
		
		boolean assertionsEnabled = false;
		try {
			assert (false);
		} catch (AssertionError ex) {
			assertionsEnabled = true;
		}
		
		if (!assertionsEnabled) {
			System.out.println("Please enable assertions, run with java -ea");
			System.out.println("TEST FAILED");
		}
		else {
			try {
				testIsLocked();
				testTurnClockWise();
				testTurnAntiClockWise();
				System.out.println("All tests passed!! Woohoo..");
				System.out.println("You are Awesome");
			} catch(Throwable t) {
				t.printStackTrace();
				System.out.println("TEST FAILED!");
				System.out.println("Not Accepted.");
			}
		}
	}
	
	private static void testIsLocked() {
		
		Lock lock = new Lock(13, 3, 5, 4, 12, 2);
		assert (!lock.isLocked());  // lock is unlocked initially
		
		lock = new Lock(2, 10, 4, 5, 12, 2);
		assert (!lock.isLocked());
		
	}
	private static void testTurnClockWise() {
		
		Lock lock = new Lock(13, 3, 5, 4, 12, 2);
		assert (!lock.isLocked());  // lock is unlocked initially
		
		lock.turnClockwise(1);
		assert (lock.getWheelPosition(0).equals("1:1:1"));
		assert(lock.getWheelPosition(1).equals("13:3:0"));
		assert(lock.getWheelPosition(2).equals("5:4:0"));
		assert(lock.getWheelPosition(3).equals("12:2:0"));
		
		
		lock.turnClockwise(5);
		assert(lock.getWheelPosition(0).equals("6:6:6"));
		assert(lock.getWheelPosition(1).equals("17:7:4"));
		assert(lock.getWheelPosition(2).equals("5:4:0"));
		assert(lock.getWheelPosition(3).equals("12:2:0"));
		
		lock.turnClockwise(10);
		assert(lock.getWheelPosition(0).equals("16:16:16"));
		assert(lock.getWheelPosition(1).equals("7:17:14"));
		assert(lock.getWheelPosition(2).equals("9:8:4"));
		assert(lock.getWheelPosition(3).equals("12:2:0"));
		
	}
	
	private static void testTurnAntiClockWise() {
		
	}
}
