import java.awt.Color;

public class Rutabaga {
    int numberOfRoots;
    Color color;

    public Rutabaga(int numberOfRoots, Color color) {
        this.numberOfRoots = numberOfRoots;
        this.color = color;
    }

    public Rutabaga boil() {
        System.out.println("Now I'm in hot water.");
        return this;
    }

    public Rutabaga mash() {
        System.out.println("It was a smashing success!");
        return this;
    }
}
