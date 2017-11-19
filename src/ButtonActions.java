import java.awt.event.ActionEvent;
import javax.swing.*;

public class ButtonActions {

    private static void createAndShowGui() {
        JPanel mainPanel = new JPanel();

        JButton myButton = new JButton();

        StartAction startAction = new StartAction();
        PauseAction pauseAction = new PauseAction();
        BlankAction blankAction = new BlankAction();

        startAction.setNextAction(pauseAction);
        pauseAction.setNextAction(blankAction);
        blankAction.setNextAction(startAction);

        myButton.setAction(startAction);
        mainPanel.add(myButton);

        JFrame frame = new JFrame("ButtonActions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

class SwappingAction extends AbstractAction {
    private Action nextAction;

    public SwappingAction(String text) {
        super(text);
    }

    public void setNextAction(Action nextAction) {
        this.nextAction = nextAction;
    }

    public Action getNextAction() {
        return nextAction;
    }

    @Override
    /**
     * super method needs to be called in child for swap to work
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println("ActionCommand: " + e.getActionCommand());
        ((AbstractButton)e.getSource()).setAction(nextAction);
    }
}

class StartAction extends SwappingAction {
    public static final String START = "Start";

    public StartAction() {
        super(START);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        // start-specific code goes here
    }
}

class PauseAction extends SwappingAction {
    public static final String PAUSE = "Pause";

    public PauseAction() {
        super(PAUSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        // pause-specific code goes here
    }
}

class BlankAction extends SwappingAction {
    public static final String BLANK = " ";

    public BlankAction() {
        super(BLANK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
    }
}