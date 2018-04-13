package compiler;

import java.awt.*;
import javax.swing.*;

public class Compiler {
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static void main(String[] args) {
        
            JFrame f = new JFrame();
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setUndecorated(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);
            Container c = f.getContentPane();
            f.setBounds(0, 0, screenSize.width,screenSize.height);
            JTextArea code = new JTextArea();
            c.add(code);
            code.setBounds(10*Dim.ratio_W,10*Dim.ratio_H,100*Dim.ratio_W,100*Dim.ratio_H);
            f.setVisible(true);
    
    }
    
}
