import java.util.*;

public class Strategy {

    private int firstIndex;
    private String lastMove;

    private final static int FIRST_STAGE_COUNT = 16;
    private static String[] FIRST_STAGE_MOVES = new String[] {
        "a2", "a5", "b0", "b3", "b6", "c1", "c4", "d2", "d5", "e0", "e3", "e6", "f1", "f4", "g2", "g5"
    };

    public enum Modes {
        FIRST,
        SECOND_WEST,
        THIRD_WEST,
        SECOND_SOUTH,
        THIRD_SOUTH,
        SECOND_EAST,
        THIRD_EAST,
        SECOND_NORTH,
        THIRD_NORTH,
    }

    String move = "";
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

    private void goFirst() {
        if (firstIndex < FIRST_STAGE_COUNT) {
            int oldFirstIndex = firstIndex;
            firstIndex += 1;
            move = FIRST_STAGE_MOVES[oldFirstIndex];
            //return firstStageMoves.get(oldFirstIndex);
        }
    }

    private void goSecondWestWrapSecondSouth() {
        // Continue going west on the third stage
        try {
            move = CoordCalculator.getWest(lastMove);
            mode = Modes.SECOND_WEST;
        } catch(EdgeOfTheWorldException eotwe) {
            // We hit the edge of the map going west, so continue north
            goSecondSouthWrapSecondEast();
        }
    }

    private void goThirdWestWrapSecondEast() {
        // Continue going west on the third stage
        try {
            move = CoordCalculator.getWest(lastMove);
            mode = Modes.THIRD_WEST;
        } catch(EdgeOfTheWorldException eotwe) {
            // We hit the edge of the map going west, so the last location
            // must be east
            goEast(); // backtrack to our first stage hit in the "center"
            goSecondEastWrapError();
        }
    }

    /*
    private void goSecondEastWrapSecondNorth() {
        try {
            // we miss on West (the first time), continue to North
            move = CoordCalculator.getSouth(lastMove);
            mode = Modes.SECOND_SOUTH;
        } catch (EdgeOfTheWorldException eotwe) {
            // We can't go north, switch to south mode
            goSecondNorthWrapError();
        }
    }
     */

    private void goThirdNorthWrapSecondSouth() {
        // Continue going north on the third stage
        try {
            mode = Modes.THIRD_NORTH;
            move = CoordCalculator.getNorth(lastMove);
        } catch(EdgeOfTheWorldException eotwe) {
            // We hit the edge of the map going north on second hit, so the last location
            // must be south
            goSouth(); // backtrack to our first stage hit in the "center"
            goSecondSouthWrapError();
        }
    }

    private void goSecondEastWrapError() {
        try {
            move = CoordCalculator.getEast(lastMove);
            mode = Modes.SECOND_EAST;
        } catch (EdgeOfTheWorldException eotwe) {
            // This shouldn't happen!
            goFirst();
        }
    }

    private void goSecondEastWrapSecondNorth() {
        try {
            move = CoordCalculator.getEast(lastMove);
            mode = Modes.SECOND_EAST;
        } catch (EdgeOfTheWorldException eotwe) {
            // This shouldn't happen!
            goSecondNorthWrapError();
        }
    }


    private void goThirdEastWrapError() {
        try {
            move = CoordCalculator.getEast(lastMove);
            mode = Modes.SECOND_EAST;
        } catch (EdgeOfTheWorldException eotwe) {
            // This shouldn't happen!
            goFirst();
        }
    }

    private void goSecondNorthWrapError() {
        try {
            move = CoordCalculator.getNorth(lastMove);
            mode = Modes.SECOND_NORTH;
        } catch (EdgeOfTheWorldException eotwe) {
            // This shouldn't happen!
            goFirst();
        }
    }

    private void goSecondSouthWrapSecondEast() {
        try {
            move = CoordCalculator.getSouth(lastMove);
            mode = Modes.SECOND_SOUTH;
        } catch (EdgeOfTheWorldException eotwe) {
            goSecondEastWrapSecondNorth();
        }
    }

    private void goSecondSouthWrapError() {
        try {
            // we miss on West (the first time), continue to North
            move = CoordCalculator.getSouth(lastMove);
            mode = Modes.SECOND_SOUTH;
        } catch (EdgeOfTheWorldException eotwe) {
            // We can't go south anymore, but also didn't get a hit to the north.
            // This shouldn't happen! Oh well, go back to first stage
            goFirst();
        }
    }

    private void goThirdSouthWrapError() {
        try {
            // we miss on West (the first time), continue to North
            move = CoordCalculator.getSouth(lastMove);
            mode = Modes.THIRD_SOUTH;
        } catch (EdgeOfTheWorldException eotwe) {
            // We can't go south anymore, but also didn't get a hit to the north.
            // This shouldn't happen! Oh well, go back to first stage
            goFirst();
        }
    }

    private void goThirdSouthWrapSecondNorth() {
        try {
            // we miss on West (the first time), continue to North
            move = CoordCalculator.getSouth(lastMove);
            mode = Modes.THIRD_SOUTH;
        } catch (EdgeOfTheWorldException eotwe) {
            // We can't go south anymore, so go north
            // Going north shouldn't wrap. If it does, it's an error
            goNorth(); //backtrack to first stage hit in "center"
            goSecondNorthWrapError();
        }
    }


    public void goNorth() {
        try {
            lastMove = CoordCalculator.getNorth(lastMove);
        } catch (EdgeOfTheWorldException eotre) {
            System.err.println("Wrapping going north shouldn't happen");
        }
    }

    public void goSouth() {
        try {
            lastMove = CoordCalculator.getSouth(lastMove);
        } catch (EdgeOfTheWorldException eotre) {
            System.err.println("Wrapping going south shouldn't happen");
        }
    }

    public void goWest() {
        try {
            lastMove = CoordCalculator.getWest(lastMove);
        } catch (EdgeOfTheWorldException eotre) {
            System.err.println("Wrapping going west shouldn't happen");
        }
    }

    public void goEast() {
        try {
            lastMove = CoordCalculator.getEast(lastMove);
        } catch (EdgeOfTheWorldException eotre) {
            System.err.println("Wrapping going east shouldn't happen");
        }
    }


    public String getUserInput(String lastResult) {
        // By default, we signal the end of the game
        move = "";
        switch (mode) {
            case FIRST:
                if (lastResult.equals("hit")) {
                    goSecondWestWrapSecondSouth();
                } else {
                    goFirst();
                }
                break;
            case SECOND_WEST:
                if (lastResult.equals("kill")) {
                    goFirst();
                } else if (lastResult.equals("hit")) {
                    // continue west for third stage
                    goThirdWestWrapSecondEast();
                } else {
                    // miss
                    // backtrack to the first stage hit
                    goEast();
                    goSecondSouthWrapSecondEast();
                }
                break;
            case THIRD_WEST:
                if (lastResult.equals("kill")) {
                    goFirst();
                } else if (lastResult.equals("hit")) {
                    goFirst();
                } else {
                    goEast();
                    goEast();
                    goSecondEastWrapError();
                }
                break;
            case SECOND_NORTH:
                // TODO: Fill in your second stage strategy for exploring north of hitting a startup for the first time
                break;
            case SECOND_SOUTH:
                if (lastResult.equals("kill")) {
                    goFirst();
                } else if (lastResult.equals("hit")) {
                    // continue south for third stage
                    goThirdSouthWrapSecondNorth();
                } else {
                    // miss
                    // backtrack to the first stage hit
                    goNorth();
                    goSecondEastWrapSecondNorth();
                }
                break;
            case THIRD_SOUTH:
                if (lastResult.equals("kill")) {
                    goFirst();
                } else {
                    goNorth();
                    goNorth();
                    goSecondNorthWrapError();
                }
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