import java.util.ArrayList;

public class StartupBust {
    
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    private void print(String x) {
        System.out.println(x);
    }

    private void setUpGame() {
        // make some startups and give them locations
        Startup one = new Startup("poniez");
        Startup two = new Startup("hacqui");
        Startup three = new Startup("cabista");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        print("Your goal is to sink three Startups.");
        print("poniez, hacqui, cabista");
        print("Try to sink them all in the fewest number of guesses");

        for (Startup startup : startups) {
            ArrayList<String> newLocation = helper.placeStartup(3);
            startup.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!startups.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void startStrategyPlaying() {
        Strategy strategy = new Strategy();
        String userGuess = "";
        String result = "";
        do {
            userGuess = strategy.getUserInput(result);
            System.out.println("Guessing " + userGuess);
            result = checkUserGuess(userGuess);
        } while (!startups.isEmpty() && !userGuess.isEmpty());

        if (!startups.isEmpty()) {
            System.out.println("Your strategy failed to sink all the startups. Try again!");
        } else {
            finishGame();
        }
    }

    private String checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for (Startup startupToTest : startups) {
            result = startupToTest.checkYourself(userGuess);

            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                startups.remove(startupToTest);
                break;
            }
        }
        return result;
    }

    private void finishGame() {
        print("All Startups are dead! Your stock is now worthless");
        if (numOfGuesses <= 18) {
            print("It only took you " + numOfGuesses + " guesses.");
            print("You got out before your options sank.");
        } else {
            print("Took you long enough. " + numOfGuesses + " guesses.");
            print("Fish are dancing with your options.");
        }
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setUpGame();
        game.startStrategyPlaying();
    }
}
