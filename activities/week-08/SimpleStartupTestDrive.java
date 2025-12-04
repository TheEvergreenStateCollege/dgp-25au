public class SimpleStartupTestDrive {
    public static void main(String[] args) {

        SimpleStartup dot =new SimpleStartup();

        int[] intArray = {1, 2, 3};
        dot.setLocationCells(intArray);
        int[] guesses = new int[4];
        guesses[0] = 3;
        guesses[1] = 4;
        guesses[2] = 1;
        guesses[3] = 2;
    
        String[] results = new String[4];
        for (int i = 0; i < guesses.length; i++) {
            results[i] = dot.checkYourself(guesses[i]);
        }

        for (int i = 0; i < results.length; i++) {
            if (results[i] == "hit") {
                System.out.println("it's working");
            } else if (results[i] == "kill!") {
                System.out.println("it's KILLING");
            } else {
                System.out.println("it's not working");
            }
        }
    }

}
