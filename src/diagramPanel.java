import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class diagramPanel extends JFrame {
    JPanel p = new JPanel();
    JToolBar tb = new JToolBar();
    JButton b1 = new JButton("Zoom In");
    JButton b2 = new JButton("Zoom Out");
    JButton b3 = new JButton("Export");

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
        tb.add(b1);
        b2.setFocusPainted(false);
        tb.add(b2);
        b3.setFocusPainted(false);
        tb.add(b3);
        // Toolbar
        tb.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tb.setFloatable(false);
        tb.setRollover(true);

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
