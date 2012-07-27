Locks
=====

### What is it?

Combinations Safe Lock is one of the design available for 100 years. This code is an object oriented modeling of the same using Java.
For simplicity, the lock consists of 3 wheels, 1 drive cam and 1 dial. A user has to turnthe  dial in clockwise 
or anticlockwise direction which turns the drive cam and leads to the movement of wheels from 
rear -> middle -> Front wheels.

In order to know more about the combinations lock, see the link below. Watch the flash animation on the page particularly.
http://home.howstuffworks.com/home-improvement/household-safety/security/combination-lock.htm

### How to Run 

In order to download, use the HTTPS link to clone the project repository on your system:
  
    git clone https://github.com/ashish-chopra/Locks.git

Import the project in Eclipse, compile it and in tests > com folder, find LockTest.java and AcceptanceTester.java which runs the test suites against Lock as, 

    java -ea LockTest             // to run unit tests of Lock
    java -ea AcceptanceTester     // to run acceptance tests suite
    
    
### License

This project is licensed under MIT License.