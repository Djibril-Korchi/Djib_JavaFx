package model;

import appli.StartApplication;
import appli.database.Database;
import model.repository.UtilisateurRepository;

import java.sql.*;

public class UserControlleur {
    private int idUser;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    public UserControlleur(int anInt, String string, String string1, String string2, String string3) {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public UserControlleur() {
    }

    @Override
    public String toString() {
        return "UserControlleur{" +
                "idUser=" + idUser +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
