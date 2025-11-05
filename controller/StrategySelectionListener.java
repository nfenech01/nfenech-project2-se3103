package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.strategyPattern.CloseFar;
import model.strategyPattern.HighLow;
import view.AppWindow;

public class StrategySelectionListener implements ActionListener {

    // This method is called when the user selects a strategy
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case AppWindow.highLowAction:
                App.game.setStrategy(new HighLow(App.game));
                break;
            case AppWindow.closerAwayAction:
                App.game.setStrategy(new CloseFar(App.game));
                break;
        }

        // System.out.println(e.getActionCommand());
    }
    
}
