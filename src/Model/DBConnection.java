/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Config.*;
import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author W. Estuardo
 */
public class DBConnection 
{
    public Connection createConnection()
     {
        Connection con = null;

        Config cf = new Config();
        cf.readConfigFile();

        String url = "jdbc:mysql://"+Config.dbserver+":"+Config.dbport+"/"+Config.dbname;    
        String username = Config.dbuser; 
        String password = Config.dbpassword;

        try
         {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");// differs from DB server to server            

            }
            catch (ClassNotFoundException e)
            {

                JOptionPane.showMessageDialog(null, e.toString(), "Error",
                                        JOptionPane.ERROR_MESSAGE);
            }

           con = DriverManager.getConnection(url, username, password);

        }
        catch (Exception e)
        {

             JOptionPane.showMessageDialog(null, e.toString(), "Error",
                                        JOptionPane.ERROR_MESSAGE);
        }

    return con;
     }
    
    
}
