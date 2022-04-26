/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * Class to display the "Score: " label to the gameplay screen.
 */
public class ScoreLabelComp {
   
    /**
     * Creates a JLabel which displays "Score: " to the screen during gameplay.
     * @return the JLabel
     */
    public JLabel getScoreLabelComp() {
        
        JLabel labelOne = new JLabel("Score:", JLabel.CENTER);

        labelOne.setFont(new Font("Verdana", Font.BOLD, 15));

        labelOne.setForeground(Color.BLACK);    
        
        return labelOne;
        
    }

    
}

