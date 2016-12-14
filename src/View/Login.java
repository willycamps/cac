/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import Model.DBConnection;
import View.PanelControl;
import java.sql.Connection;

/**
 *
 * @author HP PAVILION
 */
public class Login extends Application 
{
    
    @Override
    public void start(Stage primaryStage) 
    {        
        //Connection con = null;
        //con = DBConnection.createConnection(); //establishing connection
        
        Button btn = new Button();
        btn.setText("Iniciar");
        btn.setOnAction(new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent event) 
            {
                //System.out.println("Hello World!");
                //Connection con = null;
                //con = DBConnection.createConnection(); //establishing connection
                
                /*if(con !=null)
                {
                    System.out.println("It works!");
                }*/
                
                PanelControl cp = new PanelControl();
                cp.setVisible(true);
                primaryStage.hide();
                
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 450, 150);
        
        primaryStage.setTitle("Campos Arquitectura Control (CAC)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
