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
    double scale = 1;
    double width, height;
    int[][] rectLocation;

    public diagramFrame() {

        // Size and name of JFrame
        super("Java SE Project Reader");
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 720));

        // Scrollpane
        JScrollPane scrollPane = new JScrollPane(diagram, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Add to diagram
        diagram.addKeyListener(new MyKeyListener());
        diagram.setFocusable(true);

        // Add to frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Init JFrame
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(false);
    }


    class diagramPanel extends JPanel {
        int mouseX = 0, mouseY = 0;

        public diagramPanel() {
//        repaint();
            mouseHandler mouseHandler = new mouseHandler();
            addMouseMotionListener(mouseHandler);
            addMouseListener(mouseHandler);
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int fontSize = 18, wordHeight = 24, wordWidth = 10, lineSpace = 6, boxSpace = 50;
            int X1 = 100, Y1 = 100;
            Graphics2D g2D = (Graphics2D) g;
//            g2D.translate(620, 360);
            g2D.scale(scale, scale);
            // Background
            g2D.setColor(new Color(238, 238, 238));
            g2D.fillRect(0, 0, 1280, 720);

            test test = new test();

            // Draw
            rectLocation = new int[test.numberClass()][4];
            for (int i = 0; i < test.numberClass(); i++) {
                // X1
                rectLocation[i][0] = X1;
                // Y1
                rectLocation[i][1] = Y1;
                // X2
                rectLocation[i][3] = X1 + wordWidth * (test.longestStringLen[i]);
                // Y2
                rectLocation[i][3] = Y1 + wordHeight * test.numberClassInfo[i] - 1 + wordHeight / 2;

                // Background rect
                g2D.setColor(new Color(255, 255, 220));
                g2D.fillRect(X1 + 1, Y1 + 1, wordWidth * (test.longestStringLen[i]) - 1, wordHeight * test.numberClassInfo[i] - 1 + wordHeight / 2);

                g2D.setColor(Color.BLACK);
                // Border rect
                g2D.drawRect(X1, Y1, wordWidth * (test.longestStringLen[i]), wordHeight * test.numberClassInfo[i] + wordHeight / 2);

                // Lines separate
                g2D.drawLine(X1, Y1 + wordHeight + lineSpace, X1 + wordWidth * (test.longestStringLen[i]) - 1, Y1 + wordHeight + lineSpace);
                g2D.drawLine(X1, Y1 + wordHeight * (test.numberClassAttributes[i] + 1) + lineSpace, X1 + wordWidth * (test.longestStringLen[i]) - 1, Y1 + wordHeight * (test.numberClassAttributes[i] + 1) + 6);

                // Words
                g2D.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
                for (int j = 0; j < test.numberClassInfo[i]; j++) {
                    if (j == 0)
                        g2D.drawString(test.getInfo[i][j], X1 + wordHeight / 2 + (wordWidth * (test.longestStringLen[i]) - 1) / 2 - wordWidth / 2 * (test.getInfo[i][j].length() + 2), Y1 + wordHeight);
                    else
                        g2D.drawString(test.getInfo[i][j], X1 + wordHeight / 2 - 5, Y1 + wordHeight);
                    Y1 += wordHeight;
                }
                X1 += wordWidth * (test.longestStringLen[i]) + boxSpace;
                Y1 = 100;
            }
            width = X1 + 50;
            height = Y1 + wordHeight * test.maxNumberClassInfo + 150;

            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            double widthScale = width * scale;
            double heightScale = height * scale;
            return new Dimension((int)widthScale, (int)heightScale);
        }

        class mouseHandler extends MouseMotionAdapter implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
//                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                rectLocation[0][0] = 200;
                rectLocation[0][1] = 200;

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
                if (scale > 2) scale = 2;
                else scale += 0.1;
//                repaint();
            }
                //Zoom out
            else if (e.getKeyCode() == 109 || e.getKeyCode() == 44) {
                if (scale < 0.5) scale = 0.5;
                else scale -= 0.1;
//                repaint();
            }

        }
    }
}

