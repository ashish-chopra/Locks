/* 
 * Design02 - Acceptance Tests
 * Author -  Rupert Shuttleworth 
 * Date - 7 March 2010
 * 
 */
 package com;
 import com.Lock;
 public class Test04 implements Test {

   public String toString () {
      return "Test04 - pins and flys touching";
   }

   public void run () {
      Lock lock = new Lock (1,1,2,2,3,3);
      assert (!lock.isLocked());
 
      // lets move the front wheel
      lock.turnClockwise(1); // just moved all three wheels
      assert (lock.isLocked());

      // lets go all the way around
      lock.turnClockwise (19);      
      assert (!lock.isLocked());
   }
}
