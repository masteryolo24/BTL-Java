import javax.swing.*;

public class Menu {
    public static void main(String[] args) {
        JFrame f = new JFrame(); // Tao cua so cho app

        JButton b1 = new JButton("Analyze a class"); f.add(b1);
        JButton b2 = new JButton("Class"); f.add(b2);

        b1.setBounds(130, 100, 300, 40);
        b2.setBounds(130, 250, 100, 40);

        f.setSize(800, 600);
        f.setLayout(null); // K su dung Layout Manager
        f.setVisible(true);
    }
}
