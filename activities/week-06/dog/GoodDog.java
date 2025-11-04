package dog;

public class GoodDog {
    private int size;
    private String name;

    public GoodDog(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setSize(int newSize) {
        this.size = newSize;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
