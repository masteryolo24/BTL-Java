import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class DrawRect extends JPanel {

    int x, y, x2, y2;

    public static void main(String[] args) {
        JFrame f = new JFrame("Draw Box Mouse 2");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new DrawRect());
        f.setSize(300, 300);
        f.setVisible(true);
    }

    DrawRect() {
        x = y = x2 = y2 = 0; //
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public void setStartPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setEndPoint(int x, int y) {
        x2 = (x);
        y2 = (y);
    }

    public void drawPerfectRect(Graphics g, int x, int y, int x2, int y2) {
        int px = Math.min(x,x2);
        int py = Math.min(y,y2);
        int pw=Math.abs(x-x2);
        int ph=Math.abs(y-y2);
        g.drawRect(px, py, pw, ph);
    }

    class MyMouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            setStartPoint(e.getX(), e.getY());
        }

        public void mouseDragged(MouseEvent e) {
            setEndPoint(e.getX(), e.getY());
            repaint();
        }

        public void mouseReleased(MouseEvent e) {
            setEndPoint(e.getX(), e.getY());
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        drawPerfectRect(g, x, y, x2, y2);
    }

}