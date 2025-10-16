public class Shape {
    
    String name;

    public Shape(String name) {
        if (name == null) {
            this.name = "Generic Shape";
        } else {
            this.name = name;
        }
    }
    
    public void rotate(){
        System.out.println(this.name + " is being rotated.");
    }

    public void playSound(){
        System.out.println(this.name + " is having a sound played.");
    }


}
