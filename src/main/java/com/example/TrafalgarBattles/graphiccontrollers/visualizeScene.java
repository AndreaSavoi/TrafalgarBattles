package com.example.trafalgarbattles.graphiccontrollers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Objects;

public class visualizeScene {
    private static visualizeScene visualizer = null;

    private static Stage stage;

    private visualizeScene() {}

    public static visualizeScene getVisualizer(Stage newS) {
        if(visualizer==null) {
            visualizer = new visualizeScene();
            stage = newS;
        }
        return visualizer;
    }

    public void mainVisualizer(String sName) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(sName));
        Scene scene = new Scene(loader.load());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void sceneVisualizer(String sName, MouseEvent event) {
        try{
            Parent loader = FXMLLoader.load(Objects.requireNonNull(visualizeScene.class.getResource(sName)));
            Scene scene = new Scene(loader);
            if(event != null) {
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            }
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.exit(-1);
        }
    }
}
