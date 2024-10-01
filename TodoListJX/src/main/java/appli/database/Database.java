package appli.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String server="localhost";
    private String nomDeLaBase="javafx";
    private String utilisateur="root";
    private String mdp="";

    public String getUrl() {
        return "jdbc:mysql://"+server+"/"+nomDeLaBase+"?serverTimezone=UTC";
    }
    public Connection getConnection() {
        try {
            Connection cnx = DriverManager.getConnection(this.getUrl(), this.utilisateur, this.mdp);
            System.out.print("État de la connexion :");
            System.out.print(cnx.isClosed() ? "fermée" : "ouverte \r\n");
            return cnx;
        } catch (SQLException e) {
            System.out.print("Erreur lors de la tentative de connexion à la base de données");
            e.printStackTrace();
            return null;
        }
    }
}
