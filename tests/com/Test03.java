/* 
 * Design02 - Acceptance Tests
 * Author -  Rupert Shuttleworth 
 * Date - 7 March 2010
 * 
 */

package com;
 import com.Lock;
 public class Test03 implements Test {

   public String toString () {
      return "Test03 - moving all the wheels";
   }

   public void run () {
      Lock lock = new Lock (3,5,4,10,12,2);
      assert (!lock.isLocked());

      lock.turnAntiClockwise (15);
      // drive pin is at 5
      // rear pin is at 2
      // rear fly is at 4
      // middle pin is at 4
      // middle fly is at 10
      // front pin is at 12
      // front fly is at 2
      assert (lock.isLocked());

      // rear pin is being pushed (anti) by the drive pin
      lock.turnAntiClockwise (2);
      // drive pin is at 3
      // rear pin is at 0
      // rear fly is at 2
      // middle pin is at 4
      // middle fly is at 10
      // front pin is at 12
      // front fly is at 2
      assert (lock.isLocked());

      // rear pin is being pushed (anti) by the drive pin
      lock.turnAntiClockwise (10);
      // drive pin is at 13
      // rear pin is at 10
      // rear fly is at 12
      // middle pin is at 3
      // middle fly is at 9
      // front pin is at 12
      // front fly is at 2

      // middle pin just got nudged by 1
      assert (lock.isLocked());

      // drive is pushing the rear, pushing the middle, anticlockwise
      lock.turnAntiClockwise (3);
      // drive pin is at 10
      // rear pin is at 7
      // rear fly is at 9
      // middle pin is at 0
      // middle fly is at 6 
      // front pin is at 12
      // front fly is at 2
      assert (lock.isLocked());

      lock.turnAntiClockwise (18);
      // drive pin is at 12
      // rear pin is at 9 
      // rear fly is at 11 
      // middle pin is at 2
      // middle fly is at 8 
      // front pin is at 11
      // front fly is at 1
      // front pin just got nudged by 1
      assert (lock.isLocked());

      // now, want to start undoing...
      lock.turnClockwise (8);  // drive pin at 0
      assert (lock.isLocked());
      lock.turnClockwise (10); // drive pin touching rear fly
      assert (lock.isLocked());
      lock.turnClockwise (11); // rear pin at 0
      assert (lock.isLocked());
      lock.turnClockwise (7);  // rear pin touching the middle fly
      assert (lock.isLocked());
      lock.turnClockwise (18); // middle pin at 0
      assert (lock.isLocked());
      lock.turnClockwise (1);  // front wheel reset
      assert (lock.isLocked());      

      // drive pin is at 7
      // rear pin is at 6
      // rear fly is at 8
      // middle pin is at 1
      // middle fly is at 7

      // need to go anti now, to reset the middle pin
 
      lock.turnAntiClockwise (7);  // drive pin is at 0
      assert (lock.isLocked());
      lock.turnAntiClockwise (11); // drive pin is touching the rear fly
      assert (lock.isLocked());
      lock.turnAntiClockwise (6);  // rear pin is at 0
      assert (lock.isLocked());
      lock.turnAntiClockwise (12); // rear pin is touching the middle fly
      assert (lock.isLocked());
      lock.turnAntiClockwise (17);  // middle wheel reset
      assert (lock.isLocked());

      // drive pin is at 14
      // rear pin is at 11
      // rear fly is at 13

      // need to go clockwise now
      lock.turnClockwise (6); // drive is at 0
      assert (lock.isLocked());
      lock.turnClockwise (12); // drive is touching the rear fly
      assert (lock.isLocked());
      lock.turnClockwise (12); // rear wheel reset

      assert (!lock.isLocked());
   }
}
