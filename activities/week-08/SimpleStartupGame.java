import java.util.Scanner;

public class SimpleStartupGame {
  //Intialize an object of type SimpleStartup
  //Intialize an interger array of length 3 and feed it to the SimpleStartup SetLocationCells method
  //Declare a counter interger
  //Wrap everything in a while loop depending on results not equalling kill
    //Print a message asking the user for a guess and import the user input into an interger
    //Intalize the results variable and have its value be the result of feeding the interger guess into the checkYourself function  
    //Increment counter interger with each run through the loop
  //Print out the counter interger along with an explanation of the purpose
    public static void main (String[] args) {
        SimpleStartup dot =new SimpleStartup();

        int random = (int) (Math.random() * 5);

        int[] intArray = { random, random + 1, random + 2 };

        dot.setLocationCells(intArray);
        int counter = 0;
        Scanner scanner = new
        Scanner(System.in);

        String result = null;
        do {
            System.out.print("Submit a guess: ");
            int guess = scanner.nextInt();
            result = dot.checkYourself(guess);
            System.out.println(result);
        } while (!result.equals("kill!"));

    }
}
