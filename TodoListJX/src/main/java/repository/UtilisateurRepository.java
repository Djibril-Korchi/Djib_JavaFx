package repository;

import appli.database.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilisateurRepository {
    public void Inscription(String nom,String prenom,String email,String mdp) throws SQLException {
        Database db = new Database();
        Connection maConnection = DriverManager.getConnection(db.getUrl());
        PreparedStatement requetePrepare = maConnection.prepareStatement("SELECT * FROM Utilisateur WHERE email = ?");
        PreparedStatement requetePrepareInsert =maConnection.prepareStatement("INSERT INTO Utilisateur (nom,prenom,email,mdp,actif,age) VALUES(?,?,?,?,?,?)");
        requetePrepareInsert.setString(1,nom);
        requetePrepareInsert.setString(2,prenom);
        requetePrepareInsert.setString(3,email);
        requetePrepareInsert.setString(4,mdp);
        requetePrepareInsert.setBoolean(5,true);// 6 - age => intrequetePrepareInsert.setInt(6,59);//Execution de la requêterequetePrepareInsert.executeUpdate();//requête permettant d'extraire des données de la base de donnéePreparedStatement requPrepareSelect = maConnection.prepareStatement("SELECT * FROM Utilisateur WHERE email = ?");// 1 - email => StringrequPrepareSelect.setString(1,"f.dubosc@test.fr");//Execution de la requêteResultSet resultatsRequetes = requPrepareSelect.executeQuery();
    }
}
