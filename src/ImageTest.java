import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTest {

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        final ImageButton button = new ImageButton("button.png");
        button.setPressedIcon(new ImageIcon("down.png"));
        button.setRolloverIcon(new ImageIcon("over.png"));
        button.setSelectedIcon(new ImageIcon("sel.png"));
        button.setRolloverSelectedIcon(new ImageIcon("sel-over.png"));
        button.setDisabledIcon(new ImageIcon("disabled.png"));
        button.setDisabledSelectedIcon(new ImageIcon("disabled-selected.png"));
        button.setLocation(60, 74);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button.setSelected(!button.isSelected());
                System.out.println("selecting");
            }
        });
        // button.setSelected(true);
        // button.setDisabled(false);
        panel.add(button);

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

class ImageButton extends JButton {

    public ImageButton(String img) {
        this(new ImageIcon(img));
    }

    public ImageButton(ImageIcon icon) {
        setIcon(icon);
        setMargin(new Insets(0, 0, 0, 0));
        setIconTextGap(0);
        setBorderPainted(false);
        setBorder(null);
        setText(null);
        setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
    }

}