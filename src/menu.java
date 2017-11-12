import javafx.embed.swing.JFXPanel;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class menu extends JFrame {
    JPanel p = new JPanel();
    JButton b1 = new JButton("Analyze");
    JButton b2 = new JButton("...");
    JTextField tf1 = new JTextField("");


    public menu() {
        // Size and name of main Jframe
        super("Java SE Project Reader");
        setSize(350, 200);

        // Buttons
        b1.setBounds(135, 105, 80, 30);
        b1.setFocusPainted(false);
        b1.setMnemonic(KeyEvent.VK_A);
        b1.setToolTipText("Click to start analyze Java SE Project");
        b2.setBounds(300, 50,30,29);
        b2.setFocusPainted(false);
        b2.setToolTipText("Click to open file chooser");

        //File path
        tf1.setBounds(30, 50,245,30);
        //File Chooser
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Read file
                JFileChooser chooser= new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                tf1.setText(filename);
            }
        });


        // Add buttons and things to panel
        p.setLayout(null);
        p.add(b1);
        p.add(b2);
        p.add(tf1);
        add(p);

        // Init main Jframe
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
