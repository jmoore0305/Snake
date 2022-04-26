/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JTextField;

/**
 * Class for an input field for your name on the start screen
 */
public class InputFieldComp {

    /**
     * Creates a text field to enter the player's name
     * @return the JTextField
     */
    public JTextField getInputFieldComp() {
        
        JTextField inputField = new JTextField(20);
        
        return inputField;
    }
}
