
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class SQLiteConnection {
     private static final String database = "jdbc:sqlite:.//database//studentInfo.db";
    private static Connection connection;
    
    public static Connection getConnection(){
        if(connection == null){
            try{
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(database);
                System.out.println("Connected to database");
            }catch(ClassNotFoundException | SQLException e){
                e.printStackTrace();
         }
            
    }
        return connection;
    }
    
    public static void closeConnection(){
        if(connection != null){
            
            try{
                connection.close();
                System.out.println("Disconnected from database");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            
        }
    }
}
