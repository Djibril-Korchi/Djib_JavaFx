package appli.type;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.repository.ListeRepository;
import model.repository.TypeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditerTypeControlleur implements Initializable {

    @FXML
    private TextField nom;

    @FXML
    private TextField code;

    @FXML
    private Button retour;

    private int id;

    private String nomtype;

    private String codec;

    public EditerTypeControlleur(int id, String nom,String codec) {
        this.id = id;
        this.nomtype = nom;
        this.codec = codec;
    }

    public int getId() {
        return id;
    }

    @FXML
    void onClickModif(ActionEvent event) throws SQLException {
        TypeRepository type = new TypeRepository();
        type.modifier(this.id,this.nom.getText(),this.code.getText());
    }

    @FXML
    void onClickRetour(ActionEvent event) {
        StartApplication.changeScene("type/type");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.nom.setText(nomtype);
        this.code.setText(codec);
    }
}
