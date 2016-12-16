/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * @author W. Estuardo
 */

public class Config 
{
        Properties prop = new Properties();
	InputStream input = null;
        
        public static String dbname;
        public static String dbpassword;
        public static String dbport;
        public static String dbserver;
        public static String dbuser;
    
        public void readConfigFile()
        {
            try {                                        
                    input = new FileInputStream("config.properties");

                    // load a properties file
                    prop.load(input);

                    // get the property value 
                    dbname = prop.getProperty("dbname");
                    dbpassword = prop.getProperty("dbpassword");
                    dbport = prop.getProperty("dbport");
                    dbserver = prop.getProperty("dbserver");
                    dbuser = prop.getProperty("dbuser");
                    
            } 
            catch (IOException ex) 
            {
                    ex.printStackTrace();
                     JOptionPane.showMessageDialog(null, ex.toString(), "Error",
                                    JOptionPane.ERROR_MESSAGE);
            } finally 
            {
                    if (input != null) {
                            try {
                                    input.close();
                            } catch (IOException e) {
                                    e.printStackTrace();
                            }
                    }
            }
        }
}
