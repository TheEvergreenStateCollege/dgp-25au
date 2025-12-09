public class GameHelperTestDrive {
    
    public static void main(String[] args) {
        CoordCalculator calc = new CoordCalculator();

        try {
            calc.getWest("c0");
            throw new RuntimeException("Should have thrown EOTWE for coord c(-1) ");
        } catch (EdgeOfTheWorldException eotwe) {
            System.out.println("Correct exception thrown " + eotwe.toString());
        }

        try {
            calc.getEast("c6");
            throw new RuntimeException("Should have thrown EOTWE for coord c7 ");
        } catch (EdgeOfTheWorldException eotwe) {
            System.out.println("Correct exception thrown " + eotwe.toString());
        }

        try {
            calc.getNorth("a3");
            throw new RuntimeException("Should have thrown EOTWE for coord a(-1) ");
        } catch (EdgeOfTheWorldException eotwe) {
            System.out.println("Correct exception thrown " + eotwe.toString());
        }

        try {
            calc.getSouth("g6");
            throw new RuntimeException("Should have thrown EOTWE for coord h6 ");
        } catch (EdgeOfTheWorldException eotwe) {
            System.out.println("Correct exception thrown " + eotwe.toString());
        }

        Strategy strategy = new Strategy();

        String move;
        do {
            move = Strategy.getUserInput();
            System.out.println(move);
        } while(!move.isEmpty());

    }
}
