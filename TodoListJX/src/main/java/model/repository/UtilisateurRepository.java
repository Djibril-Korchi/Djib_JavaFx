package model.repository;

import appli.database.Database;

import java.sql.*;

public class UtilisateurRepository {
    public ResultSet inscription(String email) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("SELECT * FROM Utilisateur WHERE email = ?");
        requetePrepare.setString(1, email);
        ResultSet resultat = requetePrepare.executeQuery();
        return resultat;
    }
    public ResultSet connection(String email,String mdp) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("SELECT * FROM Utilisateur WHERE email = ? and mot_de_passe = ?");
        requetePrepare.setString(1, email);
        requetePrepare.setString(2, mdp);
        ResultSet resultat = requetePrepare.executeQuery();
        return resultat;
    }
}
