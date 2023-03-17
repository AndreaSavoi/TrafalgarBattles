package com.example.trafalgarbattles.graphiccontrollers;

import applicationControllers.ApplicationControllerTournInfo;
import bean.beanCurrTourn;
import bean.tournamentList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import singleton.CurrentUser;
import singleton.DBconn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class tournamentPageController implements Initializable {
    @FXML
    protected Label logReg;
    @FXML
    protected Label tName;
    @FXML
    protected Label nSub;
    @FXML
    protected Label date;
    @FXML
    protected Label nPart;
    @FXML
    protected Label homeB;
    @FXML
    protected Button register;
    private final visualizeScene visualizer = visualizeScene.getVisualizer(null);
    FXMLLoader root;
    Stage stage;
    Scene scene;

    public void goLog(MouseEvent event) throws SQLException {
        visualizer.sceneVisualizer("LogRegForm.fxml", event);
    }

    public void goHome(MouseEvent event) throws SQLException {
        visualizer.sceneVisualizer("MainView.fxml", event);
    }

    public void sub(MouseEvent event) throws SQLException {
        if(CurrentUser.getUser() != null) {
            beanCurrTourn bCT = beanCurrTourn.getInstance();
            new ApplicationControllerTournInfo(CurrentUser.getUser(), bCT.gettName());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(CurrentUser.getUser() != null) {
            logReg.setText(CurrentUser.getUser());
            logReg.setOnMouseClicked(event -> {
                try {
                    goHome(event);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            register.setTextFill(Color.GREEN);
        } else {
            register.setTextFill(Color.RED);
        }
        beanCurrTourn bCT = beanCurrTourn.getInstance();
        try {
            new ApplicationControllerTournInfo(bCT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        tName.setText(bCT.gettName());
        date.setText(bCT.getDates());
        nSub.setText(bCT.getnSubscribed());
        nPart.setText(bCT.getnPartecipants());
    }
}
