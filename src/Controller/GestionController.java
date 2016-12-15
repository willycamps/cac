/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.*;

/**
 * @author W. Estuardo
 */
public class GestionController 
{
    GestionModel model = new GestionModel();
   public boolean create(Integer _id, String name, Double price, String comment) 
     {
         
        try 
        {
            
            
            //return model.writeData(message);
            
            return true;
        } 
        catch (Exception er) 
        {
            return false;
        }
    } 
    
    public void read()
    {
        model.read();
    }
    
    
    
}
