import javax.swing.*;
import java.awt.*;

public class Test extends JFrame{
    JToolBar tb=new JToolBar();
    public Test(){
        tb.setLayout(new FlowLayout(FlowLayout.CENTER));
        tb.add(new JButton("Hello"));
        tb.add(new JButton("Middle"));
        tb.add(new JButton("Test"));
        getContentPane().add("North", tb);
        setSize(200,200);
        setVisible(true);
    }
    public static void main(String arg[]){
        new Test();
    }
}