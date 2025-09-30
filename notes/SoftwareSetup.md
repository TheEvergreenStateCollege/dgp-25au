# Software Setup

We will emulate a Unix development environment on Windows for this class, so you can develop in Java
directly on your home machines.

1. Install Git-Bash via the Git For Windows package by downloading and running the installer from here
  https://gitforwindows.org/

2. Install the MSYS2 package system for Git-Bash
 
3. Open up Git-Bash (or a MINGW64 terminal window).

4. Update package definitions with pacman package manager.
```
pacman -Sy
```

5. Install `zip`, `unzip`, and `git`
```
pacman -S zip unzip git
```

6. Install SDKman, which lets you choose from different development languages.
```
	curl -s "https://get.sdkman.io" | bash
```

7. Use SDKman to install Java
```
	sdk install java 24.0.2-graalce
```

8. Test your Java installation
```
	java -version
```

9. Clone the class repo (you'll need to create a github account first and submit your username as part of HW1 on Canvas)
```
git clone git@github.com:TheEvergreenStateCollege/dgp-25au.git
```

10. Change into your cloned directory and build the Battlecode client
```
cd dgp-25au
./gradlew build
```

11. Run the Battlecode client, by tab-completing to see what executable file was compiled, then press Enter
```
./client/<tab tab>
```

12. Try and run the `week01a` player against itself as show at the end of our first class.

Bring any questions and problems you encounter to class next time.
