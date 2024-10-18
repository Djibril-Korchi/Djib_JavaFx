package model.repository;

import appli.StartApplication;
import appli.database.Database;
import model.Entity.User;
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
            StartApplication.changeScene("accueil/inscriptionView");
        }
        if (mdp.equals(mdp_p)) {

            if (resultat.next()) {
                StartApplication.changeScene("accueil/inscriptionView");
            }else {
                PreparedStatement requetePrepareInsert = db.getConnection().prepareStatement("INSERT INTO Utilisateur(nom,prenom,email,mot_de_passe) VALUES(?,?,?,?)");
                requetePrepareInsert.setString(1, nom);
                requetePrepareInsert.setString(2, prenom);
                requetePrepareInsert.setString(3, email);
                requetePrepareInsert.setString(4, encoder.encode(mdp));
                requetePrepareInsert.executeUpdate();
                StartApplication.changeScene("accueil/loginView");
            }
        }else {
            StartApplication.changeScene("accueil/inscriptionView");
        }
    }
    public void connection(String email) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("SELECT * FROM Utilisateur WHERE email = ?");
        requetePrepare.setString(1, email);
        ResultSet resultat = requetePrepare.executeQuery();
        if (resultat.next()) {
            System.out.println("test");
            User userControlleur = new User(resultat.getInt(1),resultat.getString(2),resultat.getString(3),resultat.getString(4),resultat.getString(5));
            StartApplication.changeScene("accueil/AccueilView");
        }else {
            StartApplication.changeScene("accueil/loginView");
        }
    }
}
