package appli.accueil;

import appli.StartApplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.repository.UtilisateurRepository;

import java.sql.SQLException;

public class InscriptionController {

    @FXML
    private TextField email;

    @FXML
    private Button inscription;

    @FXML
    private PasswordField mdp;

    @FXML
    private PasswordField mdp_c;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button retour;

    @FXML
    void onClickInscription(ActionEvent event) throws SQLException {
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        utilisateurRepository.inscription(this.nom.getText(),this.prenom.getText(),this.email.getText(),this.mdp.getText(),this.mdp_c.getText());
    }

    @FXML
    void onClickRetour(ActionEvent event) {
        StartApplication.changeScene("accueil/loginView");
    }

}
