package model.repository;

import appli.StartApplication;
import appli.database.Database;
import model.UserControlleur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.*;

public class UtilisateurRepository {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public void inscription(String nom,String prenom, String email, String mdp, String mdp_p) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("SELECT * FROM Utilisateur WHERE email = ?");
        requetePrepare.setString(1, email);
        ResultSet resultat = requetePrepare.executeQuery();
        if (nom.isEmpty()||prenom.isEmpty()||email.isEmpty()||mdp.isEmpty()||mdp_p.isEmpty()) {
            StartApplication.changeScene("inscriptionView");
        }
        if (mdp.equals(mdp_p)) {

            if (resultat.next()) {
                StartApplication.changeScene("inscriptionView");
            }else {
                PreparedStatement requetePrepareInsert = db.getConnection().prepareStatement("INSERT INTO Utilisateur(nom,prenom,email,mot_de_passe) VALUES(?,?,?,?)");
                requetePrepareInsert.setString(1, nom);
                requetePrepareInsert.setString(2, prenom);
                requetePrepareInsert.setString(3, email);
                requetePrepareInsert.setString(4, encoder.encode(mdp));
                requetePrepareInsert.executeUpdate();
                StartApplication.changeScene("loginView");
            }
        }else {
            StartApplication.changeScene("inscriptionView");
        }
    }
    public void connection(String email) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("SELECT * FROM Utilisateur WHERE email = ?");
        requetePrepare.setString(1, email);
        ResultSet resultat = requetePrepare.executeQuery();
        if (resultat.next()) {
            UserControlleur userControlleur = new UserControlleur(resultat.getInt(1),resultat.getString(2),resultat.getString(3),resultat.getString(4),resultat.getString(5));
            StartApplication.changeScene("AccueilView");
        }else {
            StartApplication.changeScene("loginView");
        }
    }
}
