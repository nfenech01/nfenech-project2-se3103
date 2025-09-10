package view;

import controller.App;
import controller.NumberEnterListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import model.PlayStrategy;

public class AppWindow extends JFrame {

    public static final String highLowAction = "High/Low";
    public static final String closerAwayAction = "Close/Far";

    private AppCanvas canvas;

    private JTextField numberField;
    private JRadioButton highLowButton;
    private JRadioButton closerAwayButton;

    private JCheckBox showKeyButton;
    private JButton newGameButton;
    private JButton exitButton;

    public void init() {

        var cp = getContentPane();
        canvas = new AppCanvas();
        cp.add(canvas, BorderLayout.CENTER);

        // Add the South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3,1));
        cp.add(southPanel, BorderLayout.SOUTH);

        // Creates the components in the South Panel
        JPanel numberPanel = new JPanel();
        southPanel.add(numberPanel);
        numberPanel.setBorder(new TitledBorder("Your Guess"));
        numberPanel.add(new JLabel("Enter (0 ~ 100): "));
        numberField = new JTextField(10);
        numberPanel.add(numberField);
        numberField.addActionListener(new NumberEnterListener());

        // Creates the Strategy Panel
        JPanel strategyPanel = new JPanel();
        strategyPanel.setBorder(new TitledBorder("Select Strategy"));
        highLowButton = new JRadioButton(highLowAction,
            App.game.getStrategy() == PlayStrategy.HighLow
        );
        closerAwayButton = new JRadioButton(closerAwayAction,
            App.game.getStrategy() == PlayStrategy.CloserAway
        );
        strategyPanel.add(highLowButton);
        strategyPanel.add(closerAwayButton);
        southPanel.add(strategyPanel);

        // Group the radio buttons for selection exclusivity
        ButtonGroup strategy = new ButtonGroup();
        strategy.add(highLowButton);
        strategy.add(closerAwayButton);

        // Creates the Action Panel
        JPanel actionPanel = new JPanel();
        southPanel.add(actionPanel);
        showKeyButton = new JCheckBox("Show Key");
        newGameButton = new JButton("New Game");
        exitButton = new JButton("Exit");
        actionPanel.add(showKeyButton);
        actionPanel.add(newGameButton);
        actionPanel.add(exitButton);

    }
    
}
