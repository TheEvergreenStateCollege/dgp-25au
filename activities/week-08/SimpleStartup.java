public class SimpleStartup {
    int[] locationCells;
    int numOfHits;



    String checkYourself(int guess) {
        for (int i = 0; i < locationCells.length; i++) {
            if (guess == locationCells[i]) {
                numOfHits += 1;
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
}
