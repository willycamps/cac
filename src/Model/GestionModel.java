/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author W. Estuardo
 */

public class GestionModel 
{
    
    DBConnection model = new DBConnection();    
    Connection con = null;
    
     public boolean create(String name, Double price, String comment) 
     {
        try 
        {
            con = model.createConnection();
             // create a Statement from the connection
            Statement statement = con.createStatement();
            // insert the data
            statement.executeUpdate("INSERT INTO type VALUES ("+ name + ","+price+","+comment);
            return true;
        } 
        catch (Exception er) 
        {
            JOptionPane.showMessageDialog(null, er.toString(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
     }
     
     public void read ()
     {
         Statement stmt = null;
          try 
        {
            con = model.createConnection();
            // create a Statement from the connection
            stmt = con.createStatement();
            
            String sql = "SELECT _idtype, name, price, comment FROM type";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next())
            {
                //Retrieve by column name
                int id  = rs.getInt("_idtype");
                String Name = rs.getString("name");
                Double Price = rs.getDouble("price");
                String Comment = rs.getString("comment");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + Name);
                System.out.print(", Price: " + Price);
                System.out.println(", Comment: " + Comment);
            }
            
            rs.close();            
            //return true;
        } 
        catch (Exception er) 
        {
            //return false;
            System.out.print("PROBLEM!!!: "+er.getMessage());
        }     
     }       
             
     
    
    
}
