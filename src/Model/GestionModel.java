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
    String Sql;
    
     public boolean create(String name, Double price, String comment) 
     {
        try 
        {
            con = model.createConnection();
             // create a Statement from the connection
            Statement statement = con.createStatement();
            // insert the data
            Sql="INSERT INTO type(name,price,comment) VALUES ('"+ name + "',"+price+","+comment+")";
            int rowsInserted = statement.executeUpdate(Sql);
            if (rowsInserted > 0) 
            {                
                JOptionPane.showMessageDialog(null, "Nuevo registro ingresado exitosamente", "Añadir",
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
 
      public DefaultTableModel read ()
     {
        Statement stmt = null;
        DefaultTableModel model1 = null;                
        
        try 
        {
            con = model.createConnection();
            // create a Statement from the connection
            stmt = con.createStatement();
            
            String sql = "SELECT _idtype, name, price, comment FROM type";
            ResultSet rs = stmt.executeQuery(sql);
            
            model1=buildTableModel(rs);
            model1.fireTableDataChanged();
          
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
     
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException 
     {

        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
     
    public boolean update(Integer _idType, String name, Double price, String comment)
    {
        try 
        {
            con = model.createConnection();                        
            PreparedStatement preparedStatement = null;
            String Sql = "UPDATE type SET name = ? " + ", price= ? "+ ", comment = ? "
				                  + " WHERE _idtype = ?";
            
            preparedStatement = con.prepareStatement(Sql);
            
			preparedStatement.setString(1, name);
                        preparedStatement.setDouble(2, price);
                        preparedStatement.setString(3, comment);
			preparedStatement.setInt(4, _idType);

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
    
    public boolean delete(Integer _idType)
    {
         try 
        {
            con = model.createConnection();                        
            PreparedStatement preparedStatement = null;
            String Sql = "DELETE from type " + " WHERE _idtype = ?";
            
            preparedStatement = con.prepareStatement(Sql);
            preparedStatement.setInt(1, _idType);

            // execute update SQL stetement			            
            int rowsUpdated = preparedStatement.executeUpdate();
            
            if (rowsUpdated > 0) 
            {                
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente", "Eliminar",
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
