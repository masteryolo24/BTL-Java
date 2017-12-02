
/*
 * Output:
 *  
 */

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClassss extends JPanel {

    public void paint(Graphics g) {
        int xpoints[] = {100, 150, 200};
        int ypoints[] = {300, 250, 300};
        int npoints = 3;

        g.drawPolygon(xpoints, ypoints, npoints);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new MainClassss());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
}