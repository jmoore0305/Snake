/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Class to create a return to start button on the leaderboard. This button takes
 * the user back to the start screen.
 */
public class ReturnStartComp {
    
    /**
     * Creates a JButton which reads "Return to Start"
     * @return the JButton
     */
    public JButton getReturnStartComp() {
        
        JButton returnStart = new JButton("Return to Start");

        returnStart.setFont(new Font("Verdana", Font.BOLD, 15));

        return returnStart;
    }
    
}
