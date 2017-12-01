import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Swing Hello World");

        // by doing this, we prevent Swing from resizing
        // our nice component
        f.setLayout(null);

        MyDraggableComponent mc = new MyDraggableComponent();
        f.add(mc);

        f.setSize(500, 500);

        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }

}