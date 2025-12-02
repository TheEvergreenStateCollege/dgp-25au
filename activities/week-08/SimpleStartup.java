public class SimpleStartup {
    
    int[] locations;
    int numOfHits = 3;

    public SimpleStartup() {
        this.numOfHits = 0;
    }

    public void setLocationCells(int[] locations) {
        this.locations = locations;
    }

    public String checkYourself(int cell) {
        if ((cell >= this.locations[0]) && (cell <= this.locations[2])) {
            numOfHits++;
            if (numOfHits == 3) {
                return "kill";
            }
            return "hit";
        }
        return "miss";
    }
}
