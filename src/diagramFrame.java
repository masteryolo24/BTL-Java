import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class diagramFrame extends JFrame {
    diagramPanel diagram = new diagramPanel();
    int X1 = 100, Y1 = 100;
    int fontSize = 18, wordHeight = 24, wordWidth = 10, lineSpace = 6, boxSpace = 50;
    int screenX = 0, screenY = 0;
    int i;
    int ARR_SIZE = 10;

    public diagramFrame() {

        // Size and name of JFrame
        super("Java SE Project Reader");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 720));
        diagram.updateLocation();
        // Scrollpane
        JScrollPane scrollPane = new JScrollPane(diagram, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Add to frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Init JFrame
        setResizable(true);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }


    class diagramPanel extends JPanel {
        int[][] rectLocation;
        double scale = 1;
        double width = 1280, height = 720;


        public diagramPanel() {
            // Add printscreen, zoom in, zoom out keys to diagram
            addKeyListener(new MyKeyListener());
            setFocusable(true);

            // Add drag components to diagram
            mouseHandler mouseHandler = new mouseHandler();
            addMouseMotionListener(mouseHandler);
            addMouseListener(mouseHandler);
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;
            g2D.scale(scale, scale);

            // Background
            g2D.setColor(new Color(238, 238, 238));
            g2D.fillRect(0, 0, 1280, 720);

            test test = new test();

            // Draw arrow
            g2D.setColor(Color.BLACK);
            for (int i = 0; i < test.numberClass(); i++) {
                 for (int j = 0; j < test.numberClass(); j++) {
                     if (test.relationship[i][j] == 1) {
                         if (rectLocation[i][1] > rectLocation[j][3])
                             drawGeneralization(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, (rectLocation[j][2] + rectLocation[j][0]) / 2, rectLocation[j][3]);
                         else if (rectLocation[i][3] < rectLocation[j][1])
                             drawGeneralization(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, (rectLocation[j][2] + rectLocation[j][0]) / 2, rectLocation[j][1]);
                         else if(rectLocation[i][1] <= rectLocation[j][3] && rectLocation[i][3] >= rectLocation[j][1]) {
                             if (rectLocation[i][0] > rectLocation[j][2])
                                 drawGeneralization(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, rectLocation[j][2], (rectLocation[j][1] + rectLocation[j][3]) / 2);
                             else if (rectLocation[i][2] < rectLocation[j][0])
                                 drawGeneralization(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, rectLocation[j][0], (rectLocation[j][1] + rectLocation[j][3]) / 2);
                         }
                     }
                     else if (test.relationship[i][j] == 2 || test.relationship[i][j] == 3) {
                         if (rectLocation[i][1] > rectLocation[j][3])
                             drawRealizationAndImplementation(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, (rectLocation[j][2] + rectLocation[j][0]) / 2, rectLocation[j][3]);
                         else if (rectLocation[i][3] < rectLocation[j][1])
                             drawRealizationAndImplementation(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, (rectLocation[j][2] + rectLocation[j][0]) / 2, rectLocation[j][1]);
                         else if(rectLocation[i][1] <= rectLocation[j][3] && rectLocation[i][3] >= rectLocation[j][1]) {
                             if (rectLocation[i][0] > rectLocation[j][2])
                                 drawRealizationAndImplementation(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, rectLocation[j][2], (rectLocation[j][1] + rectLocation[j][3]) / 2);
                             else if (rectLocation[i][2] < rectLocation[j][0])
                                 drawRealizationAndImplementation(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, rectLocation[j][0], (rectLocation[j][1] + rectLocation[j][3]) / 2);
                         }
                     }
                     else if (test.relationship[i][j] == 4) {
                         if (rectLocation[i][1] > rectLocation[j][3])
                             drawAssociation(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, (rectLocation[j][2] + rectLocation[j][0]) / 2, rectLocation[j][3]);
                         else if (rectLocation[i][3] < rectLocation[j][1])
                             drawAssociation(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, (rectLocation[j][2] + rectLocation[j][0]) / 2, rectLocation[j][1]);
                         else if(rectLocation[i][1] <= rectLocation[j][3] && rectLocation[i][3] >= rectLocation[j][1]) {
                             if (rectLocation[i][0] > rectLocation[j][2])
                                 drawAssociation(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, rectLocation[j][2], (rectLocation[j][1] + rectLocation[j][3]) / 2);
                             else if (rectLocation[i][2] < rectLocation[j][0])
                                 drawAssociation(g, (rectLocation[i][2] + rectLocation[i][0]) / 2, (rectLocation[i][1] + rectLocation[i][3]) / 2, rectLocation[j][0], (rectLocation[j][1] + rectLocation[j][3]) / 2);
                         }
                     }
                 }
            }

            // Draw rect
            for (int i = 0; i < test.numberClass(); i++) {
                // Background rect
                g2D.setColor(new Color(255, 255, 220));
                g2D.fillRect(rectLocation[i][0], rectLocation[i][1], rectLocation[i][2] - rectLocation[i][0], rectLocation[i][3] - rectLocation[i][1]);

                g2D.setColor(Color.BLACK);
                // Border rect
                g2D.drawRect(rectLocation[i][0], rectLocation[i][1], rectLocation[i][2] - rectLocation[i][0], rectLocation[i][3] - rectLocation[i][1]);
                // Lines separate
                g2D.drawLine(rectLocation[i][0], rectLocation[i][1] + wordHeight + lineSpace, rectLocation[i][2], rectLocation[i][1] + wordHeight + lineSpace);
                if(test.numberClassAttributes[i] == 1 || test.numberClassAttributes[i] == 0)
                    g2D.drawLine(rectLocation[i][0], rectLocation[i][1] + wordHeight * 2 + lineSpace, rectLocation[i][2], rectLocation[i][1] + wordHeight * 2 + lineSpace);
                else
                    g2D.drawLine(rectLocation[i][0], rectLocation[i][1] + wordHeight * (test.numberClassAttributes[i] + 1) + lineSpace, rectLocation[i][2], rectLocation[i][1] + wordHeight * (test.numberClassAttributes[i] + 1) + lineSpace);

                // Words
                g2D.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                int temp = wordHeight + 1;
                for (int j = 0; j < test.numberClassInfo[i]; j++) {
                    if (j == 0)
                        g2D.drawString(test.getInfo[i][j], rectLocation[i][0] + (rectLocation[i][2] - rectLocation[i][0] - g2D.getFontMetrics().stringWidth(test.getInfo[i][j])) / 2, rectLocation[i][1] + temp);
                    else {
                        if (test.numberClassAttributes[i] == 0 && test.numberClassMethods[i] != 0 && j == 1) {
                            temp += wordHeight;
                        }
                        g2D.drawString(test.getInfo[i][j], rectLocation[i][0] + wordHeight / 2 - 5, rectLocation[i][1] + temp);
                    }
                    temp += wordHeight;
                }
            }
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            double widthScale = width * scale;
            double heightScale = height * scale;
            return new Dimension((int) widthScale, (int) heightScale);
        }

        class mouseHandler extends MouseMotionAdapter implements MouseMotionListener, MouseListener{
            @Override
            public void mousePressed(MouseEvent e) {
                test test = new test();
                screenX = e.getX();
                screenY = e.getY();

                for(i = 0; i < test.numberClass(); i++) {
                    if((int) (e.getX() / scale) < rectLocation[i][2] && (int) (e.getX() / scale) > rectLocation[i][0] && (e.getY() / scale) < rectLocation[i][3] && (e.getY() / scale) > rectLocation[i][1])
                        break;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                test test = new test();

                if(i != test.numberClass()) {
                    int deltaX = e.getX() - screenX;
                    int deltaY = e.getY() - screenY;

                    rectLocation[i][0] += deltaX / (scale);
                    rectLocation[i][1] += deltaY / (scale);
                    screenX = e.getX();
                    screenY = e.getY();

                    // Reupdate
                    if (wordWidth * test.longestStringLen[i] < 100)
                        rectLocation[i][2] = rectLocation[i][0] + 100;
                    else
                        rectLocation[i][2] = rectLocation[i][0] + wordWidth * test.longestStringLen[i];
                    if (test.numberClassInfo[i] == 0 || test.numberClassInfo[i] == 1)
                        rectLocation[i][3] = rectLocation[i][1] + wordHeight * 3 + wordHeight / 2;
                    else
                        rectLocation[i][3] = rectLocation[i][1] + wordHeight * test.numberClassInfo[i] + wordHeight / 2;
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {

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
        }

            class MyKeyListener extends KeyAdapter {
            @Override
            public void keyReleased(KeyEvent e) {

                // PrintScreen
                if (e.getKeyCode() == 154) {
                    BufferedImage image = new BufferedImage(diagram.getWidth(), diagram.getHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = image.createGraphics();
                    diagram.printAll(g);
                    g.dispose();
                    try {
                        ImageIO.write(image, "jpg", new File("Diagram.jpg"));
                        ImageIO.write(image, "png", new File("Diagram.png"));
                    } catch (IOException exp) {
                        exp.printStackTrace();
                    } finally {
                        JOptionPane.showMessageDialog(null, "Your image will be stored as \"Diagram.jpg\" and \"Diagram.png\"", "Message", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("./icons/ok.png"));
                    }
                }
                // Zoom in
                else if (e.getKeyCode() == 107 || e.getKeyCode() == 46) {
                    scale += 0.1;
                    if (scale > 2) scale = 2;
//                repaint();
                }
                //Zoom out
                else if (e.getKeyCode() == 109 || e.getKeyCode() == 44) {
                    scale -= 0.1;
                    if (scale < 0.5) scale = 0.5;
//                repaint();
                }

            }
        }

        void updateLocation() {
            test test = new test();
            rectLocation = new int[test.numberClass()][4];
            // Set location for the first rect
            // X1
            rectLocation[0][0] = X1;
            // Y1
            rectLocation[0][1] = Y1;
            // X2
            if (wordWidth * test.longestStringLen[0] < 100)
                rectLocation[0][2] = rectLocation[0][0] + 100;
            else
                rectLocation[0][2] = rectLocation[0][0] + wordWidth * test.longestStringLen[0];
            // Y2
            if (test.numberClassInfo[0] == 1 || test.numberClassInfo[0] == 2)
                rectLocation[0][3] = rectLocation[0][1] + wordHeight * 3 + wordHeight / 2;
            else
                rectLocation[0][3] = rectLocation[0][1] + wordHeight * test.numberClassInfo[0] + wordHeight / 2;

            // Set other rect location related to the one before it
            for (int i = 1; i < test.numberClass(); i++) {
                if (i == test.numberClass() / 2 - 1) {
                    int maxHeightLine1 = 0;
                    for(int j = 0; j < test.numberClass() / 2 - 2; j++) {
                        if(rectLocation[j][3] > maxHeightLine1)
                            maxHeightLine1 = rectLocation[j][3];
                    }
                    rectLocation[i][0] = X1;
                    rectLocation[i][1] = maxHeightLine1 + 300;
                } else {
                    rectLocation[i][0] = rectLocation[i - 1][2] + boxSpace;
                    rectLocation[i][1] = rectLocation[i-1][1];
                }
                if (wordWidth * test.longestStringLen[i] < 100)
                    rectLocation[i][2] = rectLocation[i][0] + 100;
                else
                    rectLocation[i][2] = rectLocation[i][0] + wordWidth * test.longestStringLen[i];
                if (test.numberClassInfo[i] == 1 || test.numberClassInfo[i] == 2)
                    rectLocation[i][3] = rectLocation[i][1] + wordHeight * 3 + wordHeight / 2;
                else
                    rectLocation[i][3] = rectLocation[i][1] + wordHeight * test.numberClassInfo[i] + wordHeight / 2;

                // Find max X, max Y
                if(rectLocation[i][2] + 100 > width) width = rectLocation[i][2] + 100;
                if(rectLocation[i][3] + 100 > height) height = rectLocation[i][3] +100;
            }
        }

        void drawGeneralization(Graphics g, int x1, int y1, int x2, int y2) {
            Graphics2D g2D = (Graphics2D) g.create();

            double dx = x2 - x1, dy = y2 - y1;
            double angle = Math.atan2(dy, dx);
            int len = (int) Math.sqrt(dx*dx + dy*dy);
            AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
            at.concatenate(AffineTransform.getRotateInstance(angle));
            g2D.transform(at);

            // Draw horizontal arrow starting in (0, 0)
            g2D.drawLine(0, 0, len - ARR_SIZE, 0);
            g2D.drawPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                    new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
        }

        void drawRealizationAndImplementation(Graphics g, int x1, int y1, int x2, int y2) {
            float[] dash3 = {4f, 0f, 2f};
            Graphics2D g2D = (Graphics2D) g.create();

            double dx = x2 - x1, dy = y2 - y1;
            double angle = Math.atan2(dy, dx);
            int len = (int) Math.sqrt(dx*dx + dy*dy);
            AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
            at.concatenate(AffineTransform.getRotateInstance(angle));
            g2D.transform(at);

            // Draw horizontal arrow starting in (0, 0)
            g2D.drawPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                    new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
            BasicStroke bs3 = new BasicStroke(1, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);
            g2D.setStroke(bs3);
            g2D.drawLine(0, 0, len - ARR_SIZE, 0);
        }

        void drawAssociation(Graphics g, int x1, int y1, int x2, int y2) {
            Graphics2D g2D = (Graphics2D) g.create();

            double dx = x2 - x1, dy = y2 - y1;
            double angle = Math.atan2(dy, dx);
            int len = (int) Math.sqrt(dx*dx + dy*dy);
            AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
            at.concatenate(AffineTransform.getRotateInstance(angle));
            g2D.transform(at);

            // Draw horizontal arrow starting in (0, 0)
            g2D.drawLine(0, 0, len, 0);
            g2D.drawLine(len - ARR_SIZE, -ARR_SIZE / (int)Math.tan(Math.toRadians(60)), len, 0);
            g2D.drawLine(len - ARR_SIZE, ARR_SIZE / (int)Math.tan(Math.toRadians(60)), len, 0);
        }

    }
}

