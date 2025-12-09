public class EdgeOfTheWorldException extends Exception {
    
    public EdgeOfTheWorldException(String overTheEdgeCoord) {
        super("We can't go across the map edge to coord " + overTheEdgeCoord);
    }
}
