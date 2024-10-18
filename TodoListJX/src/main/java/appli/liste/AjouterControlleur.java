package appli.liste;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.repository.ListeRepository;

import java.sql.SQLException;

public class AjouterControlleur {

    @FXML
    private TextField nom;

    @FXML
    private Button reset;

    @FXML
    private Button valider;

    @FXML
    void OnClickReset(ActionEvent event) {
        StartApplication.changeScene("../liste/Ajouter");
    }

    @FXML
    void onClickValider(ActionEvent event) throws SQLException {
        ListeRepository liste = new ListeRepository();
        liste.ajouter(this.nom.getText());
    }

}
