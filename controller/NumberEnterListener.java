package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class NumberEnterListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField number = (JTextField) e.getSource();
        System.out.println(number.getText() + " entered.");
    }

}
