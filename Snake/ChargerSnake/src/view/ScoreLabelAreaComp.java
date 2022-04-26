/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * Class for displaying the score to the bottom of the screen during gameplay.
 */
public class ScoreLabelAreaComp {

    private final JLabel displayScore;

    /**
     * Displays the score to the screen using a JLabel
     */
    ScoreLabelAreaComp() {
        
        displayScore = new JLabel("Score:", JLabel.CENTER);

        displayScore.setFont(new Font("Verdana", Font.BOLD, 15));

        displayScore.setForeground(Color.BLACK);    
               
        displayScore.setText("0");
    }

    /**
     * Getter function for the JLabel, also sets its size.
     * @return the JLabel
     */
    public JLabel getScoreLabelAreaComp() {

        displayScore.setSize(20, 20);

        return displayScore;

    }

}
