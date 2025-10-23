import java.util.Random;

public class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    public void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1 = 0;
        int guessp2 = 0;
        int guessp3 = 0;

        boolean guessp1IsRight = false;
        boolean guessp2IsRight = false;
        boolean guessp3IsRight = false;

        int targetNumber = (int) (Math.random()*10);
        
        System.out.println("I'm thinking of a number between 0 and 9.");
        while (true) {
            System.out.println("Number to guess is: " + targetNumber);
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("Player 1 guessed: " + guessp1);
            guessp2 = p2.number;
            System.out.println("Player 2 guessed: " + guessp2);
            guessp3 = p3.number;
            System.out.println("Player 3 guessed: " + guessp3);

            if (guessp1 == targetNumber) {
                guessp1IsRight = true;
            }
            if (guessp2 == targetNumber) {
                guessp2IsRight = true;
            }
            if (guessp3 == targetNumber) {
                guessp3IsRight = true;
            }

            if (guessp1IsRight || guessp2IsRight || guessp3IsRight) {
                System.out.println("We have a winner!");
                System.out.println("Player 1 got it right? " + guessp1IsRight);
                System.out.println("Player 2 got it right? " + guessp2IsRight);
                System.out.println("Player 3 got it right? " + guessp3IsRight);
                System.out.println("Game is over!");
                break;
            } else {
                System.out.println("Players will have to try again!");
            }
        }
    }
}
