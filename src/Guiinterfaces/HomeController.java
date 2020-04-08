/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guiinterfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class HomeController implements Initializable {
@FXML 
private AnchorPane rootpane;

@FXML
public void lancerlistelivreur(ActionEvent event) throws IOException
{AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/listelivreur.fxml"));
rootpane.getChildren().setAll(pane);
}

@FXML
public void lancerlivraison(ActionEvent event) throws IOException
{AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/listelivraison.fxml"));
rootpane.getChildren().setAll(pane);
}
@FXML
public void lancerfront(ActionEvent event) throws IOException
{AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/reclamtionfront.fxml"));
rootpane.getChildren().setAll(pane);
}

@FXML
public void lancerlistereclamation(ActionEvent event) throws IOException
{AnchorPane pane =FXMLLoader.load(getClass().getResource("/Guiinterfaces/listereclamation.fxml"));
rootpane.getChildren().setAll(pane);
}


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
