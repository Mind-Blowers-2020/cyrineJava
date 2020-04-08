/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiController;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import entities.livraison;
import entities.livreur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import sun.plugin.dom.core.Document;

import utils.DataSource;

/**
 *
 * @author asus
 */
public class Gestionlivraison implements Initializable {
   
 @FXML private TableView<livraison> table_liv ; 
@FXML private TableColumn< livraison,Integer> id_liv; 
@FXML private TableColumn< livraison,Integer> id_livreur;
@FXML private TableColumn< livraison,Integer>id_panier ;

@FXML private TableColumn< livraison,Date> date; 

@FXML private TableColumn< livraison,String> destination ; 
@FXML private TableColumn< livraison,Float> cout_liv; 
public ObservableList <livraison> data =FXCollections.observableArrayList();
@FXML
   Connection con=DataSource.getInstance().getCnx(); 

@FXML
 public void ajouterlivr(livraison p)
    {   
   
        String requete=" insert into livraison (id_livreur,id_panier,date,destination,cout_liv)values('"+p.getId_livreur()+"','"+p.getId_panier()+"','"+p.getDate()+"','"+p.getDestionation()+"','"+p.getCout_liv()+"')" ;
        try {
            
            Statement st =con.createStatement();
            st.executeUpdate(requete);
            System.out.println("ajout");
        } catch (SQLException ex) {
            Logger.getLogger(Gestionlivreur.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
 public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
 public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
    return java.sql.Date.valueOf(dateToConvert);
}
 
   @FXML
    public void listerlivraison()
            
    {
        
    try {
        
        String sql ="SELECT * FROM livraison " ;
         Statement st ; 
              st=con.createStatement() ;
       
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
        data.add(new livraison(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4),rs.getString(5),rs.getFloat(6)));}
      
    } 
    catch (Exception e) {
        e.printStackTrace();
    }

    id_liv.setCellValueFactory(new PropertyValueFactory<livraison,Integer>("id"));
   id_livreur.setCellValueFactory(new PropertyValueFactory<livraison,Integer>("id_livreur"));
   id_panier.setCellValueFactory(new PropertyValueFactory<livraison,Integer>("id_panier"));
   date.setCellValueFactory(new PropertyValueFactory<livraison,Date>("date"));
  destination.setCellValueFactory(new PropertyValueFactory<livraison,String>("destination"));
    cout_liv.setCellValueFactory(new PropertyValueFactory<livraison,Float>("cout_liv"));
    
    
table_liv.setItems(data);

}
    public int delete (int idliv)
{ int st=0 ;
    try {
        String sql ="DELETE from livraison where id=?" ;
    PreparedStatement stat;
 stat=con.prepareStatement(sql) ; 
 stat.setInt(1,idliv);
 st=stat.executeUpdate() ;
    } catch (SQLException e) { e.printStackTrace();
    }
return st ; 
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

    public ArrayList<String> affiche()
    {      ArrayList<String> liste=new ArrayList<String>() ; 
    
        
    try {
        
        String sql ="SELECT * FROM livreur " ;
         Statement st ; 
              st=con.createStatement() ;
       
        ResultSet rs=st.executeQuery(sql);
        while(rs.next())
        {
            liste.add(rs.getString(2)) ;
        }
    } 
    catch (Exception e) {
        e.printStackTrace();
    }
   
    


return liste ;
}
    public  int upadate (livraison liv)
{ int st=0 ; 
    try {
        String sql ="UPDATE livraison SET id_livreur=?,date=?,destination=?,cout_liv=? WHERE id=?";
 PreparedStatement stat;
 stat=con.prepareStatement(sql) ;
 stat.setInt(1, liv.getId_livreur());
 
   stat.setDate(2, liv.getDate());
    stat.setString(3, liv.getDestionation());
     stat.setFloat(4, liv.getCout_liv());
      
    
       stat.setInt(5, liv.getId());
       st=stat.executeUpdate();
    } catch (Exception e) { e.printStackTrace();
    }
 
return st ; 
}
    
   /* @FXML 
    public void  generatepdf(ActionEvent event)
    {String path="" ;
        JFileChooser j=new JFileChooser();
    j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int x; 
     x = j.showSaveDialog(j);
    if (x==JFileChooser.APPROVE_OPTION)
    {
    path =j.getSelectedFile().getPath() ;}
    Document doc =new Document() ;
    PdfWriter.getInstance(doc,new FileOutStream(path+"av.pdf"));
    
    }*/
    @FXML 
    
    public void supprimer(ActionEvent event)
    {
        int i=0;
        if (table_liv.getSelectionModel().getSelectedItem() != null) {
            livraison p = table_liv.getSelectionModel().getSelectedItem();
            i=p.getId();
             Alert deleteBookAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteBookAlert.setTitle("suppresion participant");
            deleteBookAlert.setHeaderText(null);
            deleteBookAlert.setContentText("vous étes sur de supprimer ce participant ?");
            Optional<ButtonType> optionDeleteBookAlert = deleteBookAlert.showAndWait();
            if (optionDeleteBookAlert.get() == ButtonType.OK) {
               
                delete(i);
                data.clear();
              listerlivraison();
           
    }
        }}
    
    public livraison getlivraisonid(int id)
{
    livraison liv =new livraison(); 
    try {
        String sql ="SELECT * from livraison where id=?";
            PreparedStatement stat;
 stat=con.prepareStatement(sql) ; 
 stat.setInt(1,id);
 ResultSet rst =stat.executeQuery();
 if (rst.next())
 {
 liv.setDate(rst.getDate(4));
 liv.setDestionation(rst.getString(5));
 liv.setCout_liv(rst.getFloat(6));
 
 
 }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return liv ;
}
    
@FXML 
private AnchorPane panelivraison;
@FXML
public void ajouterlivraison(ActionEvent event) throws IOException
{AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/ajoutlivraison.fxml"));
panelivraison.getChildren().setAll(pane);
}

@FXML
public void lancermodifier (ActionEvent event) throws IOException
{AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/updatelivraison.fxml"));
 panelivraison.getChildren().setAll(pane);
}
   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listerlivraison();
    } 
    }
    
    
    
    
    

  

