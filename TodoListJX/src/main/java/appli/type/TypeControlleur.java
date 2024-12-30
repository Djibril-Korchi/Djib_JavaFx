package appli.type;

import appli.StartApplication;
import appli.accueil.PageAccueilControlleur;
import appli.liste.EditerListeControlleur;
import eu.hansolo.toolbox.observables.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Entity.Liste;
import model.Entity.Type;
import model.repository.ListeRepository;
import model.repository.TypeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TypeControlleur implements Initializable {

    @FXML
    private Button retour;

    @FXML
    private Button suprimer;

    @FXML
    private Button ajouter;

    @FXML
    private TableView<Type> tableauType;

    @FXML
    private Button modifier;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @FXML
    void OnClickModifier(ActionEvent event) {

    }

    @FXML
    void onClicRetour(ActionEvent event) {

    }

    @FXML
    void onListeSelection(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"Id type", "idType"},
                {"Nom", "nom"},
                {"Code Couleur", "code_coulleur"}
        };
        this.suprimer.setVisible(false);
        for (int i= 0; i < colonnes.length; i++) {
            TableColumn<Type, String> maColone = new TableColumn<>(colonnes[i][0]);
            maColone.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
            tableauType.getColumns().add(maColone);
        }

        TypeRepository type = new TypeRepository();

        try {
            ArrayList<Type> types = type.type();
            for (int i = 0 ; i < types.size(); i++) {
                tableauType.getItems().add(types.get(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onTypeSelection(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (event.getClickCount() == 2) {
                TablePosition cell = tableauType.getSelectionModel().getSelectedCells().get(0);
                int indexLigne = cell.getRow();
                int id = tableauType.getItems().get(indexLigne).getIdType();
                String nom = tableauType.getItems().get(indexLigne).getNom();
                String code = tableauType.getItems().get(indexLigne).getCode_coulleur();
                StartApplication.changeSceneInfo("liste/editerlisteView",new EditerTypeControlleur(id,nom,code));
            } else if (event.getClickCount() == 1) {
                TablePosition cell = tableauType.getSelectionModel().getSelectedCells().get(0);
                int indexLigne = cell.getRow();
                int id = tableauType.getItems().get(indexLigne).getIdType();
                this.setId(id);
                this.suprimer.setVisible(true);
            }
        }
    }

    public void OnClickAjouter(ActionEvent actionEvent) {
        StartApplication.changeScene("type/Ajouter");
    }

    public void OnClickSuprimer(ActionEvent actionEvent) {
        System.out.println(getId());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        TypeRepository type = new TypeRepository();
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    type.supprimer(PageAccueilControlleur.getId());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
