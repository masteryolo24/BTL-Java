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
    JTextField filePath = new JTextField("");



    public menu() {
        super("Java SE Project Reader");
        setSize(350, 200);

        // Buttons
        fileButton.setBounds(45, 105, 85, 30);
        fileButton.setFocusPainted(false);
        fileButton.setMnemonic(KeyEvent.VK_J);
        fileButton.setToolTipText("Click to choose Java file");

        folderButton.setBounds(155, 105, 150, 30);
        folderButton.setFocusPainted(false);
        folderButton.setMnemonic(KeyEvent.VK_F);
        folderButton.setToolTipText("Click to choose Java folder");

        analyzeButton.setBounds(240, 50, 80, 30);
        analyzeButton.setFocusPainted(false);
        analyzeButton.setMnemonic(KeyEvent.VK_A);
        analyzeButton.setToolTipText("Click to start analyze");

        // File path
        filePath.setBounds(30, 50,200,30);
        filePath.setToolTipText("Write file directory here");

        // File Chooser
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
