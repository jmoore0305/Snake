/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Class to create a pause button for the user to press during gameplay.
 */
public class PauseButtonComp {
    
    /**
     * Creates a pause button that appears on the screen during gameplay. When a
     * user clicks this button, a pause frame is drawn and gameplay is halted.
     * @return the JButton
     */
    public JButton getPauseButtonComp() {
        
        JButton pause = new JButton("Pause");

        pause.setFont(new Font("Verdana", Font.BOLD, 15));
        
        return pause;
        
    }
}
