package model;

import Utility.Player;
import Utility.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * This is the main model for the game, tracking most of the relevant data and
 * methods for the model. This tracks information related to the board and player
 * and contains methods to update these values and transfer them to the database.
 */
public class SnakeModel implements Subject {

    private ArrayList<GameObject> snake;
    private Random random;
    private ArrayList<ScoreObject> objects;
    private ArrayList<Observer> observers;
    private ArrayList<Player> players;
    private static final int BOARD_LENGTH = 500;
    private static final int BOARD_WIDTH = 500;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (BOARD_WIDTH * BOARD_LENGTH) / UNIT_SIZE;
    private Player player;
    private int score;
    

    /**
     * Constructor for the SnakeModel class, creates a new model for the snake.
     * <p>
     * This method creates a new player, random, arraylist for the snake pieces(game objects),
     * arraylist for score objects, and an arraylist for observers
     */
    public SnakeModel() {
        player = new Player();
        random = new Random();
        snake = new ArrayList<GameObject>();
        objects = new ArrayList<ScoreObject>();
        observers = new ArrayList<Observer>();
         
    }

    /**
     * Initializes the board for a new game
     * <p>
     * This method clears the snake and all objects, and it creates a new snake
     */
    public void initGame() {
        snake.clear();
        objects.clear();
        snake.add(new Snake());
        for (int i = 0; i < 5; i++) {
            snake.add(new GameObject());
        }
    }
    
    /**
     * Resets the score and information for the player (name, score, time)
     */
    public void resetPlayerValues() {
        score = 0;
        player.resetValues();
    }
    
    /**
     * Sets the player's name. This can be accessed by the database for the leaderboard.
     * 
     * @param n Player's name
     */
    public void setName(String n) {
        player.setName(n);
    }
    
    /**
     * Sets the player's score. This can be accessed by the database for the leaderboard.
     * 
     * @param s Player's score
     */
    public void setScore(int s) {
        player.setScore(s);
    }
    
    /**
     * Sets the time that a player has been playing the current game. This can be 
     * accessed by the database for the leaderboard.
     * 
     * @param t 
     */
    public void setTime(int t) {   
        player.setTime(t);
    }

    /**
     * Sends player data to the database
     * <p>
     * Creates a new database object. If the player's name is empty, the method will
     * set it to "Unknown". Sends the information to the leaderboard and inserts it
     * into the proper place. If there is an SQL exception it will be caught by
     * the method.
     */
    public void sendDataToDatabase() {
        try {
            Database db = new Database();
            if(player.getName().isEmpty()) {
                player.setName("Unknown");
            }    
            db.insertLeaderBoard(player);
            players = db.getLeaderBoard();
            db.disconnectFromLeaderBoard() ;
        } catch (SQLException e){}
    }
    
    /**
     * Moves the snake in the specified direction.
     * <p>
     * Loops through the snake array (game object array) and moves the position to the
     * previous element's position. The head moves forward in the direction that
     * it is facing.
     */
    public void moveSnake() {
        for (int i = snake.size() - 1; i > 0; i--) {
            snake.get(i).setx(snake.get(i - 1).getx());
            snake.get(i).sety(snake.get(i - 1).gety());
        }
        Snake s = (Snake) snake.get(0);
        switch (s.getDirection()) {
            case 'U':
                snake.get(0).sety(snake.get(0).gety() - UNIT_SIZE);
                break;
            case 'D':
                snake.get(0).sety(snake.get(0).gety() + UNIT_SIZE);
                break;
            case 'L':
                snake.get(0).setx(snake.get(0).getx() - UNIT_SIZE);
                break;
            case 'R':
                snake.get(0).setx(snake.get(0).getx() + UNIT_SIZE);
                break;
        }
    }

    /**
     * Adds a game object (snake piece) to the end of the tail.
     */
    public void addSnake() {
        snake.add(new GameObject());
    }

    /**
     * Spawns a score object at a random position.
     * <p>
     * The method will ensure the score object spawns on the board and does not
     * spawn on top of the snake.
     */
    public void spawnObject() {
        int x = random.nextInt((int) BOARD_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        int y = random.nextInt((int) BOARD_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        int i = 0;
        while (i < snake.size()) {
            if (snake.get(i).getx() == x && snake.get(i).gety() == y) {
                x = random.nextInt((int) BOARD_WIDTH / UNIT_SIZE) * UNIT_SIZE;
                y = random.nextInt((int) BOARD_WIDTH / UNIT_SIZE) * UNIT_SIZE;
                i = 0;
            } else {
                i++;
            }
        }
        ScoreObject object = new ScoreObject(x, y);
        objects.add(object);
    }

    /**
     * Checks if the snake is colliding with itself or the board boundaries.
     * 
     * @return false if no collision, true if there is a collision
     */
    public boolean checkCollision() {
        //loops through snake and checks if any have collided with something
        for (int i = snake.size() - 1; i > 0; i--) {
            if ((snake.get(0).getx() == snake.get(i).getx()) && (snake.get(0).gety() == snake.get(i).gety())) {
                return false;
            }
        }
        //check if head touches left border
        if (snake.get(0).getx() < 0) {
            return false;
        }
        //check if head touches right border
        if (snake.get(0).getx() >= BOARD_WIDTH) {
            return false;
        }
        //check if head touches top border
        if (snake.get(0).gety() < 0) {
            return false;
        }
        //check if head touches bottom border
        if (snake.get(0).gety() >= BOARD_LENGTH) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the snake is colliding with a score object
     * <p>
     * If the snake is colliding with a score object, the method will update the
     * score, remove the current score object, and spawn a new score object.
     */
    public void checkScoreObject() {
        for (int i = 0; i < objects.size(); i++) {
            if ((snake.get(0).getx() == objects.get(i).getx()) && (snake.get(0).gety() == objects.get(i).gety())) {
                addSnake();
                score++;
                player.setScore(score);
                objects.remove(i);
                spawnObject();
            }
        }
    }

    /**
     * Getter function for the player list
     * 
     * @return players the arraylist of the player
     */
    public ArrayList<Player> getPlayerList() {
        return players;
    }
    
    /**
     * Getter function for the snake at index x (an individual piece of the snake)
     * @param x the index of the snake piece
     * @return the piece of the snake
     */
    public GameObject getSnake(int x) {
        return snake.get(x);
    }

    /**
     * Getter function for a score object at index x
     * @param x the index of the score object
     * @return the score object at index x
     */
    public ScoreObject getScoreObject(int x) {
        return objects.get(x);
    }

    /**
     * Attaches an observer.
     * @param o the observer to attach
     */
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    /**
     * Detaches an observer.
     * @param o the observer to remove
     */
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifies observers with a message.
     * @param m the message
     */
    @Override
    public void notifyUpdate(Message m) {
        for (Observer o : observers) {
            o.update(m);
        }
    }
    
    /**
     * Getter function for the board length
     * @return the board length
     */
    public int getBOARD_LENGTH() {
        return BOARD_LENGTH;
    }

    /**
     * Getter function for the board width
     * @return the board width
     */
    public int getBOARD_WIDTH() {
        return BOARD_WIDTH;
    }

    /**
     * Getter function for unit size (the number of pixels in one "tile")
     * @return the unit size
     */
    public int getUNIT_SIZE() {
        return UNIT_SIZE;
    }

    /**
     * Getter function for # of game units (the number of total "tiles")
     * @return the number of game units
     */
    public int getGAME_UNITS() {
        return GAME_UNITS;
    }

    /**
     * Getter function for the length/size of the snake
     * @return the length of the snake
     */
    public int getSnakeLength() {
        return snake.size();
    }

    /**
     * Getter function for the score
     * @return the score
     */
    public int getScore() {
        return player.getScore();
    }
}
