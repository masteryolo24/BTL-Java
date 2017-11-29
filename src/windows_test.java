import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class windows_test {
    JFrame login = null;
    JFrame inner_frame = null;

    public windows_test() {
        login = new JFrame();
        login.setBounds(10, 10, 300, 300);
        login.setLayout(new BorderLayout());

        JPanel temp_panel = new JPanel();

        temp_panel.add(new JTextArea("asd fsj   adhf jsad kjfh sa dj kfh j sak ds fda f hsa kj d hf ks ad hf kjs ad h fk js ad h fjs da hf k j sahd kjfsh d jk fhs ad"));

        login.setVisible(true);
        JScrollPane scroll_pane = new JScrollPane(temp_panel);
        scroll_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); //SETTING SCHEME FOR HORIZONTAL BAR
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        login.add(scroll_pane);
    }
}