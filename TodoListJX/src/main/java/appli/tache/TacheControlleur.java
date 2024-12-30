package appli.tache;

import appli.StartApplication;
import appli.type.EditerTypeControlleur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Entity.Tache;
import model.Entity.Type;
import model.Entity.UtilisateurConnecte;
import model.repository.TacheRepository;
import model.repository.TypeRepository;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TacheControlleur implements Initializable {

    @FXML
    private Button ajouter;

    @FXML
    private Button retour;

    @FXML
    private Button suprimer;

    @FXML
    private TableView<Tache> tableauTache;

    private int id;

    private int idListe;

    public TacheControlleur(int idListe) {
        this.idListe = idListe;
    }

    public int getIdListe() {
        return idListe;
    }

    public void setIdListe(int idListe) {
        this.idListe = idListe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @FXML
    void OnClickAjouter(ActionEvent event) {
        StartApplication.changeSceneInfo("tache/Ajouter", new AjouterControlleur(idListe));
    }

    @FXML
    void OnClickSuprimer(ActionEvent event) {

    }

    @FXML
    void onClicRetour(ActionEvent event) {

    }

    @FXML
    void onTacheSelection(MouseEvent event) throws SQLException {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (event.getClickCount() == 2) {
                TablePosition cell = tableauTache.getSelectionModel().getSelectedCells().get(0);
                int indexLigne = cell.getRow();
                int id = tableauTache.getItems().get(indexLigne).getIdTache();
                String nom = tableauTache.getItems().get(indexLigne).getNom();
                int etat = tableauTache.getItems().get(indexLigne).getEtat();
                TacheRepository tr = new TacheRepository();
                if (tr.verif(getIdListe(), UtilisateurConnecte.getInstance().getIdUser())){
                    StartApplication.changeSceneInfo("liste/editerlisteView",new EditerTacheControlleur(id,nom,etat));
                }
            } else if (event.getClickCount() == 1) {
                TablePosition cell = tableauTache.getSelectionModel().getSelectedCells().get(0);
                int indexLigne = cell.getRow();
                int id = tableauTache.getItems().get(indexLigne).getIdTache();
                this.setId(id);
                this.suprimer.setVisible(true);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"Id type", "idType"},
                {"Nom", "nom"},
                {"Etat", "etat"},
        };
        this.suprimer.setVisible(false);
        for (int i= 0; i < colonnes.length; i++) {
            TableColumn<Tache, String> maColone = new TableColumn<>(colonnes[i][0]);
            maColone.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
            tableauTache.getColumns().add(maColone);
        }

        TacheRepository tache = new TacheRepository();
        System.out.println(2);
        try {
            System.out.println(0);
            ArrayList<Tache> taches = tache.tache(this.getId());
            for (int i = 0 ; i < taches.size(); i++) {
                System.out.println(9);
                tableauTache.getItems().add(taches.get(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
