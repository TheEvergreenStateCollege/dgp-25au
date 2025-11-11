package dog;

public class Dog {
    int size;
    String name;



    public void bark(){
        System.out.println((size > 60) ? "Woof Woof!" : (size > 14) ? "Ruff Ruff!" : "Yip Yip!");
    }
}
