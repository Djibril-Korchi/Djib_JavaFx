package appli.liste;

import appli.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.repository.ListeRepository;

import java.sql.SQLException;

public class EditerListeControlleur {

    @FXML
    private Button modif;

    @FXML
    private TextField nom;

    @FXML
    private Button retour;

    private static int id;

    public EditerListeControlleur(int id) {
        EditerListeControlleur.id = id;
    }

    public static int getId() {
        return id;
    }

    @FXML
    void onClickModif(ActionEvent event) throws SQLException {
        ListeRepository lr = new ListeRepository();
        lr.modifier(EditerListeControlleur.id,this.nom.getText());
    }

    @FXML
    void onClickRetour(ActionEvent event) {

    }

}
