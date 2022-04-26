/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.SnakeModel;

/**
 * Contains methods to draw game pieces to the screen during the game.
 */
public class GamePieces extends JPanel {

    private final SnakeModel model;

    /**
     * Constructor for the GamePieces class.
     * <p>
     * This method also sets the model variable equal to the model passed in, sets
     * the size of the board, and changes the background color of the board to black.
     * @param m the model
     */
    public GamePieces(SnakeModel m) {
        this.model = m;
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.black);
    }

    /**
     * Paints the objects needed during gameplay onto the board.
     * <p>
     * This method paints the grid onto the board, draws the score objects, and
     * draws the snake. The head is set to a different color.
     * @param g the graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (int i = 0; i < model.getBOARD_WIDTH() / model.getUNIT_SIZE(); i++) {
            g.drawLine(i * model.getUNIT_SIZE(), 0, i * model.getUNIT_SIZE(), model.getBOARD_LENGTH());
            g.drawLine(0, i * model.getUNIT_SIZE(), model.getBOARD_WIDTH(), i * model.getUNIT_SIZE());
        }
        
        g.setColor(Color.white);
        
        g.fillOval(model.getScoreObject(0).getx(), model.getScoreObject(0).gety(), model.getUNIT_SIZE(), model.getUNIT_SIZE());

        for (int i = 0; i < model.getSnakeLength(); i++) {
            if (i == 0) {
                g.setColor(Color.blue);
                g.fillRect(model.getSnake(i).getx(), model.getSnake(i).gety(), model.getUNIT_SIZE(), model.getUNIT_SIZE());
            } else {
                g.setColor(new Color(0, 119, 200));
                g.fillRect(model.getSnake(i).getx(), model.getSnake(i).gety(), model.getUNIT_SIZE(), model.getUNIT_SIZE());
            }
        }
    }

}
