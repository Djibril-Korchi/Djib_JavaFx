package appli.accueil;
import appli.StartApplication;
import appli.database.Database;
import eu.hansolo.toolbox.observables.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Entity.Liste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.repository.ListeRepository;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PageAccueilControlleur implements Initializable {
    @FXML
    private TableView<Liste> tableauListe;
    @FXML
    private Button ajouter;

    @FXML
    private Button deconnexion;

    @FXML
    private Button type;

    @FXML
    void OnClickType(ActionEvent event) {

    }

    @FXML
    void onClicDeconnexion(ActionEvent event) {
        StartApplication.changeScene("accueil/loginView");
    }

    @FXML
    void onClickAjouter(ActionEvent event) {
        StartApplication.changeScene("liste/Ajouter");
    }

    public void initialize(URL url, ResourceBundle rb) {
        String[][] colonnes ={
                {"Id liste","idListe"},
                {"Nom","nom"}
        };
        for (int i= 0; i < colonnes.length; i++) {
            TableColumn<Liste, String> maColone = new TableColumn<>(colonnes[i][0]);
            maColone.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
            tableauListe.getColumns().add(maColone);
        }
        ListeRepository liste = new ListeRepository();
        try {
            ObservableList<Liste> list =liste.liste();

            for (int i = 0 ; i < list.size(); i++) {
                tableauListe.getItems().add(list.get(i));
            }
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
}
