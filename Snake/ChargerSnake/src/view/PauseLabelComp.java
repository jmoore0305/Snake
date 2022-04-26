/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * Class for the text to be displayed during the pause screen.
 */
public class PauseLabelComp {
    
    /**
     * Creates a JLabel that reads "Game Paused" during a pause frame in the game.
     * @return the JLabel
     */
    public JLabel getPauseLabelComp() {
        
        JLabel labelOne = new JLabel("Game Paused", JLabel.CENTER);

        labelOne.setFont(new Font("Verdana", Font.BOLD, 20));

        labelOne.setForeground(Color.BLUE);
        
        return labelOne;
    }
    
}
