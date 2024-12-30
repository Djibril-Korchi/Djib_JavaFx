module com.example.todolistjx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires spring.security.crypto;
    requires spring.security.core;
    requires mysql.connector.j;

    opens model.Entity to javafx.base;
    opens appli to javafx.fxml;
    exports appli;
    exports appli.accueil;
    opens appli.accueil to javafx.fxml;
    exports appli.liste;
    opens appli.liste to javafx.fxml;
    opens appli.type to javafx.fxml;
    exports appli.type;
    opens appli.tache to javafx.fxml;
    exports appli.tache;
}