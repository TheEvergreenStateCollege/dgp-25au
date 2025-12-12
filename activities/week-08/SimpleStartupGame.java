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

            guess = Scanner.nextInt();

            result = dot.checkYourself(guess);

            counter++;

            System.out.println("Your guess was: " + guess ", and the result was " + result + "!");
        }

        System.out.println("You sunk the startup in " + counter + " guesses!");
    }
}
