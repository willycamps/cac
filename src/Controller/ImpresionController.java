/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 * @author W. Estuardo
 */
public class ImpresionController 
{
   ImpresionModel model = new ImpresionModel();
   
   private String getdatetime()
   {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        return dateFormat.format(date);
   }
   
   public Double create(Integer _idtype, Integer amount, Double _price, Boolean valid, String comment) 
    {       
        Double _Total;
       
        try 
        {
            String comment_= null;
            if(!comment.isEmpty())
            { comment_="'"+ comment+"'";
            }
            _Total= (amount * _price);                      
            
            if(model.create(_idtype, amount, getdatetime(), _Total, valid, comment_)> 0)            
            {
                return _Total;                
            }
            
           return -1.00;
        } 
        catch (Exception er) 
        {                         
           JOptionPane.showMessageDialog(null, er.toString(), "Error - Controller",
                                   JOptionPane.ERROR_MESSAGE);
          return -1.00;
        }
    } 
         
  
        
}
