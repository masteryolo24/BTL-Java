import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class diagramFrame extends JFrame {
    JPanel p1 = new JPanel();
    diagramPanel diagram = new diagramPanel();
    JToolBar tb = new JToolBar();
    JButton zoomIn = new JButton("");
    JButton zoomOut = new JButton("");
    JButton export = new JButton("");

    public diagramFrame() {
        // Size and name of JFrame
        super("Java SE Project Reader");
        setSize(1280, 720);
        setLayout(new FlowLayout());

        // Buttons
        zoomIn.setFocusPainted(false);
        zoomIn.setMnemonic(KeyEvent.VK_PLUS);
        zoomIn.setIcon(new ImageIcon("./icons/zoom in.png"));
        zoomIn.setToolTipText("Zoom In");

        zoomOut.setFocusPainted(false);
        zoomOut.setIcon(new ImageIcon("./icons/zoom out.png"));
        zoomOut.setToolTipText("Zoom Out");

        export.setFocusPainted(false);
        export.setIcon(new ImageIcon("./icons/export.png"));
        export.setToolTipText("Export to Image");

        // Toolbar
//        tb.setBackground(Color.WHITE);
        tb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tb.setFloatable(false);
        tb.setRollover(true);


        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });

        zoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        })
        // Add to toolbar
        tb.add(zoomIn);
        tb.add(Box.createHorizontalStrut(40));
        tb.add(zoomOut);
        tb.add(Box.createHorizontalStrut(40));
        tb.add(export);

        // Add to panel 1
        p1.add(tb);
        p1.setPreferredSize(new Dimension(1280, 55));
        // Add to panel 2
        diagram.setPreferredSize(new Dimension(1280, 665));

        // Add to frame
        add(p1);
        add(diagram);

        // Init JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
