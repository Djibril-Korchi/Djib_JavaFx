package model.repository;

import appli.StartApplication;
import appli.database.Database;
import model.Entity.UtilisateurConnecte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TacheRepository {
    public ResultSet listeType() throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM type");
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public void ajouter(String nom, String type, int liste) throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM type WHERE nom = ?");
        ps.setString(1,type);
        ResultSet resultat1 = ps.executeQuery();
        if (resultat1.next()) {
            ps = db.getConnection().prepareStatement("INSERT INTO tache(nom,etat,ref_liste,ref_type) VALUES (?,?,?,?)");
            ps.setString(1, nom);
            ps.setInt(2, 0);
            ps.setInt(3,liste);
            ps.setInt(4,resultat1.getInt(1));
            ps.executeUpdate();
            StartApplication.changeScene("accueil/AccueilView");
        }
    }
}
