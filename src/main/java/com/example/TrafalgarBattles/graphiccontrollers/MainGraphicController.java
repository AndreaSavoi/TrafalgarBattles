package com.example.trafalgarbattles.graphiccontrollers;

import applicationcontrollers.ApplicationControllerMainPage;
import bean.BeanCurrTourn;
import bean.BeanTournList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import singleton.CurrentUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainGraphicController implements Initializable{
    @FXML
    protected Label logReg;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    private String tabs = "\t\t\t\t";
    private final VisualizeScene visualizer = VisualizeScene.getVisualizer(null);
    @FXML
    protected VBox tournaments;
    @FXML
    public void show(MouseEvent event) {
        visualizer.sceneVisualizer("LogRegForm.fxml", event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(CurrentUser.getUser() != null) {
            logReg.setText(CurrentUser.getUser());
        }
        try {
            BeanTournList tL = new BeanTournList();
            new ApplicationControllerMainPage(tL);
            int count = tL.sno.size();

            for (int i = 0; i < count; i++) {
                Pane pane = new Pane();
                pane.setPrefSize(885, 150);
                Label label = new Label();
                String paneId = "Info" + tL.getSNO(i);
                pane.setId(paneId);
                pane.setOnMouseClicked(event -> {
                    int infoN = Integer.parseInt(((Pane) event.getSource()).getId().replace("Info", ""));
                    BeanCurrTourn tournament = BeanCurrTourn.getInstance();
                    tournament.setSno(infoN);
                    visualizer.sceneVisualizer("TournamentInfo.fxml", event);
                });
                HBox hbox = new HBox();
                hbox.setPrefHeight(125);
                hbox.setPrefWidth(875);
                hbox.setSpacing(50);
                Image img = new Image(tL.getLogos(i));
                ImageView logo = new ImageView(img);
                logo.setPreserveRatio(true);
                logo.setFitHeight(hbox.getPrefHeight());
                label.setText(tL.getName(i) + tabs + tL.getNS(i) + "/" + tL.getNP(i) + tabs + tL.getDate(i) + tabs);
                label.setFont(new Font("Century Gothic", 20));
                label.setStyle("-fx-font-weight: bold italic");
                label.setLayoutX(logo.getFitWidth() + 50);
                label.setLayoutY(hbox.getHeight() / 2);
                hbox.getChildren().addAll(logo, label);
                BorderStroke bS = new BorderStroke(
                        Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        BorderWidths.DEFAULT
                );
                Border border = new Border(bS);
                pane.setBorder(border);
                pane.getChildren().addAll(hbox);
                hbox.setAlignment(Pos.CENTER);
                hbox.setLayoutY((pane.getPrefHeight() - hbox.getPrefHeight()) / 2);
                hbox.setLayoutX(10 + (pane.getPrefWidth() - hbox.getPrefWidth()) / 2);
                tournaments.getChildren().add(pane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
