package appli.type;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.repository.TypeRepository;

import java.sql.SQLException;

public class AjouterControlleur {

    @FXML
    private TextField code;

    @FXML
    private TextField nom;

    @FXML
    private Button reset;

    @FXML
    private Button valider;

    @FXML
    void OnClickReset(ActionEvent event) {
        StartApplication.changeScene("type/Ajouter");
    }

    @FXML
    void onClickValider(ActionEvent event) throws SQLException {
        TypeRepository typeRepository = new TypeRepository();
        if (this.code.getText().length()<8) {
            typeRepository.NewType(this.nom.getText(),this.code.getText());
            StartApplication.changeScene("type/type");

        }else {
            StartApplication.changeScene("type/Ajouter");
        }
    }

}
