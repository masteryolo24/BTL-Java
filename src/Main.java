package simpleborderlayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class Main
{

    public static void main(String[] args)
    {
        Main main = new Main(args);
        main.go();
    }

    public Main(String ... args)
    {}

    public void go()
    {
        JPanel headerPanel = getPanel(Color.RED);
        JPanel footerPanel = getPanel(Color.BLUE);
        JTextField tf1 = new JTextField("fdfdf");
        tf1.setBounds(100, 100, 100, 100);
        JPanel p1 = getPanel(Color.GRAY);
        JPanel p2 = getPanel(Color.GRAY);
        JPanel p3 = getPanel(Color.GRAY);
        JPanel p4 = getPanel(Color.GRAY);
        p1.add(tf1);

        GridLayout gridLayout = new GridLayout(2,2);
        JPanel middlePanel = new JPanel(gridLayout);
        middlePanel.add(p1);
        middlePanel.add(p2);
        middlePanel.add(p3);
        middlePanel.add(p4);

        JFrame mainFrame = new JFrame();
        mainFrame.add(headerPanel, BorderLayout.NORTH);
        mainFrame.add(middlePanel, BorderLayout.CENTER);
        mainFrame.add(footerPanel, BorderLayout.SOUTH);
        mainFrame.pack();

        mainFrame.setVisible(true);

    }

    private JPanel getPanel(Color c)
    {
        JPanel result = new JPanel();
        result.setBorder(BorderFactory.createLineBorder(c));
        return result;
    }

}