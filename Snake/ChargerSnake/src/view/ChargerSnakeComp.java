/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * Class to display the title to the start screen
 */
public class ChargerSnakeComp {
    
    /**
     * Displays a JLabel reading "Charger Snake" to the start screen
     * @return the JLabel
     */
    public JLabel getChargerSnakeComp() {
        
        JLabel labelOne = new JLabel("Charger Snake", JLabel.CENTER);

        labelOne.setFont(new Font("Verdana", Font.BOLD, 20));

        labelOne.setForeground(Color.BLUE);
        
        return labelOne;
    }

}
