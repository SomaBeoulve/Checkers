/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dammen;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author AlexAnders
 */
public class Dammen {

    /**
     * @param args the command line arguments 
     * This is the main function. It only creates a frame and then calls the CheckerGame engine.
     */
    public static void main(String[] args) {
        Color background = new Color(0, 60, 0);
        JFrame frame = new JFrame("Dammen");
        frame.getContentPane().add(new CheckerGame(), BorderLayout.CENTER);
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(background);
        
    }

}
