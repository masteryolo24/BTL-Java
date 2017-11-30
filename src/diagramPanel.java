import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class diagramPanel extends JPanel {
    public diagramPanel() {
//        repaint();
    }

    @Override
    public void paint(Graphics g) {
        int fontSize = 18, wordSize = 24, X1 = 100, Y1 = 100;
        Graphics2D g2D = (Graphics2D) g;
        g2D.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        // Background
        g2D.setColor(new Color(238,238,238));
        g2D.fillRect(0,0,1280,720);

        test test = new test();

        for(int i = 0; i < test.numberofClass(); i++) {
            g2D.setColor(new Color(255, 255, 179));
            g2D.fillRect(X1+1, Y1+1, 10*(test.longestStringLen[i])-1, wordSize*(test.numberClassAttributes[i] + test.numberClassMethods[i] + 1)-1);
            g2D.setColor(Color.BLACK);
            g2D.drawRect(X1, Y1, 10*(test.longestStringLen[i]), wordSize*(test.numberClassAttributes[i] + test.numberClassMethods[i] + 1));
            for(int j = 0; j < test.numberClassAttributes[i] + test.numberClassMethods[i] + 1; j++) {
                g2D.drawString(test.getInfo[i][j], X1+wordSize/2, Y1+wordSize);
                Y1 += wordSize;
            }

            X1 += 10*(test.longestStringLen[i]) + 50;
            Y1 = 100;
        }







//        g2.translate(640, 332.5);
//        g2.rotate(30.0 * Math.PI / 180.0);
//        g2.scale(0.5, 0.5);
//        g2.translate(-640, -332.5);

//        g2.setColor(Color.BLACK);
//        g2.drawRect(c, d, a, b);
//        g2.drawString("gdfg\n" +
//                "DFgdfg\n" +
//                "Dfg", (a + c) / 2, (b + d) / 2);
//        g2.drawLine(c, (b + d) / 2 + 10 , a+10, (b + d) / 2 + 10);

        repaint();
    }

    class mouseHandler extends MouseMotionAdapter implements
            MouseListener, MouseWheelListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }
    }

}

