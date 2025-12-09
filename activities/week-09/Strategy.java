import java.util.*;

public class Strategy {

    private int firstIndex;
    private String lastMove;

    private final static int FIRST_STAGE_COUNT = 16;
    private static String[] FIRST_MOVES = new String[] {
        "a2", "a5", "b0", "b3", "b6", "c1", "c4", "d2", "d5", "e0", "e3", "e6", "f1", "f4", "g2", "g5"
    };

    public enum Modes {
        FIRST,
        SECOND_WEST,
        SECOND_SOUTH,
        SECOND_EAST,
        SECOND_NORTH,
    }

    Modes mode;
    //private static List<String> firstStageMoves;

    public Strategy() {
        mode = Modes.FIRST;
        firstIndex = 0;
        lastMove = "";
        /*
        int[] firstStageIndices = new int[FIRST_STAGE_COUNT];
        for (int i = 0; i < FIRST_STAGE_COUNT; i += 1) {
            firstStageIndices[i] = (i*3) + 2; // Start with A2
        }
        firstStageMoves = GameHelper.convertCoordsToAlphaFormat(firstStageIndices);
        firstIndex = 0;
         */
    }

    public String getUserInput(String lastResult) {
        String move = "";
        switch (mode) {
            case FIRST:
                if (lastResult.equals("hit")) {
                    mode = Modes.SECOND_WEST;
                    try {
                        move = CoordCalculator.getWest(lastMove);
                        break;
                    } catch(EdgeOfTheWorldException eotwe) {
                        System.err.println(eotwe.toString());
                    }
                }
                if (firstIndex < FIRST_STAGE_COUNT) {
                    int oldFirstIndex = firstIndex;
                    firstIndex += 1;
                    move = FIRST_MOVES[oldFirstIndex];
                    //return firstStageMoves.get(oldFirstIndex);
                }
                break;
            case SECOND_WEST:
                if (lastResult.equals("kill")) {
                    mode = Modes.FIRST;
                    int oldFirstIndex = firstIndex;
                    firstIndex += 1;
                    move = FIRST_MOVES[oldFirstIndex];
                }
                if (lastResult.equals("hit")) {
                    // Continue going west
                    try {
                        move = CoordCalculator.getWest(lastMove);
                    } catch(EdgeOfTheWorldException eotwe) {
                        System.err.println(eotwe.toString());
                    }
                } else {
                    // Go to east on the opposite side of our first stage hit
                    try {
                        move = CoordCalculator.getEast(CoordCalculator.getEast(lastMove));
                    } catch(EdgeOfTheWorldException eotwe) {
                        System.err.println(eotwe.toString());
                    }
                }

                break;
            case SECOND_NORTH:
                // TODO: Fill in your second stage strategy for exploring north of hitting a startup for the first time
                break;
            case SECOND_SOUTH:
                // TODO: Fill in your second stage strategy for exploring south of hitting a startup for the first time
                break;
            case SECOND_EAST:
                // TODO: Fill in your second stage strategy for exploring east of hitting a startup for the first time
                break;
            default:
                System.out.println("Unknown mode");                
        }
        lastMove = move;
        return move;
    }



}