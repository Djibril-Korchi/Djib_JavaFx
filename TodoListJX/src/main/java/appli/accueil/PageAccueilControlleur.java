package appli.accueil;
import appli.StartApplication;
import appli.liste.EditerListeControlleur;
import eu.hansolo.toolbox.observables.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Entity.Liste;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.repository.ListeRepository;
import javafx.scene.control.Alert;
import java.net.URL;
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

    private Button delete;

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
        String[][] colonnes = {
                {"Id liste", "idListe"},
                {"Nom", "nom"}
        };
        for (int i= 0; i < colonnes.length; i++) {
            TableColumn<Liste, String> maColone = new TableColumn<>(colonnes[i][0]);
            maColone.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
            tableauListe.getColumns().add(maColone);
        }
        ListeRepository liste = new ListeRepository();

        try {
            ObservableList<Liste> list = liste.liste();
            for (int i = 0 ; i < list.size(); i++) {
                tableauListe.getItems().add(list.get(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onListeSelection(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (event.getClickCount() == 2) {
                TablePosition cell = tableauListe.getSelectionModel().getSelectedCells().get(0);
                int indexLigne = cell.getRow();
                TableColumn colonne = cell.getTableColumn();
                int id = tableauListe.getItems().get(indexLigne).getIdListe();
                System.out.println(id);
                StartApplication.changeSceneInfo("liste/editerlisteView",new EditerListeControlleur(id));
            } else if (event.getClickCount() == 1) {
                TablePosition cell = tableauListe.getSelectionModel().getSelectedCells().get(0);
                int indexLigne = cell.getRow();
                TableColumn colonne = cell.getTableColumn();
                int id = tableauListe.getItems().get(indexLigne).getIdListe();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                ListeRepository liste = new ListeRepository();
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        try {
                            liste.supprimer(id);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        }
    }

}
