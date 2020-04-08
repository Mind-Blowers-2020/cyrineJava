/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiController;

import entities.livraison;
import entities.reclamation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReclamtionfrontController implements Initializable {
Gestionreclamation gs= new Gestionreclamation() ; 
     @FXML private ComboBox<String> code_liv ;
     @FXML private RadioButton retard ; 
     @FXML private RadioButton nonconforme ; 
      @FXML private RadioButton defect ; 
       @FXML private RadioButton service ; 
      // @FXML private cmnt ;
       @FXML private Label RadioButonlabel ;
       @FXML private Button Upload;
      
        String listview,Path;
 
   LocalDate datee=java.time.LocalDate.now();
   

    
 private ObservableList< String> list2=FXCollections.observableArrayList(gs.affichepanier());
   public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
    return java.sql.Date.valueOf(dateToConvert);
}
 public void envoyerreclamation()
 {    Connection con=DataSource.getInstance().getCnx(); 
 String code_livr=code_liv.getValue() ;

 String etat="recu" ;
 reclamation recl=new reclamation();
 recl.setCode_liv(code_livr);
 recl.setDate(convertToDateViaSqlDate(datee));
 recl.setEtat(etat);
 
         
     if (retard.isSelected())
 { String sujet="retard" ;
     
     recl.setSujet(sujet);
 }
 if(nonconforme.isSelected())
 {
 String sujet="nonconforme" ;
  recl.setSujet(sujet);}
 if(defect.isSelected())
 {String sujet="defectuex" ;
  recl.setSujet(sujet);
     
 }
 if (service.isSelected())
 {
 String sujet="mauvais service" ;
  recl.setSujet(sujet);
 }
 Gestionreclamation gs =new Gestionreclamation();
 gs.ajouterlivr(recl);
    Alert alert = new Alert(Alert.AlertType.INFORMATION) ;
       alert.setTitle("ajout livreur !");
       alert.setHeaderText("information");
       alert.setContentText("livraison bien ajouter!");
       alert.showAndWait() ;
    
 }
   @FXML
    private void uploadAction(ActionEvent event) {
            FileChooser fc = new FileChooser();
    fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("PDF Files","*.PDF"),
            new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
            new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
            new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
            new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
            new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html"),
            new FileChooser.ExtensionFilter("Ennour File (*.Ennour)", "*.Ennour")
    );
    File selectedFiles = fc.showOpenDialog(null);
    if (selectedFiles !=null){
        
        listview=selectedFiles.getName();
        Path=selectedFiles.getAbsolutePath();
            System.out.println(listview);
            
            
        }else{
        System.out.println("file is not valid");
    }
    Upload.setText(listview);
    }

 @FXML 
private AnchorPane panereclamation;
 public void annulerreclamation(ActionEvent event) throws IOException
{/*AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/home.fxml"));
 panereclamation.getChildren().setAll(pane);*/}
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        code_liv.setItems(list2);
         ToggleGroup group = new ToggleGroup();
         this.defect.setToggleGroup(group);
         this.nonconforme.setToggleGroup(group);
         this.retard.setToggleGroup(group);
         this.service.setToggleGroup(group);
         
        // TODO
    }    
    
}
