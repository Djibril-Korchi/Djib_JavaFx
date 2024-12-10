package model.repository;

import appli.StartApplication;
import appli.accueil.PageAccueilControlleur;
import appli.database.Database;
import model.Entity.User;
import model.Entity.UtilisateurConnecte;
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
    public void connection(String email, String mdp) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("SELECT * FROM Utilisateur WHERE email = ? ");
        requetePrepare.setString(1, email);
        ResultSet resultat = requetePrepare.executeQuery();
        if (resultat.next()) {
            // Vérification du mot de passe
            if (encoder.matches(mdp, resultat.getString("mot_de_passe"))) {
                // Création de l'utilisateur
                User userControlleur = new User(
                        resultat.getInt(1),
                        resultat.getString(2),
                        resultat.getString(3),
                        resultat.getString(4),
                        resultat.getString(5)
                );

                // Initialisation de l'utilisateur connecté
                if (UtilisateurConnecte.initInstance(userControlleur)) {
                    // Changement de scène vers l'accueil
                    StartApplication.changeScene("accueil/AccueilView");
                } else {
                    System.out.println("Un utilisateur est déjà connecté !");
                    StartApplication.changeScene("accueil/loginView");
                }
            } else {
                System.out.println("Mot de passe incorrect !");
                StartApplication.changeScene("accueil/loginView");
            }
        } else {
            System.out.println("Aucun utilisateur trouvé avec cet email !");
            StartApplication.changeScene("accueil/loginView");
        }
    }

    public void NewMdp(String email, String mdp) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("SELECT * FROM Utilisateur WHERE email = ? ");
        requetePrepare.setString(1, email);
        ResultSet resultat = requetePrepare.executeQuery();
        if (resultat.next()) {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement("UPDATE utilisateur SET mot_de_passe = ? WHERE email = ?");
            preparedStatement.setString(1, encoder.encode(mdp));
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
            StartApplication.changeScene("accueil/loginView");
        }else {
            StartApplication.changeScene("accueil/NewMdp");
        }
    }
}
