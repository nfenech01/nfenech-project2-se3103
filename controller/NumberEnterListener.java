package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.NumberGuessGame;

public class NumberEnterListener implements ActionListener {

    // This method is called when the user presses Enter in the text field
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField numberField = (JTextField) e.getSource();
        var str = numberField.getText();
        int guess;
        // Try to parse the input as an integer
        try {
            guess = Integer.parseInt(str);
            if (guess < 0 || guess > NumberGuessGame.MAX_KEY) {
                JOptionPane.showMessageDialog(App.win,
                "Out of range: please enter a number between 0 and " + NumberGuessGame.MAX_KEY);
                return;
            }
        // Return an error message if the input is not a valid integer
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(App.win,
                "Invalid input: only integers are allowed.");
            // System.out.println("Invalid input: " + str);
            return;
        }
        
        App.game.play(guess);

        if (guess == App.game.getKey()) {
            App.win.goNext();
        }

        numberField.setText("");
        App.win.updateWindow();

        // System.out.println(guess + " guessed.");
    }

}
