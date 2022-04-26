/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JButton;

/**
 * Class for displaying the start button on the start screen.
 */
public class StartButtonComp {
    
    /**
     * Creates a JButton which displays the start button on the start screen.
     * When this is pressed, the game will begin for the user.
     * @return the JButton
     */
    public JButton getStartButtonComp() {
        
        JButton start = new JButton("Start");

        start.setSize(15, 15);
        
        return start;
    }
    
}
