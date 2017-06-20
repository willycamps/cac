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

public class ImpresionModel 
{
            
    DBConnection model = new DBConnection();    
    Connection con = null;
    String Sql;
    
    public Double create(Integer _idtype, Integer amount, String _date, Double Total, Boolean valid, String comment) 
    {
       try 
       {
           con = model.createConnection();            
           Statement statement = con.createStatement();
           // insert the data
           Sql="INSERT INTO print(_idtype, amount, date, total, valid, comment) VALUES ("+ _idtype + ","+amount+",'"+_date+"',"+Total+","+valid+","+comment+")";
           int rowsInserted = statement.executeUpdate(Sql);
           if (rowsInserted > 0) 
           {                              
               return Total;
           }
           return -1.00;
       } 
       catch (Exception er) 
       {
           JOptionPane.showMessageDialog(null, er.toString(), "Error - Model",
                                   JOptionPane.ERROR_MESSAGE);
           return -1.00;
       }
    }
    
    public boolean update(Integer _idprint, Integer valid, String comment)
    {
        try 
        {
            con = model.createConnection();                        
            PreparedStatement preparedStatement = null;
            String Sql = "UPDATE print SET valid = ? " + ", comment = ? "
				                  + " WHERE _idprint = ?";
            
            preparedStatement = con.prepareStatement(Sql);
            			
                        preparedStatement.setInt(1, valid);
                        preparedStatement.setString(2, comment);
			preparedStatement.setInt(3, _idprint);

			// execute update SQL stetement			            
            int rowsUpdated = preparedStatement.executeUpdate();
            
            if (rowsUpdated > 0) 
            {                
                JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente", "Actualizar",
                                    JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            return false;
        } 
        catch (Exception er) 
        {
            JOptionPane.showMessageDialog(null, er.toString(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
            return false;            
        }
    
    }
    
}
