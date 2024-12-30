package model.repository;

import appli.StartApplication;
import appli.database.Database;
import eu.hansolo.toolbox.observables.ObservableList;
import model.Entity.Liste;
import model.Entity.Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeRepository {
    public void NewType(String nom, String code_couleur) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("INSERT INTO type(nom,code_couleur) VALUES (?,?)");
        requetePrepare.setString(1, nom);
        requetePrepare.setString(2, code_couleur);
        requetePrepare.executeUpdate();

    }

    public ArrayList<Type> type() throws SQLException {
        ArrayList<Type> types = new ArrayList<>();
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM type");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Type type = new Type();
            type.setIdType(rs.getInt("id_type"));
            type.setNom(rs.getString("nom"));
            type.setCode_coulleur(rs.getString("code_couleur"));
            types.add(type);
        }
        return types;
    }
    public void modifier(int id,String nom, String cc) throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("UPDATE liste SET nom = ? and code_couleur = ? WHERE id_liste = ?");
        ps.setString(1,nom);
        ps.setString(2,cc);
        ps.setInt(3,id);
        ps.executeUpdate();
        StartApplication.changeScene("accueil/AccueilView");
    }

    public void supprimer(int id) throws SQLException {
        Database db = new Database();
        PreparedStatement ps = db.getConnection().prepareStatement("DELETE FROM type WHERE id_type = ?");
        ps.setInt(1,id);
        ps.executeUpdate();
        StartApplication.changeScene("accueil/AccueilView");
    }
}
