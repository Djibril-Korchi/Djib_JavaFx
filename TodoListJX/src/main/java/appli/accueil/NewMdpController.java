package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.repository.UtilisateurRepository;

import java.sql.SQLException;

public class NewMdpController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

    @FXML
    private Button valider;

    @FXML
    void OnclickValider(ActionEvent event) throws SQLException {
        UtilisateurRepository repo = new UtilisateurRepository();
        repo.NewMdp(this.email.getText(),this.mdp.getText());
    }

}
