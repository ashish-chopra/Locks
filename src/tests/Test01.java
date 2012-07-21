/* 
 * 
 */
 package tests;

import com.Lock;
 
 public class Test01 implements Test {

   public String toString () {
      return "Test01 - moving only the rear wheel";
   }

   public void run () {
      Lock lock = new Lock (3,5,4,10,12,2);
      assert (!lock.isLocked());

      lock.turnClockwise (1);
      System.out.println(lock.toString());
      assert (!lock.isLocked());
      lock.turnAntiClockwise (1);
      System.out.println(lock.toString());

      // back to initial state
      assert (!lock.isLocked());
     
      lock.turnClockwise (4);
      System.out.println(lock.toString());
      assert (!lock.isLocked()); 
      lock.turnAntiClockwise (4);
      System.out.println(lock.toString());

      // back to initial state
      assert (!lock.isLocked());
      
      lock.turnClockwise (5);
      System.out.println(lock.toString());
      assert (lock.isLocked());
      lock.turnAntiClockwise (5);
      System.out.println(lock.toString());
      // back to initial state except the rear pin has moved clockwise by 1
      assert (lock.isLocked());
      
      lock.turnAntiClockwise (14);
      System.out.println(lock.toString());
      assert (!lock.isLocked());
      lock.turnClockwise (14);
      System.out.println(lock.toString());
      // back to initial state
      assert (!lock.isLocked());
   }
}
