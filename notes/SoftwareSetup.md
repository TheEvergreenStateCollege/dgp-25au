# Software Setup

We will emulate a Unix development environment on Windows for this class, so you can develop in Java
directly on your home machines.

You can follow [this video](https://www.youtube.com/watch?v=tcDLevC7wmU) to see the major steps.

0. Go to Battlecode 2025's quickstart page. This is where you should return if in doubt.
   - https://play.battlecode.org/bc25java/home
   
1. Install Oracle's Java Development Kit 21.
   - https://www.oracle.com/java/technologies/downloads/#jdk21-windows 
   
2. Install Git-Bash via the Git For Windows package by downloading and running the installer from here

  https://gitforwindows.org/

3. Open up Git-Bash (or a MINGW64 terminal window).


4. Test your Java installation
```
	java -version
```

5. Clone the class repo (you'll need to create a github account first and submit your username as part of HW1 on Canvas)
```
git clone git@github.com:TheEvergreenStateCollege/dgp-25au.git
```

6. Change into your cloned directory and build the Battlecode client
```
cd dgp-25au/java
```

7. Update the game engine version and build it
```
./gradlew update
./gradlew build
```

8. Run the Battlecode client, by tab-completing to see what executable file was compiled, then press Enter
```
./client/<tab tab>
```

9. Try and run the `week01a` player against itself as shown at the end of our first class.

Bring any questions and problems you encounter to class next time.
