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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class UpdatelivraisonController implements Initializable {
    Gestionlivraison gs =new Gestionlivraison() ;
  @FXML private TextField id ;
    @FXML private TextField txtdest ;
    @FXML private TextField txtcout ;
    @FXML private DatePicker date ;
    @FXML private ComboBox idcmd ;
    @FXML private ComboBox idliv;
    
     //@FXML private TextField id_panier ;
     private ObservableList< String> list=FXCollections.observableArrayList(gs.affiche());
   
  public void chercherlivraison(ActionEvent event)
    {String idl=id.getText();
    int idliv2=Integer.parseInt(idl) ;
    Gestionlivraison gs=new Gestionlivraison(); 
     livraison liv=  gs.getlivraisonid(idliv2) ;
     if(liv.getDate()!=null){
     txtdest.setText(liv.getDestionation());
     String coutstring=String.valueOf(liv.getCout_liv()) ;

     txtcout.setText(coutstring);
     idliv.setValue(liv.getId_livreur());
 
     }
     else {   Alert alert = new Alert(Alert.AlertType.ERROR) ;
       alert.setTitle("ERROR");
       alert.setHeaderText("information");
       alert.setContentText("aucune livraison avec ce identifiant !");
       alert.showAndWait() ;
    }
     
    }
         public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
    return java.sql.Date.valueOf(dateToConvert);
}
  
   public void save(ActionEvent event )
    { Connection con=DataSource.getInstance().getCnx(); 
 int id2=0 ;
        try {
                 String sql ="SELECT * FROM livreur where livreur.nomL='"+idliv.getValue() +"'";
         Statement st2 ; 
              st2=con.createStatement() ;
       
        ResultSet rs=st2.executeQuery(sql);
        while(rs.next())
        {id2=rs.getInt(1) ;}
        
        } catch (SQLException ex) {
            Logger.getLogger(Gestionlivreur.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    String idd=id.getText();
 
   LocalDate datee=date.getValue() ;
    String destinatione=txtdest.getText();
    String cout_live=txtcout.getText();
 
    livraison newliv =new livraison();  
  newliv.setId(Integer.parseInt(idd));
  newliv.setId_livreur(id2);
  newliv.setDate(convertToDateViaSqlDate(datee));
  newliv.setDestionation(destinatione);
  newliv.setCout_liv(Float.parseFloat(cout_live));
     Gestionlivraison gs=new Gestionlivraison() ; 
        int status=gs.upadate(newliv);
   if (status>0)
   {Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
       alert.setTitle("modification");
       alert.setHeaderText("information");
       alert.setContentText("livraison modifier avec succèe!");
      
       alert.showAndWait() ;
   }
   else {
       Alert alert = new Alert(Alert.AlertType.ERROR) ;
       alert.setTitle("modification");
       alert.setHeaderText("information");
       alert.setContentText("livraison n'es pas modifiè");
       alert.showAndWait() ;
   }
    
    
        
    }
    
   public void supprimeraction()
   {
   String sid=id.getText() ;
    int id=Integer.parseInt(sid) ;
   Gestionlivraison gs=new Gestionlivraison(); 
   int status=gs.delete(id);
    if (status>0)
   {  idliv.getItems().clear() ;
       this.id.clear();
   
   
     txtdest.clear ();
    txtcout.clear() ;

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
       alert.showAndWait() ;}}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idliv.setItems( list);
        // TODO
    }    
    
}
