import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;

public class diagramFrame extends JFrame {
    diagramPanel diagram = new diagramPanel();

    public diagramFrame() {
        // Size and name of JFrame
        super("Java SE Project Reader");
//        setSize(1280, 720);
        setLayout(new BorderLayout());
        setSize(300, 400);

        // Scrollpane
//        JScrollPane scrollPane = new JScrollPane(diagram, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//        diagram.add(scrollPane, BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(diagram);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollPane.setPreferredSize(new Dimension(100, 200));
        add(scrollPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension(400, 500));

        // Add to diagram
        diagram.addKeyListener(new MyKeyListener());
        diagram.setFocusable(true);
//        diagram.setPreferredSize(new Dimension(1280, 635));
//        scrollPane.getViewport().setView(diagram);
        // Add to frame
        add(diagram);

        // Init JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {

            // PrientScreen
            if (e.getKeyCode() == 154) {
                BufferedImage image = new BufferedImage(diagram.getWidth(), diagram.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                diagram.printAll(g);
//                g.dispose();
                try {
                    ImageIO.write(image, "jpg", new File("Diagram.jpg"));
                    ImageIO.write(image, "png", new File("Diagram.png"));
                } catch (IOException exp) {
                    exp.printStackTrace();
                } finally {
                    JOptionPane.showMessageDialog(null,"Your image will be stored as 'Diagram.jpg' and 'Diagram.png'","Message", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./icons/ok.png"));
                }
            }

//            // Zoom in
//            else if (e.getKeyCode() == 107 || e.getKeyCode() == 46) {
//
//            }
//                //Zoom out
//            else if (e.getKeyCode() == 109 || e.getKeyCode() == 44) {
//
//            }

        }
    }
}

