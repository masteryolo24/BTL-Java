//import javax.swing.*;
//import java.awt.*;
//
//public class Output extends JPanel {
//    private int x1,x2,x3;
//    private int y1,y2,y3;
//    private int W_Max;
//    private int H_Class;
//    private int H_Met[] = {70,50,40,60,30,70,50,40,60,30,70,50,40,60,30} ;
//    private int H_Atr[] = {100,130,150,200,50,100,130,150,200,50,100,130,150,200,50} ;
//    public void paint(Graphics g){
//        Processing test = new Processing();
//        x1=50;
//        y1=50;
//        H_Class = 30;
//
//        setBackground(Color.RED);
//        setForeground(Color.BLACK);
//
//        for (int i = 0; i < 14; i ++) {
//            W_Max = 100;
//            g.drawRect(x1, y1, W_Max, H_Class);
//            g.drawString("123", x1 + 10, y1 + 15);
//            x2 = x1;
//            y2 = y1 + H_Class;
//            g.drawRect(x2, y2, W_Max, H_Met[i]);
//            g.drawString("123", x2 + 10, y2 + 20);
//            x3 = x2;
//            y3 = y2 + H_Met[i];
//            g.drawRect(x3, y3, W_Max, H_Atr[i]);
//            g.drawString("123", x3 + 10, y3 + 20);
//            x2 = x1 = x1 + W_Max+ 100;
//
//        }
//
//
//    }
//
//
//}