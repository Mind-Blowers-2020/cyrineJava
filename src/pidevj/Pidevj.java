/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevj;

import entities.livreur;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.livreurService;
import utils.DataSource;


/**
 *
 * @author asus
 */
public class Pidevj extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Guiinterfaces/home.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
    }

 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException  {
        launch(args);
       /* livreur p=new livreur ("test","test2","12","mail@ll","123333","ad",0,1);
         livreurService ps=new livreurService() ; 
        ps.ajouterPersonne(p);
         DataSource ds =DataSource.getInstance(); 
          
            System.out.println("connexion.Connexion.main()"+ds.hashCode());
            */
    }
    
}
