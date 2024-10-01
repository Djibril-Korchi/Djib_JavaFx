package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button Connection;

    @FXML
    private TextField email;

    @FXML
    private Label erreur;

    @FXML
    private Button inscription;

    @FXML
    private Button mdp;

    @FXML
    private PasswordField mdpButton;

    @FXML
    void onClickConnection(ActionEvent event) {
        if(this.email.getText().equals("") || this.mdp.getText().equals("")) {
            StartApplication.changeScene("page_accueil");
        }else {
            erreur.setText("Erreur");
        }


    }

    @FXML
    void onClickInscription(ActionEvent event) {
        StartApplication.changeScene("inscriptionView");
    }

    @FXML
    void onClickMdp(ActionEvent event) {
        StartApplication.changeScene("loginView");
    }
}
