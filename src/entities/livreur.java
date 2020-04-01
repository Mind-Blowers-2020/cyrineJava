/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author asus
 */
public class livreur {
    
  
    private int id;

    private String nomL;

    private String prenomL;

   
    private String cin;

   
    private String email;

    
    private String numTel;

   
    private String adresse;

   
    private  boolean disponibilite;

   

private  int  nblivraison ;

    public livreur(String test, String test2, String string, String mailll, String string0, String ad, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public livreur() {
        
        System.out.println("livreuuuuurrrrrr!!!!!");
    }

    @Override
    public String toString() {
        return "livreur{" + "id=" + id + ", nomL=" + nomL + ", prenomL=" + prenomL + ", cin=" + cin + ", email=" + email + ", numTel=" + numTel + ", adresse=" + adresse + ", disponibilite=" + disponibilite + ", nblivraison=" + nblivraison + '}';
    }

    public livreur(int id, String nomL, String prenomL, String cin, String email, String numTel, String adresse, boolean disponibilite, int nblivraison) {
        this.id = id;
        this.nomL = nomL;
        this.prenomL = prenomL;
        this.cin = cin;
        this.email = email;
        this.numTel = numTel;
        this.adresse = adresse;
        this.disponibilite = disponibilite;
        this.nblivraison = nblivraison;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomL() {
        return nomL;
    }

    public void setNomL(String nomL) {
        this.nomL = nomL;
    }

    public String getPrenomL() {
        return prenomL;
    }

    public void setPrenomL(String prenomL) {
        this.prenomL = prenomL;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getNblivraison() {
        return nblivraison;
    }

    public void setNblivraison(int nblivraison) {
        this.nblivraison = nblivraison;
    }

}
