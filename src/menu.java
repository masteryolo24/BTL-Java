import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class menu extends JFrame {
    JPanel p = new JPanel();
    JButton fileButton = new JButton("Java File");
    JButton folderButton = new JButton("Java Project Folder");
    JButton analyzeButton = new JButton("Analyze");
    JButton tutorial = new JButton("Tutorial");
    JTextField filePath = new JTextField("");

    public menu() {
        super("Java SE Project Reader");
        setSize(400, 200);

        // Buttons
        fileButton.setBounds(20, 105, 85, 30);
        fileButton.setFocusPainted(false);
        fileButton.setMnemonic(KeyEvent.VK_J);
        fileButton.setToolTipText("Click to choose Java file");

        folderButton.setBounds(125, 105, 145, 30);
        folderButton.setFocusPainted(false);
        folderButton.setMnemonic(KeyEvent.VK_F);
        folderButton.setToolTipText("Click to choose Java folder");

        tutorial.setBounds(290, 105, 80, 30);
        tutorial.setFocusPainted(false);
        tutorial.setMnemonic(KeyEvent.VK_T);
        tutorial.setToolTipText("Tutorial");

        analyzeButton.setBounds(295, 50, 80, 30);
        analyzeButton.setFocusPainted(false);
        analyzeButton.setMnemonic(KeyEvent.VK_A);
        analyzeButton.setToolTipText("Click to start analyze");



        // File path
        filePath.setBounds(30, 50,240,30);
        filePath.setToolTipText("Write file directory here");

        // File Chooser
        tutorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Press PrtSc to export images\nPress + to zoom in\nPress - to zoom out",
                        "Message", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("./icons/ok.png"));
            }
        });
        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Read java file
                JFileChooser chooser= new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Java file", "java");
                chooser.setFileFilter(filter);
                int result = chooser.showOpenDialog(null);
                if(result == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    String filename = f.getAbsolutePath();
                    filePath.setText(filename);
                } else if( result == JFileChooser.CANCEL_OPTION) {
                    filePath.setText("Cancel choose Java file");
                }
            }
        });
        folderButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 // Read Java SE folder
                 JFileChooser chooser= new JFileChooser();
                 chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                 int result = chooser.showOpenDialog(null);
                 if(result == JFileChooser.APPROVE_OPTION) {
                     File f = chooser.getSelectedFile();
                     String filename = f.getAbsolutePath();
                     filePath.setText(filename);
                 } else if( result == JFileChooser.CANCEL_OPTION) {
                     filePath.setText("Cancel choose folder");
                 }
             }
        });
        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Analyze
                diagramFrame dp = new diagramFrame();
                if(bolDir())
                    dp.setVisible(true);
            }
        });

        // Add to panel
        p.setLayout(null);
        p.add(fileButton);
        p.add(folderButton);
        p.add(analyzeButton);
        p.add(tutorial);
        p.add(filePath);
        add(p);

        // Init JFrame
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    protected boolean bolDir() {
        if(filePath.getText().equals("Cancel choose Java file") || filePath.getText().equals("Cancel choose folder") || filePath.getText().equals(""))
            return false;
        else
            return true;
    }
}
