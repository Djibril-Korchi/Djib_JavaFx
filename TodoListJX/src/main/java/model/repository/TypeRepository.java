package model.repository;

import appli.StartApplication;
import appli.database.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TypeRepository {
    public void NewType(String nom, String code_couleur) throws SQLException {
        Database db = new Database();
        PreparedStatement requetePrepare = db.getConnection().prepareStatement("INSERT INTO type(nom,code_couleur) VALUES (?,?)");
        requetePrepare.setString(1, nom);
        requetePrepare.setString(2, code_couleur);
        requetePrepare.executeUpdate();

    }
}
