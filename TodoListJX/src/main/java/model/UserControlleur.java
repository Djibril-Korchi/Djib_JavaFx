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
    public UserControlleur(String nom, String prenom, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
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

    public void inscription(String mdp_p) throws SQLException {
        Database database = new Database();
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        if (this.getNom().isEmpty()||this.getPrenom().isEmpty()||this.getEmail().isEmpty()||this.getMdp().isEmpty()||mdp_p.isEmpty()) {
            StartApplication.changeScene("inscriptionView");
        }
        if (this.mdp.equals(mdp_p)) {
            ResultSet resultat = utilisateurRepository.inscription(getEmail());
            System.out.println(mdp_p);
            if (resultat.next()) {
                StartApplication.changeScene("inscriptionView");
            }else {
                PreparedStatement requetePrepareInsert = database.getConnection().prepareStatement("INSERT INTO Utilisateur(nom,prenom,email,mot_de_passe) VALUES(?,?,?,?)");
                requetePrepareInsert.setString(1, getNom());
                requetePrepareInsert.setString(2, getPrenom());
                requetePrepareInsert.setString(3, getEmail());
                requetePrepareInsert.setString(4, mdp_p);
                requetePrepareInsert.executeUpdate();
                StartApplication.changeScene("loginView");
            }
        }else {
            StartApplication.changeScene("inscriptionView");
        }
    }
    public void connection(String email,String mdp) throws SQLException {
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        ResultSet data = utilisateurRepository.connection(email, mdp);
        if (data.next()) {
            setIdUser(data.getInt(1));
            setNom(data.getString(2));
            setPrenom(data.getString(3));
            setEmail(data.getString(4));
            setMdp(data.getString(5));
            StartApplication.changeScene("AccueilView");
        }else {
            StartApplication.changeScene("loginView");
        }
    }
}
