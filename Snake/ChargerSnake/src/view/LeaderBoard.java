/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Utility.Database;
import Utility.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.SnakeModel;

/**
 * Class for methods to display the leaderboard to the screen after the game has
 * ended.
 */
public class LeaderBoard extends JPanel {
    
    /**
     * This method does most of the work for displaying the leaderboard.
     * <p>
     * This method gets the player data from the model. Draws the background of
     * the leaderboard, then draws the leaderboard information. The method calls
     * the displayHeaders function, then calls the displayScore function for each
     * player on the leaderboard in order to display the proper information.
     * @param model 
     */
    LeaderBoard(SnakeModel model) {
        
        ArrayList<Player> pList = model.getPlayerList();
        
        
        this.setPreferredSize(new Dimension(500, 470));

        this.setBackground(Color.black);
                
        this.setLayout(new GridLayout(11, 3, 1, 1));
        
        displayHeaders();
        for(int i = 0; i < 10; i++)
        {
            Player p = pList.get(i);
            int s = p.getScore();
            int t = p.getTime();
            displayScore(p.getName(), valueOf(s), valueOf(t));
        }
       
        
    }
    
    /**
     * Function to display the information for one player to the leaderboard
     * <p>
     * This method will display a single player's name, score, and time.
     * @param name the player's name
     * @param score the player's score
     * @param time the player's time
     */
    private void displayScore(String name, String score, String time)       
   {
        JLabel n = new JLabel();
        n.setForeground(Color.BLUE);
        n.setFont(new Font("Verdana", Font.BOLD, 14));
        n.setText(name);
        n.setVerticalAlignment(JLabel.TOP);
        n.setHorizontalAlignment(JLabel.CENTER);
        n.setPreferredSize(new Dimension(50, 50));
        this.add(n);    
        
        JLabel s = new JLabel();
        s.setForeground(Color.BLUE);
        s.setFont(new Font("Verdana", Font.BOLD, 14));
        s.setText(score);
        s.setVerticalAlignment(JLabel.TOP);
        s.setHorizontalAlignment(JLabel.CENTER);
        s.setPreferredSize(new Dimension(50, 50));
        this.add(s);
        
        JLabel t = new JLabel();
        t.setForeground(Color.BLUE);
        t.setFont(new Font("Verdana", Font.BOLD, 14));
        t.setText(time);
        t.setVerticalAlignment(JLabel.TOP);
        t.setHorizontalAlignment(JLabel.CENTER);
        t.setPreferredSize(new Dimension(50, 50));
        this.add(t);
   }
    
    /**
     * Draws the appropriate headers for the leaderboard. Think of this as like
     * drawing the titles for each column on the leaderboard.
     */
    private void displayHeaders() 
    {
       JLabel n = new JLabel();
        n.setForeground(Color.BLUE);
        n.setFont(new Font("Verdana", Font.BOLD, 16));
        n.setText("Name");
        n.setVerticalAlignment(JLabel.TOP);
        n.setHorizontalAlignment(JLabel.CENTER);
        n.setPreferredSize(new Dimension(50, 50));
        this.add(n);    
        
        JLabel s = new JLabel();
        s.setForeground(Color.BLUE);
        s.setFont(new Font("Verdana", Font.BOLD, 16));
        s.setText("Score");
        s.setVerticalAlignment(JLabel.TOP);
        s.setHorizontalAlignment(JLabel.CENTER);
        s.setPreferredSize(new Dimension(50, 50));
        this.add(s);
        
        JLabel t = new JLabel();
        t.setForeground(Color.BLUE);
        t.setFont(new Font("Verdana", Font.BOLD, 16));
        t.setText("Time Alive");
        t.setVerticalAlignment(JLabel.TOP);
        t.setHorizontalAlignment(JLabel.CENTER);
        t.setPreferredSize(new Dimension(50, 50));
        this.add(t);
   }
   
}