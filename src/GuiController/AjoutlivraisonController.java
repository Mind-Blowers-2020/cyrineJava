/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiController;

import entities.livraison;
import entities.livreur;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjoutlivraisonController implements Initializable {
Gestionlivraison gs =new Gestionlivraison() ;
    @FXML private TextField id ;
    @FXML private ComboBox<String> id_livreur ;
     @FXML private ComboBox<String> id_panier ;
     private ObservableList< String> list=FXCollections.observableArrayList(gs.affiche());
 private ObservableList< String> list2=FXCollections.observableArrayList(gs.affichepanier());
   
    @FXML private DatePicker date;
    @FXML private TextField destination;
    @FXML private TextField cout_liv;
       public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
    return java.sql.Date.valueOf(dateToConvert);
}
    public void ajoutlivraison(ActionEvent event)
{
 
   Connection con=DataSource.getInstance().getCnx(); 
 int id2=0 ;
  int idp=0 ;
        try {
                 String sql ="SELECT * FROM livreur where livreur.nomL='"+id_livreur.getValue() +"'";
                 String sqlp="SELECT * FROM panier where panier.commande='"+id_panier.getValue() +"'";
         Statement st2 ; 
              st2=con.createStatement() ;
                   Statement st3; 
              st3=con.createStatement() ;
       ResultSet rs2=st2.executeQuery(sqlp);
        ResultSet rs=st3.executeQuery(sql);
        while(rs.next())
        {id2=rs.getInt(1) ;
        }
        while(rs2.next())
        {
         idp=rs2.getInt(1);
            System.out.println("GuiController.AjoutlivraisonController.ajoutlivraison()"+idp);}
        } catch (SQLException ex) {
            Logger.getLogger(Gestionlivreur.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    String idd=id.getText();
 
   LocalDate datee=date.getValue() ;
    String destinatione=destination.getText();
    String cout_live=cout_liv.getText();
 
    livraison newliv =new livraison();  
  newliv.setId(Integer.parseInt(idd));
  newliv.setId_livreur(id2);
  newliv.setId_panier(idp);
  newliv.setDate(convertToDateViaSqlDate(datee));
  newliv.setDestionation(destinatione);
  newliv.setCout_liv(Float.parseFloat(cout_live));
     Gestionlivraison gs=new Gestionlivraison() ; 
       gs.ajouterlivr(newliv);
       Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
       alert.setTitle("ajout livreur !");
       alert.setHeaderText("information");
       alert.setContentText("livraison bien ajouter!");
       alert.showAndWait() ;
    
    
    
    
        
        
        
    }
    public void viderchamps()
{
   id_livreur.getItems().clear() ;
 id.clear();
  
     destination.clear ();
    cout_liv.clear() ;

}
    /**
     * Initializes the controller class.
     */
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
        
id_livreur.setItems( list);
id_panier.setItems(list2);
// TODO
    }   }
 
    

