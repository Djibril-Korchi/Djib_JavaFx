package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    private static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("accueil/loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setTitle("Hello!");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void changeScene(String nomDuFichier) {
        mainStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(nomDuFichier + ".fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
            mainStage.setTitle("");
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void changeSceneInfo(String nomDuFichierFxml, Object controller) {
        mainStage.close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(nomDuFichierFxml + ".fxml"));
            fxmlLoader.setController(controller);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    public static void main(String[] args) {
        launch();
    }
}