package model;

/**
 * Tracks data and methods for game objects.
 */
public class GameObject {

    private int x, y;

    /**
     * Constructor for a game object
     * <p>
     * Contains an x and y position. These are initialized to dummy values and
     * are set later.
     */
    public GameObject() {
        x = -50;
        y = -50;
    }

    /**
     * Getter function for the x position
     * 
     * @return the x position
     */
    public int getx() {
        return x;
    }

    /**
     * Getter function for the y position
     * @return the y position
     */
    public int gety() {
        return y;
    }

    /**
     * Sets the x position
     * @param x the new x position
     */
    public void setx(int x) {
        this.x = x;
    }

    /**
     * Sets the y position
     * @param y the new y position
     */
    public void sety(int y) {
        this.y = y;
    }
}
