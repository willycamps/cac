/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.*;
import javax.swing.JOptionPane;
/**
 * @author W. Estuardo
 */
public class GestionController 
{
    GestionModel model = new GestionModel();
   public boolean create(String type, String print, Double price, String comment) 
     {         
        try 
        {
            String name = type+" "+print;
            model.create(name, price, comment);                        
            System.out.println("Sucessful CREATE");
            return true;
        } 
        catch (Exception er) 
        {             
            System.out.println("Failed CREATE");
            return false;            
        }
    } 
    
    public void read()
    {
         try 
        {
            model.read();
        } 
        catch (Exception er) 
        {
                         
            
        }
        
    }
    
    
    
}
