package view;

import controller.App;
import controller.NewGameButtonListener;
import controller.NumberEnterListener;
import controller.ShowKeyButtonListener;
import controller.StrategySelectionListener;
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

        // Creates the Strategy Panel & buttons
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
        StrategySelectionListener ssl = new StrategySelectionListener();
        highLowButton.addActionListener(ssl);
        closerAwayButton.addActionListener(ssl);

        // Group the radio buttons for selection exclusivity
        ButtonGroup strategy = new ButtonGroup();
        strategy.add(highLowButton);
        strategy.add(closerAwayButton);

        // Creates the Action Panel
        JPanel actionPanel = new JPanel();
        southPanel.add(actionPanel);
        showKeyButton = new JCheckBox("Show Key");
        showKeyButton.addItemListener(new ShowKeyButtonListener());
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new NewGameButtonListener());
        exitButton = new JButton("Exit");
        // Various options for implementing the exit button action
        // exitButton.addActionListener(new ExitButtonListener());
        // exitButton.addActionListener((e) -> {
        //     System.exit(0);
        // });
        exitButton.addActionListener(e -> System.exit(0));
        actionPanel.add(showKeyButton);
        actionPanel.add(newGameButton);
        actionPanel.add(exitButton);

        updateWindow();

    }

    public void updateWindow() {
        switch (App.game.getState()) {
            case INIT:
            case OVER:
            newGameButton.setEnabled(true);
            numberField.setEnabled(false);
            highLowButton.setEnabled(true);
            closerAwayButton.setEnabled(true);
            showKeyButton.setEnabled(true);
            break;
            case PLAYING:
            newGameButton.setEnabled(false);
            numberField.setEnabled(true);
            highLowButton.setEnabled(false);
            closerAwayButton.setEnabled(false);
            break;
        }

        canvas.repaint();

    }
    
}
