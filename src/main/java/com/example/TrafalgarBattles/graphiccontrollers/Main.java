package com.example.trafalgarbattles.graphiccontrollers;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VisualizeScene visualizeScene =VisualizeScene.getVisualizer(stage);
        visualizeScene.mainVisualizer("MainView.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}