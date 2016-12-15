/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author W. Estuardo
 */
public class DBConnection 
{
public Connection createConnection()
 {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/cac"; 
   //for SQL and oracle or any other db server this url differs. 
    //where ravi is the database name and 3306 is the port where mysql is running
    String username = "root"; //username of database user
    String password = ""; //password

    try
     {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");// differs from DB server to server
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

       con = DriverManager.getConnection(url, username, password);
       
     
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

return con;
 }
    
    
}
