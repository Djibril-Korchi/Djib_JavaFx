package model.repository;

import appli.StartApplication;
import appli.database.Database;
import eu.hansolo.toolbox.observables.ObservableList;
import model.Entity.Liste;
import model.Entity.UtilisateurConnecte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListeRepository {

    public ObservableList<Liste> liste() throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM liste");
         ResultSet rs = ps.executeQuery();
        ObservableList<Liste> list = new ObservableList<>();
         while (rs.next()) {
             Liste liste = new Liste(rs.getInt("id_liste"), rs.getString("nom"));
             list.add(liste);
         }
         return list;
    }
    public void ajouter(String nom) throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("INSERT INTO liste(nom) VALUES (?)");
        ps.setString(1,nom);
        ps.executeUpdate();
        ps = db.getConnection().prepareStatement("SELECT * FROM liste WHERE nom = ?");
        ps.setString(1,nom);
        ResultSet resultat = ps.executeQuery();
        if (resultat.next()) {
            ps = db.getConnection().prepareStatement("INSERT INTO utilisateur_liste(ref_utilisateur,ref_liste) VALUES (?,?)");
            ps.setInt(1, UtilisateurConnecte.getInstance().getIdUser());
            ps.setInt(2,resultat.getInt(1));
            ps.executeUpdate();
            StartApplication.changeScene("accueil/AccueilView");
        }

    }
    public void supprimer(int id) throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("DELETE FROM liste WHERE id_liste = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        StartApplication.changeScene("accueil/AccueilView");
    }
    public void modifier(int id,String nom) throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("UPDATE liste SET nom = ? WHERE id_liste = ?");
        ps.setString(1,nom);
        ps.setInt(2,id);
        ps.executeUpdate();
        StartApplication.changeScene("accueil/AccueilView");
    }
}
