package appli.tache;

import appli.accueil.PageAccueilControlleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.repository.TacheRepository;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AjouterControlleur implements Initializable {

    @FXML
    private TextField nom;

    @FXML
    private Button reset;

    @FXML
    private ComboBox<String> type;

    @FXML
    private Button valider;

    private int id;

    public AjouterControlleur(int id) {
        this.id = id;
    }

    @FXML
    void OnClickReset(ActionEvent event) {

    }

    @FXML
    void onClickValider(ActionEvent event) throws SQLException {
        TacheRepository tacheRepository = new TacheRepository();
        tacheRepository.ajouter(this.nom.getText(),this.type.getValue(),this.id);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TacheRepository tacheRepository = new TacheRepository();
        try {
            ResultSet newtype = tacheRepository.listeType();
            while (newtype.next()) {
                this.type.getItems().add(newtype.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
