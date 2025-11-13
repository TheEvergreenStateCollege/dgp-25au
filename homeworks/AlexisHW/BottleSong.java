public class BeerSong {
    public static void main (String[] args) {
        int bottlesNum = 99;
        String word = "bottles";

        while (bottlesNum > 0) {

            if (bottlesNum == 1) {
                word = "bottle";
            }

            System.out.println(bottlesNum + " " + word + " of beer on the wall,");
            System.out.println(beerNum + " " + word + " of beer.");
            System.out.println("Take one down, pass it around,");
            beerNum = beerNum - 1;

            if (beerNum == 1) {
                word = "bottle";
            }

            if (beerNum > 0) {
                System.out.println(beerNum + " " + word + " of beer on the wall.");
            } else {
                System.out.println("Zero bottles of beer on the wall.");
            }
        }
    }
}