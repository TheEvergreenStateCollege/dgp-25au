import java.util.*;

public class Strategy {

    private static int firstIndex = 0;

    private final static int FIRST_STAGE_COUNT = 16;
    private static List<String> firstStageMoves;

    public Strategy() {
        int[] firstStageIndices = new int[FIRST_STAGE_COUNT];
        for (int i = 0; i < FIRST_STAGE_COUNT; i += 1) {
            firstStageIndices[i] = (i*3) + 2; // Start with A2
        }
        firstStageMoves = GameHelper.convertCoordsToAlphaFormat(firstStageIndices);
        firstIndex = 0;
    }

    public static String getUserInput () {
        if (firstIndex < FIRST_STAGE_COUNT) {
            int oldFirstIndex = firstIndex;
            firstIndex += 1;
            return firstStageMoves.get(oldFirstIndex);
        } else {
            return "";
        }
    }



}