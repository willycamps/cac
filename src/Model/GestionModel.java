/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.*;

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
     
     public DefaultTableModel read ()
     {
        Statement stmt = null;
        DefaultTableModel model1 = null;
        
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();
        
        try 
        {
            con = model.createConnection();
            // create a Statement from the connection
            stmt = con.createStatement();
            
            String sql = "SELECT _idtype, name, price, comment FROM type";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
           /* while(rs.next())
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
            */
            
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }

            //  Get row data

            while (rs.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }
            
            model1 = new DefaultTableModel(data, columnNames)
            {
                @Override
                public Class getColumnClass(int column)
                {
                    for (int row = 0; row < getRowCount(); row++)
                    {
                        Object o = getValueAt(row, column);

                        if (o != null)
                        {
                            return o.getClass();
                        }
                    }

                    return Object.class;
                }
            };
            
            rs.close();
            stmt.close();                        
            con.close();                        
            
        } 
        catch (Exception er) 
        {
            //return false;
            System.out.print("PROBLEM!!!: "+er.getMessage());
        }                   
         return model1;
     }       
             
     
    
    
}
