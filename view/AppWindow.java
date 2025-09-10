package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class AppWindow extends JFrame {

    private AppCanvas canvas;

    public void init() {

        var cp = getContentPane();
        canvas = new AppCanvas();
        cp.add(canvas, BorderLayout.CENTER);
        
    }
    
}
