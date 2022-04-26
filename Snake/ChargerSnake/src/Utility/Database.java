package Utility;
import java.sql.*;
import java.util.ArrayList;
 
/**
 * 
 * This class will be responsible for storing player data 
 * such as the Player's name, score, and time. This depends upon the use
 * of Apache Derby which is a Java/SQL hybrid. It basically allows for
 * the execution of queries and the results of queries to be stored in objects
 * and to call methods on those objects to manipulate the data.
 */

public class Database 
{
 
    private final String URL;
    private final Connection conn;
    private final Statement statement;
    private String query;
    private ResultSet result;
    

    /**
     *
     * @throws SQLException 
     * The constructor sets up a connection for the database and
     * initializes variables for later use. In addition the constructor makes
     * a call to doesTableExist. If the database already exists then nothing
     * is created. If the database does not exist then ten entries are created
     * with name = "Unknown", score = 0, and time = 0. You can think of it
     * as a table with 10 rows and 3 columns.
     */
    public Database() throws SQLException
    {
        
        
        URL = "jdbc:derby:LeaderBoard;create=true";
        
        conn = DriverManager.getConnection(URL);
        
        statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                        ResultSet.CONCUR_UPDATABLE);  
        
        query = "";
        
        
        if (!doesTableExists("LeaderBoard")) {
               
             	initLeaderBoard();
                
        }
        
    }
    
    
    /**
     * This method is responsible for disconnecting from the database
     * and shutting it down properly.
     */
    public void disconnectFromLeaderBoard() 
    {

        try
        {
            if (statement != null)
            {
                statement.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(URL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }
        
    }    
    
    
    /**
     * 
     * @throws SQLException 
     * This method is left in just in case a user wants to use 
     * for testing purposes. This will delete the database but not disconnect.
     * You will still need to disconnect after deleting.
     */
    private void deleteLeaderBoard() throws SQLException
    {
                  
        query = "DROP TABLE LeaderBoard";
        
        statement.execute(query);        
        
        
    }
    
    
    /**
     * 
     * @param p
     * @throws SQLException 
     * This method is responsible for inserting a player(made up of
     * name, score, and time) into the database. If the Player's score
     * is greater than or equal to the last place score AND the time 
     * is greater than the last place time then the player will be added
     * to the database.
     */
    public void insertLeaderBoard(Player p) throws SQLException
    {
            String name = p.getName();
            
            int score = p.getScore();
            
            int time = p.getTime();
            
            result = statement.executeQuery("SELECT * FROM LeaderBoard ORDER BY Score DESC");
             
            result.absolute(10); // compare against the 10th row
            
            int lastPlaceScore = result.getInt("Score");
            
            int lastPlaceTimeAlive = result.getInt("Time");
            
            
            int rowId = result.getInt("Id");
            
         
            if(score >= lastPlaceScore && time > lastPlaceTimeAlive)
            {
                
                query = "UPDATE LeaderBoard SET Name= '" + name + "', Score= " + score + ", Time= " + time  + " WHERE Id=" + rowId + "";

                statement.execute(query);
                
            }
            
            
    }
    

    /**
     * 
     * @throws SQLException 
     * This method will populate the leaderboard with placeholder values.
     * It will be called in the constructor if no database exists already.
     */
    private void initLeaderBoard() throws SQLException
    {
        
                
            query = "CREATE TABLE LeaderBoard("
            + "Id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
            + "Name varchar(128), "
            + "Score int, "
            + "Time int)";


            statement.execute(query);        



            //insert 10 unknown values

            query = "INSERT INTO LeaderBoard ("
                    + "Name, Score, Time) VALUES ("
                    + "'Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0)";

            statement.execute(query);        
                
    }
   
    
        
    /**
     * 
     * @return
     * @throws SQLException 
     * This method is responsible for extracting the 10 players and 
     * storing them in a ArrayList to be returned to the model.
     */
    public ArrayList<Player> getLeaderBoard() throws SQLException
    {
        
            ArrayList<Player> playerList = new ArrayList<>(10);           
            
            query = "SELECT * FROM LeaderBoard ORDER BY Score DESC";
        
            result = statement.executeQuery(query);        
        
            while (result.next()) {
                
                playerList.add(new Player(result.getString("Name"), result.getInt("Score"), result.getInt("Time")));
                
            }    
            
            return playerList;
            
    }
    
    
    /**
     * 
     * @param tableName
     * @return
     * @throws SQLException 
     * This method collects metadata about the sql table to determine
     * whether or not it even exists. The result of this inquiry will be
     * returned to the constructor to determine whether or not a database needs
     * to be created.
     */
    private boolean doesTableExists(String tableName) throws SQLException
    {
        
            DatabaseMetaData meta = conn.getMetaData();

            result = meta.getTables(null, null, tableName.toUpperCase(), null);

            return result.next();
        
    }

       
    
}