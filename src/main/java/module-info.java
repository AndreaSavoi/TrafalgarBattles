module com.example.trafalgarbattles {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.j;

    opens com.example.TrafalgarBattles.graphiccontrollers to javafx.fxml;
    exports com.example.TrafalgarBattles.graphiccontrollers;
}