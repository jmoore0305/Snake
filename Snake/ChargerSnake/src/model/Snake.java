package model;

/**
 * Class for the data and methods for the snake.
 */
public class Snake extends GameObject {

    private char direction;

    /**
     * Constructor for the snake
     * <p>
     * Sets the initial position for the head to the middle of the screen.
     */
    public Snake() {
        this.setx(250);
        this.sety(250);
    }

    /**
     * Getter function for the direction the snake is moving
     * 
     * @return the direction the snake is moving
     */
    public char getDirection() {
        return direction;
    }

    /**
     * Sets the direction the snake is moving
     * @param direction the new direction the snake is moving
     */
    public void setDirection(char direction) {
        this.direction = direction;
    }
}
