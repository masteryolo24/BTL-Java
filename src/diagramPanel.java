import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class diagramPanel extends JFrame {
    JPanel p = new JPanel();
    JToolBar tb = new JToolBar();
    JButton b1 = new JButton("");
    JButton b2 = new JButton("");
    JButton b3 = new JButton("");

//    JToolBar1 = new javax.swing.JToolBar();
//    jToolBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
//    jToolBar1.setFloatable(false);
//    jToolBar1.setRollover(true);
    public diagramPanel() {
        // Size and name of JFrame
        super("Java SE Project Reader");
        setSize(1280, 720);

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
//        tb.setOpaque(true);

        // Add to panel
        getContentPane().add("North", tb);
        p.add(tb);
        add(p);

        // Init JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
