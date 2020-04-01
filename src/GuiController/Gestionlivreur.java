/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiController;

import entities.livreur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import utils.DataSource;
import utils.conbd;

/**
 *
 * @author asus
 */
public class Gestionlivreur implements Initializable {
@FXML private TableView<livreur> table ;
@FXML private TableColumn< livreur,String> noml ; 
@FXML private TableColumn< livreur,String> prenoml ; 
@FXML private TableColumn< livreur,String> cin; 
@FXML private TableColumn< livreur,String> email ; 
@FXML private TableColumn< livreur,String> numtel ; 
@FXML private TableColumn< livreur,String> adresse; 
@FXML private TableColumn< livreur,Boolean> disponibilite ; 
@FXML private TableColumn< livreur,Integer> nblivraison ; 
@FXML private TableColumn< livreur,Button> detail;
public ObservableList <livreur> data =FXCollections.observableArrayList();
@FXML
   Connection con=DataSource.getInstance().getCnx(); 
    public void ajouterlivr(livreur p)
    {      

        String requete=" insert into livreur (nomL,prenomL,Cin,email,numTel,adresse,disponibilite,nblivraison)values('"+p.getNomL()+"','"+p.getPrenomL()+"','"+p.getCin()+"','"+p.getEmail()+"','"+p.getNumTel()+"','"+p.getAdresse()+"','"+0+"','"+p.getNblivraison()+"')" ;
        try {
            Statement st =con.createStatement();
            st.executeUpdate(requete);
            System.out.println("ajout");
        } catch (SQLException ex) {
            Logger.getLogger(Gestionlivreur.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
    
    
    
    @FXML
public void afficherlivreur()
{
    try {
        
        String sql ="SELECT * FROM livreur " ;
         Statement st ; 
              st=con.createStatement() ;
       
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
        data.add(new livreur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBoolean(8),rs.getInt(9)));}
    } 
    catch (Exception e) {
        e.printStackTrace();
    }
    noml.setCellValueFactory(new PropertyValueFactory<livreur,String>("nomL"));
   prenoml.setCellValueFactory(new PropertyValueFactory<livreur,String>("prenomL"));
   cin.setCellValueFactory(new PropertyValueFactory<livreur,String>("cin"));
    email.setCellValueFactory(new PropertyValueFactory<livreur,String>("email"));
   numtel.setCellValueFactory(new PropertyValueFactory<livreur,String>("numTel"));
    adresse.setCellValueFactory(new PropertyValueFactory<livreur,String>("adresse"));
    disponibilite.setCellValueFactory(new PropertyValueFactory<livreur,Boolean>("disponibilite"));
    nblivraison.setCellValueFactory(new PropertyValueFactory<livreur,Integer>("nblivraison"));
    
table.setItems(data);

}
public  int upadate (livreur liv)
{ int st=0 ; 
    try {
        String sql ="UPDATE livreur SET nomL=? , prenomL=? , Cin=? , email=? , numTel=? , adresse=? WHERE id_livreur=?";
 PreparedStatement stat;
 stat=con.prepareStatement(sql) ;
 stat.setString(1, liv.getNomL());
  stat.setString(2, liv.getPrenomL());
   stat.setString(3, liv.getCin());
    stat.setString(4, liv.getEmail());
     stat.setString(5, liv.getNumTel());
      stat.setString(6, liv.getAdresse());
    
       stat.setInt(7, liv.getId());
       st=stat.executeUpdate();
    } catch (Exception e) { e.printStackTrace();
    }
 
return st ; 
}
public int delete (int idliv)
{ int st=0 ;
    try {
        String sql ="DELETE from livreur where id_livreur=?" ;
    PreparedStatement stat;
 stat=con.prepareStatement(sql) ; 
 stat.setInt(1,idliv);
 st=stat.executeUpdate() ;
    } catch (SQLException e) { e.printStackTrace();
    }
return st ; 
}
public livreur getlivreurid(int id)
{
    livreur liv =new livreur(); 
    try {
        String sql ="SELECT * from livreur where id_livreur=?";
            PreparedStatement stat;
 stat=con.prepareStatement(sql) ; 
 stat.setInt(1,id);
 ResultSet rst =stat.executeQuery();
 if (rst.next())
 {liv.setNomL(rst.getString(2));
 liv.setPrenomL(rst.getString(3));
 liv.setCin(rst.getString(4));
 liv.setEmail(rst.getString(5));
 liv.setNumTel(rst.getString(6));
 liv.setAdresse(rst.getString(7));
 
 
 }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return liv ;
}



@FXML 
private AnchorPane panelivreur;
@FXML
public void lancerajout(ActionEvent event) throws IOException
{AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/ajoutlivreur.fxml"));
panelivreur.getChildren().setAll(pane);
}

@FXML
public void lancermodifier (ActionEvent event) throws IOException
{AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/updatelivreur.fxml"));
 panelivreur.getChildren().setAll(pane);
}


/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

