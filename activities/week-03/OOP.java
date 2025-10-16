import javax.swing.JFrame;
import javax.swing.JButton;

public class OOP {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
        Square square = new Square();
        square.rotate();
        Circle circle = new Circle();
        circle.rotate();
        Triangle triangle = new Triangle();
        triangle.playSound();
    }
}
