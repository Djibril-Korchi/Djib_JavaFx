package model.repository;

import appli.StartApplication;
import appli.database.Database;
import eu.hansolo.toolbox.observables.ObservableList;
import model.Entity.Liste;

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
        StartApplication.changeScene("accueil/AccueilView");
    }
}
