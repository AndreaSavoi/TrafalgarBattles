package com.example.TrafalgarBattles.GraphicControllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        ((MainGraphicController)fxmlLoader.getController()).init();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}