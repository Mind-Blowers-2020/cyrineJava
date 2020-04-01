/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author asus
 */
public class livraison {
    int id ;
    int id_livreur ; 
    int id_panier;
    Date  date ;
    String destionation ; 
    float cout_liv ;

    public livraison(int id, int id_livreur, int id_panier, Date date, String destionation, float cout_liv) {
        this.id = id;
        this.id_livreur = id_livreur;
        this.id_panier = id_panier;
        this.date = date;
        this.destionation = destionation;
        this.cout_liv = cout_liv;
    }

    @Override
    public String toString() {
        return "livraison{" + "id=" + id + ", id_livreur=" + id_livreur + ", id_panier=" + id_panier + ", date=" + date + ", destionation=" + destionation + ", cout_liv=" + cout_liv + '}';
    }

    public livraison() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_livreur() {
        return id_livreur;
    }

    public void setId_livreur(int id_livreur) {
        this.id_livreur = id_livreur;
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

    public String getDestionation() {
        return destionation;
    }

    public void setDestionation(String destionation) {
        this.destionation = destionation;
    }

    public float getCout_liv() {
        return cout_liv;
    }

    public void setCout_liv(float cout_liv) {
        this.cout_liv = cout_liv;
    }
}
