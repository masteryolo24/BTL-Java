import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class diagramPanel extends JPanel {
    int getWidth;
    int getWeight;
    int X1;
    int Y1;

    public diagramPanel() {
//        repaint();
//        this.getWidth = getWidth();
//        this.getWeight = getWeight();
//        this.X1 = 100;
//        this.Y1 = 100;
    }

    @Override
    public void paint(Graphics g) {
        int fontSize = 18, wordHeight = 24, wordWidth = 10, lineSpace = 6, boxSpace = 50;
        int X1 = 100, Y1 = 100;
        Graphics2D g2D = (Graphics2D) g;

        // Background
        g2D.setColor(new Color(238,238,238));
        g2D.fillRect(0,0,1280,720);

        test test = new test();

        for(int i = 0; i < test.numberClass(); i++) {
            // Background rect
            g2D.setColor(new Color(255, 255, 220));
            g2D.fillRect(X1 + 1, Y1 + 1, wordWidth * (test.longestStringLen[i]) - 1, wordHeight * test.numberClassInfo[i] - 1 + wordHeight/2);
            // Border
            g2D.setColor(Color.BLACK);
            g2D.drawRect(X1, Y1, wordWidth * (test.longestStringLen[i]), wordHeight * test.numberClassInfo[i] + wordHeight/2);
            // Lines separate
            g2D.drawLine(X1, Y1 + wordHeight + lineSpace, X1 + wordWidth * (test.longestStringLen[i]) - 1, Y1 + wordHeight + lineSpace);
            g2D.drawLine(X1, Y1 + wordHeight * (test.numberClassAttributes[i] + 1) + lineSpace,  X1 + wordWidth * (test.longestStringLen[i]) - 1,Y1 + wordHeight * (test.numberClassAttributes[i] + 1) + 6);
            // Words
            g2D.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
            for(int j = 0; j < test.numberClassInfo[i]; j++) {
                if(j == 0)
                    g2D.drawString(test.getInfo[i][j], X1 + wordHeight/2 + (wordWidth * (test.longestStringLen[i]) - 1)/2 - wordWidth/2 * (test.getInfo[i][j].length() + 2), Y1 + wordHeight);
                else
                    g2D.drawString(test.getInfo[i][j], X1 + wordHeight / 2 - 5, Y1 + wordHeight);
                Y1 += wordHeight;
            }
            X1 += wordWidth * (test.longestStringLen[i]) + boxSpace;
            Y1 = 100;
        }
        setPreferredSize(new Dimension(X1 + wordWidth * (test.longestStringLen[test.numberClass - 1]) + 100,Y1 + wordHeight * test.maxNumberClassInfo + 100));
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

//    int getWidth() {
//
//    }
//    int getWeight() {
//
//    }

}

