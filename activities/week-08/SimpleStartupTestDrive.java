public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        SimpleStartup dot =new SimpleStartup();



        int[] intArray = {1, 2, 3};
        dot.setLocationCells(intArray);
        int guess = 3;
        String result = dot.checkYourself(guess);



        String strV = "failed";
        if (result == "hit") {
            System.out.println("it's working");
        } else {
            System.out.println("it's not working");
        }
    }

}
