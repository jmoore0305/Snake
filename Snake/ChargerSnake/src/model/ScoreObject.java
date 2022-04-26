package model;

/**
 * Tracks the position and methods for score objects.
 */
public class ScoreObject extends GameObject {

    /**
     * Constructor function for a score object
     * <p>
     * The score object contains its x position and y position.
     * 
     * @param x the x position of the score object
     * @param y the y position of the score object
     */
    public ScoreObject(int x, int y) {
        setx(x);
        sety(y);
    }
}
