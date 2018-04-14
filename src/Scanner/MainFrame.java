/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Scanner;

   import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author eslam
 */
public class MainFrame {



    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public MainFrame() {
        
            JFrame f = new JFrame();
            JButton exit = new JButton("Exit");
            JButton start = new JButton("Start");
            Container c = f.getContentPane();
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setUndecorated(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);
            f.setBounds(0, 0, screenSize.width,screenSize.height);
            JTextArea code = new JTextArea();
            c.add(code);
            c.add(exit);
            c.add(start);
            start.setBounds(20*Dim.ratio_W, 720*Dim.ratio_H, 100*Dim.ratio_W,40*Dim.ratio_H);
            exit.setBounds(1250*Dim.ratio_W, 720*Dim.ratio_H, 100*Dim.ratio_W,40*Dim.ratio_H);
            exit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
                
            });
            code.setBounds(10*Dim.ratio_W,10*Dim.ratio_H,1000*Dim.ratio_W,600*Dim.ratio_H);
           
            f.setVisible(true);
    
    }
    
}
    

