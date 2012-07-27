/* 
 * Design02 - Acceptance Tests
 * Author -  Rupert Shuttleworth 
 * Date - 7 March 2010
 * 
 */
package com;
 import com.Lock;
 public class Test02 implements Test {

   public String toString () {
      return "Test02 - moving the rear and middle wheels";
   }

   public void run () {
      Lock lock = new Lock (3,5,4,10,12,2);
      assert (!lock.isLocked());

      lock.turnClockwise (5);

      // rear pin now at 4
      // rear fly is now at 6
      assert (lock.isLocked());

      lock.turnClockwise (6);
      
      // middle pin is now at 5
      // middle fly is now at 11
      assert (lock.isLocked());

      // now want to move the rear pin back

      lock.turnAntiClockwise (11);
 
      // drive is back at 0
      assert (lock.isLocked());

      lock.turnAntiClockwise (14);
      // rear pin is back at 3
      // rear fly is back at 5

      assert (lock.isLocked());

      // middle pin never got moved back, so the lock is still locked

      // keep driving
      lock.turnAntiClockwise (3);
      assert (lock.isLocked());
   
      // drive pin is at 3
      // rear pin is at 0
      // rear fly is at 2
      // middle pin is at 5
      // middle fly is at 11
      // rear pin is being pushed (anti) by the drive

      lock.turnAntiClockwise (9);
      assert (lock.isLocked());
      // rear pin just moved the middle pin (anti) by 1

      // drive pin is at 14
      // rear pin is at 11
      // rear fly is at 13
      // middle pin is at 4
      // middle fly is at 10
      // rear pin is being pushed (anti) by the drive

      // now the middle pin has been reset
      // so far, the front pin hasn't been touched (hopefully)
      // but need to reset the rear pin as well
      // want the rear pin to be back at 3, rear fly back at 5 

      lock.turnClockwise (6);
      // drive pin is back at 0, nothing else got moved
      assert (lock.isLocked());
      
      lock.turnClockwise (13);
      // rear pin just moved (clockwise) by 1
      // rear pin is at 12
      // rear fly is at 14
      assert (lock.isLocked());
      
      lock.turnClockwise (11);
      // rear pin has been reset
      // lock should be unlocked now

      assert (!lock.isLocked());
   }
}
