Alexis Baker


Distributed Game Playing


Homework 8


12/12/2025


### Part 1: Finish SimpleStartupGame


```
import java.util.Scanner;

public class SimpleStartupGame {

    public static void main (String[] args) {
        SimpleStartup dot =new SimpleStartup();

        int random = (int) (Math.random() * 5);
        int[] locations = { random, random + 1, random + 2 };
        dot.setLocationCells(locations);

        int counter = 0;
        Scanner scanner = new
        Scanner(System.in);
        String result = "";
        int guess = -1;

        while (!result.equals("kill!")) {
            System.out.print("Submit a guess: ");

            guess = scanner.nextInt();

            result = dot.checkYourself(guess);

            counter++;

            System.out.println("Your guess was: " + guess + ", and the result was a " + result + "!");
        }

        System.out.println("You sunk the startup in " + counter + " guesses!");
    }
}
```


### Part 2: Finish StartupGame


GameHelper, Startup, and StartupBust files are in my HW folder.


### Part 3: Reading Questions


**Chapter 5 Questions**


1. So is prep/test code just an elaborated version of pseudocode? How does it differentiate from the final code?
2. How would you design a Java class to represent an immutable object?
3. How would you prevent an invalid state when setting values?


**Chapter 6 Questions**


1. What the hell is an API?
2. How do I _know_ when I need to use something from the Java library?
3. How do I _know_ when things like ArrayList exist?
