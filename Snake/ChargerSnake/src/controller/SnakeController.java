package controller;

import Utility.*;
import java.awt.event.*;
import model.*;
import view.*;
import javax.swing.Timer;

/**
 * Controls the logic of the overall gameplay to work with the UI elements in the view
 * 
 * @implements ActionListener for keeping track of events and actions that may happen in the gameplay
 */
public class SnakeController implements ActionListener {

    private SnakeModel model;
    private SnakeGUI view;
    private boolean running;
    private boolean game_Over = false;
    private char direction = 'R';
    private Timer timer;
    private long timeA;
    private int timeElapsed;
    private final int DELAY = 1000 / 10;

    /**
    * Constructor for the controller to get initialized
    * 
    * @param model to bring the model information in here
    * @param view to bring the view information in here
    */
    public void initController(SnakeModel model, SnakeGUI view) {
        this.model = model;
        this.view = view;
        timer = new Timer(DELAY, this);
    }

    /**
    * Starting game sequence starts the timers and spawns the snake
    */
    public void startGame() {
        model.initGame();
        timer.start();
        timeA = (System.currentTimeMillis() / 1000);
        model.spawnObject();
    }
    
    /**
    * End game sequence sends an update to the rest of the program to draw the leaderboard
    */
    public void endGame() {
        model.notifyUpdate(new Message("DrawLeaderBoardFrame"));
    }

    /**
    * Action performed event listener to control logic for each event in the game, including collision and button clicks
    * 
    * @Override to create our own actionPerformed method that invokes from each action in the game
    * @param e to keep track of the event performed
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (running) {
            Snake s = (Snake) model.getSnake(0);
            s.setDirection(direction);
            model.moveSnake();
            model.checkScoreObject();
            running = model.checkCollision();
            model.notifyUpdate(new Message("UpdateScore"));
            if (running == false) {
                game_Over = true;
            }
            if (obj == view.getPause()) {
                running = false;
                model.notifyUpdate(new Message("DrawPauseFrame"));
            }
        } else if (obj == view.getStart()) {
            running = true;
            startGame();
            model.notifyUpdate(new Message("DrawGamePlayFrame"));
        } else if (obj == view.getResume()) {
            model.notifyUpdate(new Message("DrawGamePlayFrame"));
            running = true;
        } else if (obj == view.getReturnStart()) {
            game_Over = false;
            model.notifyUpdate(new Message("DrawStartFrame"));
            
        } else if (!running && game_Over) {
            
            timer.stop();
            timeElapsed = (int)((System.currentTimeMillis() / 1000) - timeA);
            model.setTime(timeElapsed);
            model.sendDataToDatabase();
            model.notifyUpdate(new Message("DrawLeaderBoardFrame"));
            model.resetPlayerValues();
            model.notifyUpdate(new Message("ClearName"));
            
        }
        
        model.notifyUpdate(new Message("RePaintGameFrame"));
        
    }
    
    /**
    * GameController class keeps track of the key clicks changing direction during the game
    * 
    * @extends KeyAdapter to set up the necessary keyboard drivers to read data
    */
    public class GameController extends KeyAdapter {

        /**
        * Tracks the key pressed and stores information in e
        * 
        * @Override to use our own logic whenever the keyAdapter invokes keyPressed
        * @param e to keep track of the key pressed
        */
        @Override
        public void keyPressed(KeyEvent e) {
            if (running) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (direction != 'R') {
                            direction = 'L';
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != 'L') {
                            direction = 'R';
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (direction != 'D') {
                            direction = 'U';
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != 'U') {
                            direction = 'D';
                        }
                        break;
                }
            }
        }
    }

}
