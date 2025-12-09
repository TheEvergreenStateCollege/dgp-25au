public class CoordCalculator {
    
    public static String getWest(String coord) throws EdgeOfTheWorldException {
        String row = coord.substring(0,1); // first character
        int col = Integer.parseInt(coord.substring(1, 2)); // second character
        int newCol = col-1;
        String newCoord = row + Integer.valueOf(newCol).toString();
        if ((newCol < 0) || newCol > (GameHelper.GRID_LENGTH - 1)) {
            throw new EdgeOfTheWorldException(newCoord);
        }
        return newCoord;
    }

    public static String getEast(String coord) throws EdgeOfTheWorldException {
        String row = coord.substring(0,1); // first character
        int col = Integer.parseInt(coord.substring(1, 2)); // second character
        int newCol = col+1;
        String newCoord = row + Integer.valueOf(newCol).toString();
        if ((newCol < 0) || newCol > (GameHelper.GRID_LENGTH - 1)) {
            throw new EdgeOfTheWorldException(newCoord);
        }
        return newCoord;
    }

    public static String getNorth(String coord) throws EdgeOfTheWorldException {
        String row = coord.substring(0,1); // first character
        String col = coord.substring(1, 2); // second character
        int rowIndex = GameHelper.ALPHABET.indexOf(row);
        int newRowIndex = rowIndex - 1;
        if ((newRowIndex < 0) || newRowIndex > (GameHelper.GRID_HEIGHT - 1)) {
            throw new EdgeOfTheWorldException("Row " + newRowIndex + ", Col " + col);
        }
        String newRow = GameHelper.ALPHABET.substring(newRowIndex, newRowIndex+1);
        String newCoord = newRow + col;
        return newCoord;
    }


    public static String getSouth(String coord) throws EdgeOfTheWorldException {
        String row = coord.substring(0,1); // first character
        String col = coord.substring(1, 2); // second character
        int rowIndex = GameHelper.ALPHABET.indexOf(row);
        int newRowIndex = rowIndex + 1;
        if ((newRowIndex < 0) || newRowIndex > (GameHelper.GRID_HEIGHT - 1)) {
            throw new EdgeOfTheWorldException("Row " + newRowIndex + ", Col " + col);
        }
        String newRow = GameHelper.ALPHABET.substring(newRowIndex, newRowIndex+1);
        String newCoord = newRow + col;
        return newCoord;
    }


}
