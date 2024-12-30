package model.repository;

import appli.StartApplication;
import appli.database.Database;
import model.Entity.Tache;
import model.Entity.Type;
import model.Entity.UtilisateurConnecte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<Tache> tache(int id) throws SQLException {
        ArrayList<Tache> types = new ArrayList<>();
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM tache WHERE ref_liste = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(1);
            Tache tache = new Tache();
            tache.setIdTache(rs.getInt("id_tache"));
            tache.setNom(rs.getString("nom"));
            tache.setEtat(rs.getInt("etat"));
            tache.setRef_type(rs.getInt("ref_type"));
            types.add(tache);
        }
        return types;
    }
    public boolean verif(int idListe, int id) throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM utilisateur_liste WHERE ref_liste = ? and ref_utilisateur = ?");
        ps.setInt(1, idListe);
        ps.setInt(2, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }else {
            return false;
        }
    }
}
