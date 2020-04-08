/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author asus
 */
public class reclamation {
    int id ; 
    String sujet ; 
    Date date ; 
    String etat ; 
    String code_liv ; 

    public reclamation() {
    }

    public reclamation(String sujet, Date date, String etat, String code_liv) {
        this.sujet = sujet;
        this.date = date;
        this.etat = etat;
        this.code_liv = code_liv;
    }

    public reclamation(int id, String sujet, Date date, String etat, String code_liv) {
        this.id = id;
        this.sujet = sujet;
        this.date = date;
        this.etat = etat;
        this.code_liv = code_liv;
    }

    @Override
    public String toString() {
        return "reclamation{" + "id=" + id + ", sujet=" + sujet + ", date=" + date + ", etat=" + etat + ", code_liv=" + code_liv + '}';
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCode_liv() {
        return code_liv;
    }

    public void setCode_liv(String code_liv) {
        this.code_liv = code_liv;
    }
    
    
}
