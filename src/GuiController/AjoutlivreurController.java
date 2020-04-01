/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiController;

import entities.livreur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import GuiController.Gestionlivreur ;
import javafx.scene.control.Alert;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjoutlivreurController implements Initializable {

    @FXML private TextField txtid ;
    @FXML private TextField txtn ;
    @FXML private TextField txtp ;
    @FXML private TextField txtc;
    @FXML private TextField txtemail;
    @FXML private TextField txttel;
    @FXML private TextField txtad;
    @FXML private CheckBox dispo;
    @FXML private TextField txtnbliv ;
     private ObservableList< String> list=FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
     
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 
       
    }   
    
    public void videraction (ActionEvent event)
    {
        txtn.clear();
        txtp.clear(); 
        txtc.clear();
        txtemail.clear();
        txttel.clear();
        txtad.clear();
    }
    
    public void ajouter (ActionEvent event )
    {    
    
    
    String nomL=txtn.getText();
    String prenomL=txtp.getText();
    String cin=txtc.getText();
    String email=txtemail.getText();
    String numTel=txttel.getText();
    String adresse=txtad.getText();
 
    livreur newliv =new livreur () ;  
    newliv.setId(555);
    newliv.setNomL(nomL); 
    newliv.setPrenomL(prenomL);
    newliv.setCin(cin);
    newliv.setEmail(email);
    newliv.setDisponibilite(false);
    newliv.setNblivraison(0);
    newliv.setAdresse(adresse);
     Gestionlivreur gs=new Gestionlivreur() ; 
       gs.ajouterlivr(newliv);
       Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
       alert.setTitle("ajout livreur !");
       alert.setHeaderText("information");
       alert.setContentText("livreur bien ajouter!");
       alert.showAndWait() ;
    
    
    
    
        
        
        
    }
    
}
