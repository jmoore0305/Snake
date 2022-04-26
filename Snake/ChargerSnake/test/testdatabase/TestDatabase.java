package testdatabase;
import Utility.Player;
import Utility.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jmoore
 */

public class TestDatabase {
    
    public static void main(String[] args) throws SQLException 
    {
       
        String a = "";
        
        int b, c, d = -1;
        
        int done = 0;
        
        int ans = 0;
        
        Scanner sc= new Scanner(System.in);    
        
        Scanner sc2= new Scanner(System.in); //System.in is a standard input stream 
        
        Database db = new Database();
        
        ArrayList<Player> playerList = new ArrayList<>();
        
        
        do
        {       
            
            System.out.println("-------------------------------------");

            System.out.println("\n");
            
            System.out.println("Enter 1 to insert, Enter 2 to print");
            
                        
            System.out.println("\n");

            System.out.println("-------------------------------------");
            
            System.out.println("\n");
                
            System.out.println("Enter value below: ");
            
            ans = sc.nextInt();
            
            System.out.println("\n");
            
            switch(ans) {
                
                case 1:
                    
                    System.out.println("Enter values for database insertion");

                    System.out.println("\n");

                    System.out.println("Enter name: ");

                    a = sc2.nextLine();

                    System.out.println("\n");
                    
                    System.out.println("Enter score: ");

                    b = sc.nextInt();
                    
                    System.out.println("\n");

                    System.out.println("Enter time: "); 

                    c = sc.nextInt();
                    
                    System.out.println("\n");
                    
                 //   db.insertLeaderBoard(a, b, c);
                    
                  break;
                  
                case 2:
                    
                    playerList = db.getLeaderBoard();
                    
                    for(Player p : playerList)
                    {
                        
                        System.out.println("-------------------\n");
                        
                        System.out.println("Name = " + p.getName());
                        
                        System.out.println("Score = " + p.getScore());
                        
                        System.out.println("Time = " + p.getTime());
                        
                        System.out.println("-------------------\n");
                        
                    }

                  break;
                
                default:
                    
                    System.out.println("Invalid command, program terminated...");
                    
                    System.exit(0);
            }
            
            System.out.println("\n");

            System.out.println("-------------------------------------");

            System.out.println("\n");
            
            System.out.println("Enter 1 to return to main menu and any other number to end the program and delete the database");
            
            System.out.println("\n");
            
            System.out.println("-------------------------------------");
            
            System.out.println("\n");
            
            System.out.println("Enter value below: ");

            done = sc.nextInt();
            
            System.out.println("\n");
                    
        } while(done == 1);
        
        
        
        db.disconnectFromLeaderBoard() ;

    } 

}