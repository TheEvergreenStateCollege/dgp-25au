Alexis Baker


Distributed Game Playing


Homework 9


12/12/2025


### Part 1: SimpleStartup Game Strategy


```
public class SimpleStartup {

    int[] locationCells;
    int numOfHits;

    String checkYourself(int guess) {
        if (guess < 0) {
            return ("miss");
        }
        for (int i = 0; i < locationCells.length; i++) {
            if (guess == locationCells[i]) {
                numOfHits += 1;
                locationCells[i] = -1;
                if (numOfHits == locationCells.length) {
                    return("kill!");
                }
                return("hit");
            }
        }
        return("miss");
    }

    void setLocationCells(int[] loc) {
        locationCells = loc;
        numOfHits = 0;
    }

    public void thisIsHowIWin() {
        int firstHitIndex = -1;

       for (int i = 0; i <= 6; i++) {
            System.out.println("Guessing: " + i);
            String result = checkYourself(i);
            System.out.println("Result: " + result);
            if (result.equals("hit") || result.equals("kill!")) {
                firstHitIndex = i;
                break;
            }
        }

        if (firstHitIndex == -1) {
            System.out.println("No hits found.");
            return;
        }

        for (int j = firstHitIndex + 1; j <= 6; j++) {
            System.out.println("Guessing: " + j);
            String result = checkYourself(j);
            System.out.println("Result: " + result);
            if (result.equals("miss")) break;
            if (result.equals("kill!")) return;
        }

        for (int j = firstHitIndex - 1; j >= 0; j--) {
            System.out.println("Guessing: " + j);
            String result = checkYourself(j);
            System.out.println("Result: " + result);
            if (result.equals("miss")) break;
            if (result.equals("kill!")) return;
        }
    }
    public static void main(String[] args) {
        SimpleStartup game = new SimpleStartup();
        game.setLocationCells(new int[]{3, 4, 5});

        game.thisIsHowIWin();
    }
}
```


### Part 2: Reading Questions

**Part A**

1. Declare and initialize the variables we need
2. Make three Startup objects, give ’em names, and stick ‘em in the ArrayList
3. Print brief instructions for user
4. Repeat with each Startup in the list
5. Ask the helper for a Startup location
6. Call the setter method on this Startup to give it the location you just got from the helper
7. As long as the Startup list is NOT empty
8. Get user input
9. Call our own checkUserGuess method
10. Call our own finishGame method
11. Increment the number of guesses the user has made
12. Assume it’s a ‘miss,’ unless told otherwise
13. Repeat with all Startups in the list
14. Ask the Startup to check the user guess, looking for a hit (or kill)
15. Get out of the loop early, no point in testing the others
16. This one’s dead, so take it out of the Startups list then get out of the loop
17. Print the result for the user
18. Print a message telling the user how they did in the game
19. Create the game object
20. Tell the game object to set up the game
21. Tell the game object to start the main game play loop (keeps asking for user input and checking the guess)


**Part B**

1. `add`, `get`, and `remove` are the three methods of the ArrayList type. `get` returns an item at a specific spot in the ArrayList, `add` adds an element to the end of the ArrayList, and `remove` removes the element at the specified index.
2. Three ways of knowing what classes are available in the Java API are the API documentation itself, an IDE's code completion tools, and also just knowing.


**Part C**

Can short-circuit operators be used in place of a loop?
