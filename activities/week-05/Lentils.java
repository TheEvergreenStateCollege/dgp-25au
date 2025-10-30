import java.awt.Color;

public class Lentils {
    int numberOfSeedsInPod;
    Color color;

    public Lentils(int numberOfSeedsInPod, Color color) {
        this.numberOfSeedsInPod = numberOfSeedsInPod;
        this.color = color;
    }

   public Lentils boil() {
    System.out.println("Now I'm in hot water!");
    return this;
   }

   public Lentils sprout() {
    System.out.println("Eat shoots and leaves!");
    return this;
   }
}
