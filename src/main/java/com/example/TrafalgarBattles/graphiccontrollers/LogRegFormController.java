package com.example.trafalgarbattles.graphiccontrollers;

import applicationControllers.ApplicationControllerLogReg;
import bean.beanLog;
import bean.beanReg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import singleton.CurrentUser;

import java.io.IOException;
import java.sql.SQLException;

public class LogRegFormController {
    @FXML
    protected TextField usernameR;
    @FXML
    protected TextField email;
    @FXML
    protected PasswordField passwordR;
    @FXML
    protected TextField usernameL;
    @FXML
    protected TextField passwordL;
    @FXML
    protected Label formRes;
    private Stage stage;
    private Scene scene;
    private FXMLLoader root;
    private beanLog bL;

    private final visualizeScene visualizer = visualizeScene.getVisualizer(null);

    @FXML
    public void loginVer() throws SQLException {
        if(usernameL.getText().isEmpty() || passwordL.getText().isEmpty()){
            formRes.setText("Invalid password/username");
        } else {
            bL = new beanLog(usernameL.getText(), passwordL.getText());
            try{
                new ApplicationControllerLogReg(bL);
                passwordL.setDisable(true);
                usernameL.setDisable(true);
                email.setDisable(true);
                passwordR.setDisable(true);
                usernameR.setDisable(true);
                formRes.setText("Successfully logged in");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void signupVer(){
        if(usernameR.getText().isEmpty() || passwordR.getText().isEmpty() || email.getText().isEmpty() || !email.getText().contains("@")){
            formRes.setText("Invalid credentials, please try again");
        } else {
            beanReg bR = new beanReg(email.getText(), usernameR.getText(), passwordR.getText());
            try{
                new ApplicationControllerLogReg(bR);
                email.setDisable(true);
                passwordR.setDisable(true);
                usernameR.setDisable(true);
                formRes.setText("Successfully registered, please login");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void returnHome(MouseEvent event){
        visualizer.sceneVisualizer("Mainview.fxml", event);
    }
}
