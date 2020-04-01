/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.livreur;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author asus
 */
public class livreurService {
    Connection cn=DataSource.getInstance().getCnx(); 
      public void ajouterPersonne(livreur p)
      {        String requete=" insert into livreur (noml,prenoml,cin,email,numTel,adresse,disponibilite,nblivraison)values('"+p.getNomL()+"','"+p.getPrenomL()+"','"+p.getCin()+"','"+p.getEmail()+"','"+p.getNumTel()+"','"+p.getAdresse()+"','"+p.isDisponibilite() +"','"+p.getNblivraison()+"')" ;
        try {
            Statement st =cn.createStatement();
            st.executeUpdate(requete);
            System.out.println("ajout");
        } catch (SQLException ex) {
            Logger.getLogger(livreurService.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
    }
}
