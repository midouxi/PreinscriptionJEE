/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


public class EtudiantBean {
    private int n_inscription;
    private String  cne;
    private String nom;
    private String prenom;
    private String serie_bac;
    private String moy_EN;
    private String filiere;
    private String etablissement;
    private String  date;

    public EtudiantBean(int n_inscription,String cne,String nom, String prenom, String serie_bac, String moy_EN, String filiere, String etablissement, String date) {
        this.n_inscription = n_inscription;
        this.nom = nom;
        this.prenom = prenom;
        this.serie_bac = serie_bac;
        this.moy_EN = moy_EN;
        this.filiere = filiere;
        this.etablissement = etablissement;
        this.date = date;
        this.cne = cne;
    }
    

    public EtudiantBean() {
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }
    

    public String getSerie_bac() {
        return serie_bac;
    }

    public String getMoy_EN() {
        return moy_EN;
    }

    public String getFiliere() {
        return filiere;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public String getDate() {
        return date;
    }

    public void setSerie_bac(String serie_bac) {
        this.serie_bac = serie_bac;
    }

    public void setMoy_EN(String moy_EN) {
        this.moy_EN = moy_EN;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public void setDate(String date) {
        this.date = date;
    }
                

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getN_inscription() {
        return n_inscription;
    }

    public void setN_inscription(int n_inscription) {
        this.n_inscription = n_inscription;
    }
    
}
