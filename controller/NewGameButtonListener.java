package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewGameButtonListener implements ActionListener {

    // This method is called when the user clicks the "New Game" button
    @Override
    public void actionPerformed(ActionEvent e) {
        App.game.start();
        App.win.goNext();
        App.win.updateWindow();
        // System.out.println("Starting new game.");
    }
    
}
