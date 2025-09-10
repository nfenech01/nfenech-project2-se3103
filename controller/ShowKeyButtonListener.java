package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;

public class ShowKeyButtonListener implements ItemListener {

    // This method is called when the user checks or unchecks the checkbox
    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox option = (JCheckBox) e.getSource();
        boolean checked = option.isSelected();
        App.game.setShowKeyOn(checked);
        App.win.updateWindow();

        // System.out.println("Checkbox: " + option.isSelected());
    }
    
}
