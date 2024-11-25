package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.repository.UtilisateurRepository;

import java.sql.SQLException;

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
    private PasswordField mdp;

    @FXML
    private Button mdpButton;

    @FXML
    void onClickConnection(ActionEvent event) throws SQLException {
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        utilisateurRepository.connection(this.email.getText(),this.mdp.getText());
    }

    @FXML
    void onClickInscription(ActionEvent event) {
        StartApplication.changeScene("accueil/inscriptionView");
    }

    @FXML
    void onClickMdp(ActionEvent event) {
        StartApplication.changeScene("accueil/loginView");
    }
}
