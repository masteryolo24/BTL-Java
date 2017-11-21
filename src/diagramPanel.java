import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class diagramPanel extends JFrame {
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JToolBar tb = new JToolBar();
    JButton b1 = new JButton("");
    JButton b2 = new JButton("");
    JButton b3 = new JButton("");
    JTextField tf1 = new JTextField("");

    public diagramPanel() {
        // Size and name of JFrame
        super("Java SE Project Reader");
        setSize(1280, 720);
        setLayout(new FlowLayout());

        // Buttons
        b1.setFocusPainted(false);
        b1.setMnemonic(KeyEvent.VK_PLUS);
        b1.setIcon(new ImageIcon("./icons/zoom in.png"));
        b1.setToolTipText("Zoom In");

        b2.setFocusPainted(false);
        b2.setIcon(new ImageIcon("./icons/zoom out.png"));
        b2.setToolTipText("Zoom Out");

        b3.setFocusPainted(false);
        b3.setIcon(new ImageIcon("./icons/export.png"));
        b3.setToolTipText("Export to Image");

        // Toolbar
        tb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tb.setFloatable(false);
        tb.setRollover(true);

        // Add to toolbar
        tb.add(b1);
        tb.add(Box.createHorizontalStrut(40));
        tb.add(b2);
        tb.add(Box.createHorizontalStrut(40));
        tb.add(b3);

        tf1.setBounds(100, 100,200,50);
        tf1.setToolTipText("Write file directory here");
//        tb.setOpaque(true);

//        getContentPane().add("North", tb);
        // Add to panel 1
        p1.add(tb);
        p1.setPreferredSize(new Dimension(1280, 55));

        // Add to panel 2
        p2.add(tf1);
        p2.setBackground(Color.BLUE);
        p2.setPreferredSize(new Dimension(1280, 665));

        // Add to frame
        add(p1);
        add(p2);

        // Init JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
    }
}
