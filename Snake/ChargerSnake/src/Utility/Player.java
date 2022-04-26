
        
package Utility;

/**
 *
 * Player class is used to store the information for the user
 * such as name, score, and time
 */
public class Player {
    
    private String name;
    
    private int score;
    
    private int time;
    
    /**
     * 
     * @param n
     * @param s
     * @param t 
     * Used to construct a player with arguments provided
     */
    Player(String n, int s, int t)
    {
        this.name = n;
        this.score = s;
        this.time = t;
    }
    /**
     * Used to construct a player with no args.
     */
    public Player() {
        this.name = "";
        this.score = 0;
        this.time = 0;
    }
    /**
     * Used to set a player's name.
     * @param n 
     */
    public void setName(String n) 
    {
        this.name = n;
    }
    /**
     * Used to set a player's score.
     * @param s 
     */
    public void setScore(int s) 
    {
        this.score = s;
    }
    /**
     * Used to set a player's time.
     * @param t 
     */
    public void setTime(int t) 
    {
        this.time = t;
    }
    /**
     * Used to get a player's name.
     * @return 
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Used to get a player's score.
     * @return 
     */
    public int getScore()
    {
        return this.score;
    }
    /**
     * Used to get a player's time.
     * @return 
     */
    public int getTime()
    {
        return this.time;
    }
    /**
     * Used to reset values of a player between games.
     */
    public void resetValues()
    {
        this.setName("");
        this.setScore(0);
        this.setTime(0);
    }    
}
