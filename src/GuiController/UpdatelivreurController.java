/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiController;

import entities.livreur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class UpdatelivreurController implements Initializable {
  @FXML private TextField txtid ;
    @FXML private TextField txtn ;
    @FXML private TextField txtp ;
    @FXML private TextField txtc;
    @FXML private TextField txtemail;
    @FXML private TextField txttel;
    @FXML private TextField txtad;
  
    @FXML private TextField txtnbliv ;
    public void findaction(ActionEvent event)
    {String id=txtid.getText();
    int idliv=Integer.parseInt(id) ;
    Gestionlivreur gs=new Gestionlivreur() ; 
     livreur liv=  gs.getlivreurid(idliv) ;
     if(liv.getNomL()!=null){
     txtn.setText(liv.getNomL());
     txtp.setText(liv.getPrenomL());
     txtc.setText(liv.getCin());
     txtemail.setText(liv.getEmail());
     txttel.setText(liv.getNumTel());
     txtad.setText(liv.getAdresse());}
     else {   Alert alert = new Alert(Alert.AlertType.ERROR) ;
       alert.setTitle("ERROR");
       alert.setHeaderText("information");
       alert.setContentText("aucun livreur avec ce identifiant !");
       alert.showAndWait() ;
    }
     
    }
    public void supprimeraction(ActionEvent event)
    {
    String sid=txtid.getText() ;
    int id=Integer.parseInt(sid) ;
   Gestionlivreur gs=new Gestionlivreur() ; 
   int status=gs.delete(id);
    if (status>0)
   {  txtn.clear();
        txtp.clear(); 
        txtc.clear();
        txtemail.clear();
        txttel.clear();
        txtad.clear();
       Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
     
 
        alert.setTitle("suppression");
       alert.setHeaderText("information");
       alert.setContentText("livreur supprimer avec succèe!");
       alert.showAndWait() ;
   }
   else {
       
       Alert alert = new Alert(Alert.AlertType.ERROR) ;
       alert.setTitle("suppression");
       alert.setHeaderText("information");
       
       alert.setContentText("livreur n'es pas supprimer");
       alert.showAndWait() ;
   }
   
    }
    public void save(ActionEvent event )
    {String sid=txtid.getText() ;
    int id=Integer.parseInt(sid) ;
    String nomL=txtn.getText();
    String prenomL=txtp.getText();
    String cin=txtc.getText();
    String email=txtemail.getText();
    String numTel=txttel.getText();
    String adresse=txtad.getText();
 
    livreur newliv =new livreur () ;  
    newliv.setId(id);
    newliv.setNomL(nomL); 
    newliv.setPrenomL(prenomL);
    newliv.setCin(cin);
    newliv.setEmail(email);
    newliv.setDisponibilite(false);
    newliv.setNumTel(numTel);
    newliv.setNblivraison(0);
    newliv.setAdresse(adresse);
    Gestionlivreur gs=new Gestionlivreur() ; 
   int status=gs.upadate(newliv);
   if (status>0)
   {Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
       alert.setTitle("modification");
       alert.setHeaderText("information");
       alert.setContentText("livreur modifier avec succèe!");
      
       alert.showAndWait() ;
   }
   else {
       Alert alert = new Alert(Alert.AlertType.ERROR) ;
       alert.setTitle("modification");
       alert.setHeaderText("information");
       alert.setContentText("livreur n'es pas modifiè");
       alert.showAndWait() ;
   }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
