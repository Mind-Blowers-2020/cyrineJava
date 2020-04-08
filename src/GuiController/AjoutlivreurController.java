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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        public void afficherAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        //alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
    
    public boolean validationemail()
{ Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
Matcher m=p.matcher(txtemail.getText());
if(m.find()&&m.group().equals(txtemail.getText())){return true ;}
else {afficherAlert("email invalide  ");
        return false ;}
}

    public boolean testSaisie() {
        
       // System.out.println("compare="+dateDebut.getValue().compareTo(dateFin.getValue()));

        if (txtn.getText().trim().isEmpty() || txtp.getText().trim().isEmpty()
                || txtc.getText().trim().isEmpty()||txtemail.getText().trim().isEmpty()||txttel.getText().trim().isEmpty()
                
                || txtad.getText().trim().isEmpty()
                
                //|| imageFileLabel.getText().trim().isEmpty()
                ) {
            afficherAlert("Tous les champs doivent être remplis");
            return false;
        }
        /*String r=NameClass.getText().substring(0,1);
        String r2=NameClass.getText().substring(0,2);
        if(!r.equals(NiveauClass.getValue())&& !r2.equals(SpecClass.getValue()))
                {
            afficherAlert("verifier niveau et specalite champ");
            return false;  
                }*/
        if (
                txtc.getText().trim().length()!=8
                
                
                
                //|| imageFileLabel.getText().trim().isEmpty()
                ) {
            afficherAlert("cin invalide ");
            return false;
        }
        if (txttel.getText().trim().length()!=8)
        {afficherAlert("numero de tel inavlide ");
        return false ;}

        
        return true;
    }
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
 
 
    if (testSaisie()&& validationemail()){
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
       alert.showAndWait() ; }
    
    
    
    
    
        
        
        
    }
    
}
