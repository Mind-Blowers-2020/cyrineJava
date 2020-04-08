/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiController;

import entities.livraison;
import entities.livreur;
import entities.reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import utils.DataSource;

/**
 *
 * @author asus
 */
public class Gestionreclamation implements Initializable {

    @FXML private TableView<reclamation> table_rec ; 
@FXML private TableColumn< reclamation,Integer> idrecl; 
@FXML private TableColumn< reclamation,String> sujet;
@FXML private TableColumn< reclamation,Date> date; 

@FXML private TableColumn< reclamation,String> code_liv ;
@FXML private TableColumn< reclamation,String> etat ; 
@FXML private TableColumn< reclamation,String> commantaire; 
public ObservableList <reclamation> data =FXCollections.observableArrayList();
@FXML
   Connection con=DataSource.getInstance().getCnx(); 
   




    @FXML
 public void ajouterlivr(reclamation p)
    {   
   
        String requete=" insert into reclamation (sujet,date,etat,code_liv)values('"+p.getSujet()+"','"+p.getDate()+"','"+p.getEtat()+"','"+p.getCode_liv()+"')" ;
        try {
            
            Statement st =con.createStatement();
            st.executeUpdate(requete);
            System.out.println("ajout");
        } catch (SQLException ex) {
            Logger.getLogger(Gestionlivreur.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
      public ArrayList<String> affichepanier()
    {      ArrayList<String> liste=new ArrayList<String>() ; 
    
        
    try {
        
        String sql ="SELECT * FROM panier " ;
         Statement st ; 
              st=con.createStatement() ;
       
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            liste.add(rs.getString(4)) ;
        }
    } 
    catch (Exception e) {
        e.printStackTrace();
    }
   
    


return liste ;
} 
      public void  listerreclamation(){
            data.clear();
      try {
        
        String sql ="SELECT * FROM reclamation " ;
         Statement st ; 
              st=con.createStatement() ;
       
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
        data.add(new reclamation(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));}
      
    } 
    catch (Exception e) {
        e.printStackTrace();
    }

   idrecl.setCellValueFactory(new PropertyValueFactory<reclamation,Integer>("id"));
   sujet.setCellValueFactory(new PropertyValueFactory<reclamation,String>("sujet"));
  date.setCellValueFactory(new PropertyValueFactory<reclamation,Date>("date"));
  etat.setCellValueFactory(new PropertyValueFactory<reclamation,String>("etat"));
    code_liv.setCellValueFactory(new PropertyValueFactory<reclamation,String>("code_liv"));
    commantaire.setCellValueFactory(new PropertyValueFactory<reclamation,String>("commantaire"));
    
    
table_rec.setItems(data);}
     
   
      
      
  @FXML 
private AnchorPane panerec;

  public void savereclamtion(ActionEvent event) throws IOException
 

{
    AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/reclamtionfront.fxml"));
panerec.getChildren().setAll(pane);
}
  public void updatereclamation(){}
     public int delete (int idliv)
{ int st=0 ;
    try {
        String sql ="DELETE from reclamation where id=?" ;
    PreparedStatement stat;
 stat=con.prepareStatement(sql) ; 
 stat.setInt(1,idliv);
 st=stat.executeUpdate() ;
    } catch (SQLException e) { e.printStackTrace();
    }
return st ; 
}
public void supprimer(){
 int i=0;
        if (table_rec.getSelectionModel().getSelectedItem() != null) {
            reclamation p = table_rec.getSelectionModel().getSelectedItem();
            i=p.getId();
             Alert deleteBookAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteBookAlert.setTitle("suppresion reclamtion");
            deleteBookAlert.setHeaderText(null);
            deleteBookAlert.setContentText("vous étes sur de supprimer cette reclamtion  ?");
            Optional<ButtonType> optionDeleteBookAlert = deleteBookAlert.showAndWait();
            if (optionDeleteBookAlert.get() == ButtonType.OK) {
               
                delete(i);
                data.clear();
              listerreclamation();
           
    }
        }}
public  int upadate (reclamation liv,String etat)
{ int st=0 ; 
    try {
        String sql ="UPDATE reclamation SET etat=? WHERE id=?";
 PreparedStatement stat;
 stat=con.prepareStatement(sql) ;
 stat.setString(1, etat);
  stat.setString(1, etat);
 
    
       stat.setInt(2, liv.getId());
       st=stat.executeUpdate();
    } catch (Exception e) { e.printStackTrace();
    }
 
return st ; 
}
public void ejecter() {
int i=0;
        if (table_rec.getSelectionModel().getSelectedItem() != null) {
            reclamation p = table_rec.getSelectionModel().getSelectedItem();
            i=p.getId();
             Alert deleteBookAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteBookAlert.setTitle("refuser  reclamtion");
            deleteBookAlert.setHeaderText(null);
            deleteBookAlert.setContentText("vous étes sur de refuser cette reclamtion  ?");
            Optional<ButtonType> optionDeleteBookAlert = deleteBookAlert.showAndWait();
            if (optionDeleteBookAlert.get() == ButtonType.OK) {
               
              int i2;
              i2= upadate (p,"ejecter");
               data.clear();
              listerreclamation();
           
    }
        }}
public void accepter(){
int i=0;
        if (table_rec.getSelectionModel().getSelectedItem() != null) {
            reclamation p = table_rec.getSelectionModel().getSelectedItem();
            i=p.getId();
             Alert deleteBookAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteBookAlert.setTitle("accepter reclamtion");
            deleteBookAlert.setHeaderText(null);
            deleteBookAlert.setContentText("vous étes sur de accepter cette reclamtion  ?");
            Optional<ButtonType> optionDeleteBookAlert = deleteBookAlert.showAndWait();
            if (optionDeleteBookAlert.get() == ButtonType.OK) {
               
              int i2;
              i2= upadate (p,"accepter");
               data.clear();
              listerreclamation();
           
    }
        }}
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    listerreclamation();
    }
    
}
