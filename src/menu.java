import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class menu extends JFrame {
    JPanel p = new JPanel();
    JButton b1 = new JButton("Java File");
    JButton b2 = new JButton("Java Project Folder");
    JButton b3 = new JButton("Analyze");
    JTextField tf1 = new JTextField("");

    public menu() {
        super("Java SE Project Reader");
        setSize(350, 200);

        // Buttons
        b1.setBounds(45, 105, 85, 30);
        b1.setFocusPainted(false);
        b1.setMnemonic(KeyEvent.VK_J);
        b1.setToolTipText("Click to choose Java file");

        b2.setBounds(155, 105, 150, 30);
        b2.setFocusPainted(false);
        b2.setMnemonic(KeyEvent.VK_F);
        b2.setToolTipText("Click to choose Java folder");

        b3.setBounds(240, 50, 80, 30);
        b3.setFocusPainted(false);
        b3.setMnemonic(KeyEvent.VK_A);
        b3.setToolTipText("Click to start analyze");

        // File path
        tf1.setBounds(30, 50,200,30);
        tf1.setToolTipText("Write file directory here");

        // File Chooser
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Read java file
                JFileChooser chooser= new JFileChooser();
//                chooser.addChoosableFileFilter(new FileNameExtensionFilter("Java files", "java"));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Java file", "java");
                chooser.setFileFilter(filter);
                chooser.showOpenDialog(null);

                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                tf1.setText(filename);
            }
        });
        b2.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JFileChooser chooser= new JFileChooser();
                 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                 chooser.showOpenDialog(null);

                 File f = chooser.getSelectedFile();
                 String filename = f.getAbsolutePath();
                 tf1.setText(filename);
                 diagramPanel dp = new diagramPanel();
             }
        });

        // Add to panel
        p.setLayout(null);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(tf1);
        add(p);

        // Init JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
