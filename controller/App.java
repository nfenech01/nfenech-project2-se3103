package controller;

import javax.swing.JFrame;
import view.AppWindow;

public class App {

    public static final AppWindow win = new AppWindow();

    public static void main(String[] args) {
        win.init();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        win.pack();
        win.setVisible(true);
    }
    
} 
