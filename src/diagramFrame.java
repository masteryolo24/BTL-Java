import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
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
//            g2D.translate(620, 360);
            g2D.scale(scale, scale);
            // Background
            g2D.setColor(new Color(238, 238, 238));
            g2D.fillRect(0, 0, 1280, 720);

            test test = new test();

            // Draw

            for (int i = 0; i < test.numberClass(); i++) {
                // Background rect
                g2D.setColor(new Color(255, 255, 220));
                g2D.fillRect(rectLocation[i][0], rectLocation[i][1], wordWidth * test.longestStringLen[i], wordHeight * test.numberClassInfo[i] + wordHeight / 2);

                g2D.setColor(Color.BLACK);
                // Border rect
                g2D.drawRect(rectLocation[i][0], rectLocation[i][1], wordWidth * test.longestStringLen[i], wordHeight * test.numberClassInfo[i] + wordHeight / 2);

                // Lines separate
                g2D.drawLine(rectLocation[i][0], rectLocation[i][1] + wordHeight + lineSpace, rectLocation[i][0] + wordWidth * test.longestStringLen[i], rectLocation[i][1] + wordHeight + lineSpace);
                g2D.drawLine(rectLocation[i][0], rectLocation[i][1] + wordHeight * (test.numberClassAttributes[i] + 1) + lineSpace, rectLocation[i][0] + wordWidth * test.longestStringLen[i], rectLocation[i][1] + wordHeight * (test.numberClassAttributes[i] + 1) + lineSpace);

                // Words
                g2D.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                int temp = wordHeight + 1;
                for (int j = 0; j < test.numberClassInfo[i]; j++) {
                    if (j == 0)
                        g2D.drawString(test.getInfo[i][j], rectLocation[i][0] + (rectLocation[i][2] - rectLocation[i][0] - g2D.getFontMetrics().stringWidth(test.getInfo[i][j])) / 2, rectLocation[i][1] + temp);
                    else
                        g2D.drawString(test.getInfo[i][j], rectLocation[i][0] + wordHeight / 2 - 5, rectLocation[i][1] + temp);
                    temp += wordHeight;
                }

                // Find max X, max Y
                if(rectLocation[i][2] + 100 > width) width = rectLocation[i][2] + 100;
                if(rectLocation[i][3] + 100 > height) height = rectLocation[i][3] +100;
            }
//            width = X1 + 50;
//            height = Y1 + wordHeight * test.maxNumberClassInfo + 150;

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
                    if(e.getX() < rectLocation[i][2] && e.getX() > rectLocation[i][0] && e.getY() < rectLocation[i][3] && e.getY() > rectLocation[i][1])
                        break;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                test test = new test();
                if(i != test.numberClass()) {
                    int deltaX = e.getX() - screenX;
                    int deltaY = e.getY() - screenY;
                    rectLocation[i][0] += deltaX;
                    rectLocation[i][1] += deltaY;
                    screenX = e.getX();
                    screenY = e.getY();

                    // Reupdate
                    rectLocation[i][2] = rectLocation[i][0] + wordWidth * test.longestStringLen[i];
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
            rectLocation[0][2] = rectLocation[0][0] + wordWidth * test.longestStringLen[0];
            // Y2
            rectLocation[0][3] = rectLocation[0][1] + wordHeight * test.numberClassInfo[0] + wordHeight / 2;

            // Set other rect location related to the one before it
            for (int i = 1; i < test.numberClass(); i++) {
                rectLocation[i][0] = rectLocation[i-1][2] + boxSpace;
                rectLocation[i][1] = Y1;
                rectLocation[i][2] = rectLocation[i][0] + wordWidth * test.longestStringLen[i];
                rectLocation[i][3] = rectLocation[i][1] + wordHeight * test.numberClassInfo[i] + wordHeight / 2;
            }
        }
    }
}

