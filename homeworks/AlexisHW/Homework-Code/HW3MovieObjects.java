class Movie {
    String title;
    String genre;
    int rating;

    void playIt() {
        System.out.println("Playing the movie");
    }

}

public class MovieTestDrive {
    public static void main(String[] args) {
        Movie one = new Movie();
        one.title = "The Green Knight";
        one.genre = "Fable";
        one.rating = 10;
        Movie two = new Movie();
        two.title = "Life After BOB";
        two.genre = "Cerebral";
        two.rating = 7;
        two.playIt();
        Movie three = new Movie();
        three.title = "Confucian Confusion";
        three.genre = "Comedy";
        three.rating = 8;
    }
}


