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
}
