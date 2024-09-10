package appli.accueil;

import appli.StartApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class InscriptionController extends Application {
    @Override
    public void start(Stage primaryStage) {

    }

    public void onClickInscription(ActionEvent actionEvent) {
    }

    public void onClickRetour(ActionEvent actionEvent) {
        StartApplication.changeScene("loginView");
    }
}
