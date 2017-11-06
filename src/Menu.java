import javafx.embed.swing.JFXPanel;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame {
    JPanel p = new JPanel();
    JButton b1 = new JButton("Read a Java SE Project");
    JButton b2 = new JButton("Exit");

    public menu() {
        super("Bài tập lớn");
        setSize(800, 600);
        p.setLayout(null);

        b1.setBounds(300, 200, 200, 40);
        b2.setBounds(350, 270, 100, 40);

        b1.setActionCommand("read");
        b2.setActionCommand("exit");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//              JOptionPane.showConfirmDialog(null,"Trần Vũ Đức có phải là 1 con súc vật không?");
                JFileChooser open = new JFileChooser();
                int choose = -1;
                open.setDialogTitle("...");
                open.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                choose = open.showOpenDialog(null);
                JFrame f1 = new JFrame();
                f1.setTitle("Result");
                f1.setSize(800, 600);
                f1.setVisible(true);
                f1.setResizable(false);
                f1.setLocationRelativeTo(null);
                f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setVisible(false);
                JTextArea tf1 = new JTextArea();
                tf1.setSize(100,300);
                tf1.setLocation(0, 0);
                f1.add(tf1);
                readFile r= new readFile();
               // tf1.setText(r.docFile("C:\\Users\\7th\\Desktop\\New Text Document.txt"));
                tf1.setVisible(true);

            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.exit(0);
            }
        });

        p.add(b1);
        p.add(b2);

        add(p);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
