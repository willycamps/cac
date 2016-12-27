/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import javax.swing.table.*;
/**
 * @author W. Estuardo
 */
public class GestionController 
{
   GestionModel model = new GestionModel();
   DefaultTableModel model1 = null;
   
   public boolean create(String type, String print, Double price, String comment) 
    {         
        try 
        {
            String name = type+" "+print;
            String comment_= null;
            if(!comment.isEmpty())
            {
                comment_="'"+ comment+"'";
            }
            if (model.create(name, price, comment_))
            {
                return true;
            }            
            return false;   
        } 
        catch (Exception er) 
        {                         
            return false;            
        }
    } 
    
    public DefaultTableModel read()
    {
        try 
        {
            model1 = model.read();            
        } 
        catch (Exception er) 
        {
                                     
        }         
         return model1;        
    }
    
    public boolean update(Integer _idtype,String type, String print, Double price, String comment)
    {
        try 
        {
            String name = type+" "+print;
            String comment_= null;
            if(!comment.isEmpty())
            {
                comment_="'"+ comment+"'";
            }
            if (model.update(_idtype,name, price, comment_))
            {
                return true;
            }            
            return false;   
        } 
        catch (Exception er) 
        {                         
            return false;            
        }
    }
    
    public boolean delete(Integer _idtype)
    {
     try
     {
         if(model.delete(_idtype))
         {
             return true;
         }
        return false;   
     }
     catch(Exception Ex)
     {
     }
        return false;
    }
    
    
}
