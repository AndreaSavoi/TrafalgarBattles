package com.example.TrafalgarBattles.graphicControllers;

import loginregister.Login;
import singleton.CurrentUser;
import loginregister.Register;
import tournaments.RetrieveInfoSpecific;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.sql.SQLException;
import java.util.List;

public class MainGraphicController {
    @FXML
    protected Label logReg;
    @FXML
    protected Label login;
    @FXML
    protected Label signup;
    @FXML
    protected Label formRes;
    @FXML
    protected Pane lrForm;
    @FXML
    protected TextField username;
    @FXML
    protected PasswordField password;
    @FXML
    protected VBox tournaments;



    public void init() throws SQLException {
        List<String> tName = RetrieveInfoSpecific.retrieveNames();
        List<String> nPartecipants = RetrieveInfoSpecific.retrieveNPartecipants();
        List<String> nSubscribed = RetrieveInfoSpecific.retrieveNSubscribed();
        List<String> dates = RetrieveInfoSpecific.retrieveDates();
        int count = tName.size();

        for(int i = 0; i < count; i++) {
            Pane pane = new Pane();
            pane.setPrefSize(884, 150);
            Label label = new Label();
            String paneId = "Info" + i;
            pane.setId(paneId);
            pane.setOnMouseClicked(event -> {
                int infoN = Integer.parseInt(((Pane)event.getSource()).getId().replace("Info", ""));
            });
            label.layoutYProperty().bind(pane.heightProperty().subtract(label.heightProperty()).divide(2));
            label.layoutXProperty().bind(pane.widthProperty().subtract(label.widthProperty()).divide(2));
            label.setText(tName.get(i) + "\t\t\t\t" + nSubscribed.get(i) + "/" + nPartecipants.get(i) + "\t\t\t\t" + dates.get(i) + "\t\t\t\t"/* + PaneId*/);
            label.setFont(new Font("Century Gothic", 20));
            label.setStyle("-fx-font-weight: bold italic");
            pane.getChildren().add(label);
            tournaments.getChildren().add(pane);
        }
    }
    @FXML
    public void show(){
        lrForm.setVisible(!lrForm.isVisible());
    }

    @FXML
    public void loginVer() throws SQLException {
        boolean ret = Login.loginVerify(username.getText(), password.getText());
        String usr = username.getText();
        username.setText("");
        password.setText("");
        if(ret) {
            formRes.setText("Successfully Logged In.");
        } else {
            formRes.setText("Couldn't log in.");
        }
        CurrentUser.getInstace(usr);
    }

    @FXML
    public void signupVer() throws SQLException {
        boolean ret = Register.registerForm(username.getText(), password.getText());
        username.setText("");
        password.setText("");
        if(ret) {
            formRes.setText("Successfully Registered.");
        } else {
            formRes.setText("Couldn't register.");
        }
    }
}
