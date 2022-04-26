/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 * Class to create a resume button to return to gameplay from the pause screen.
 */
public class ResumeButtonComp {
    
    /**
     * Creates a JButton which serves as a resume button. When a user presses this,
     * gameplay will automatically resume.
     * @return the JButton
     */
    public JButton getResumeButtonComp() {
        
        JButton resume = new JButton("Resume");

        resume.setFont(new Font("Verdana", Font.BOLD, 15));

        
        return resume;
        
    }    
}
