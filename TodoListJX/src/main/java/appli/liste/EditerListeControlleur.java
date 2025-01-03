package appli.liste;

import appli.StartApplication;
import appli.database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.repository.ListeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditerListeControlleur implements Initializable {

    @FXML
    private Button modif;

    @FXML
    private TextField nom;

    @FXML
    private Button retour;

    private int id;

    private String nomtype;

    public EditerListeControlleur(int id, String nom) {
        this.id = id;
        this.nomtype = nom;
    }

    public int getId() {
        return id;
    }

    @FXML
    void onClickModif(ActionEvent event) throws SQLException {
        ListeRepository lr = new ListeRepository();
        lr.modifier(this.id,this.nom.getText());
    }

    @FXML
    void onClickRetour(ActionEvent event) {
        StartApplication.changeScene("accueil/AcceuilView");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nom.setText(nomtype);
    }
}
