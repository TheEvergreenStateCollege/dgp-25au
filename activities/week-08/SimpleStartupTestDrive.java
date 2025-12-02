public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        SimpleStartup ss = new SimpleStartup();

        int[] locations = new int[3];

        locations[0] = 3;
        locations[1] = 4;
        locations[2] = 5;

        ss.setLocationCells(locations);

        String result1 = ss.checkYourself(2);
        assert(result1.equals("miss"));
    }
}
