package com.example.TrafalgarBattles.GraphicControllers;

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
import java.util.ArrayList;
import java.util.List;

public class MainGraphicController {
    @FXML
    protected Label LogReg, login, signup, FormRes;
    @FXML
    protected Pane LRForm;
    @FXML
    protected TextField username;
    @FXML
    protected PasswordField password;
    @FXML
    protected VBox Tournaments;



    public void init() throws SQLException {
        List<String> tName = RetrieveInfoSpecific.retrieveNames();
        List<String> nPartecipants = RetrieveInfoSpecific.retrieveNPartecipants();
        List<String> nSubscribed = RetrieveInfoSpecific.retrieveNSubscribed();
        List<String> dates = RetrieveInfoSpecific.retrieveDates();
        int count = tName.size();
        System.out.println(count);

        for(int i = 0; i < count; i++) {
            Pane pane = new Pane();
            pane.setPrefSize(884, 150);
            Label label = new Label();
            String PaneId = "Info" + i;
            pane.setId(PaneId);
            pane.setOnMouseClicked(event -> {
                int infoN = Integer.parseInt(((Pane)event.getSource()).getId().replace("Info", ""));
                System.out.println(infoN);
            });
            label.layoutYProperty().bind(pane.heightProperty().subtract(label.heightProperty()).divide(2));
            label.layoutXProperty().bind(pane.widthProperty().subtract(label.widthProperty()).divide(2));
            label.setText(tName.get(i) + "\t\t\t\t" + nSubscribed.get(i) + "/" + nPartecipants.get(i) + "\t\t\t\t" + dates.get(i) + "\t\t\t\t"/* + PaneId*/);
            label.setFont(new Font("Century Gothic", 20));
            label.setStyle("-fx-font-weight: bold italic");
            pane.getChildren().add(label);
            Tournaments.getChildren().add(pane);
        }
    }
    @FXML
    public void Show(){
        System.out.println("Clicked!");
        LRForm.setVisible(!LRForm.isVisible());
    }

    @FXML
    public void LoginVer() throws SQLException {
        boolean ret = Login.loginVerify(username.getText(), password.getText());
        String usr = username.getText();
        username.setText("");
        password.setText("");
        if(ret) {
            FormRes.setText("Successfully Logged In.");
        } else {
            FormRes.setText("Couldn't log in.");
        }
        CurrentUser.getInstace(usr);
    }

    @FXML
    public void SignupVer() throws SQLException {
        boolean ret = Register.RegisterForm(username.getText(), password.getText());
        username.setText("");
        password.setText("");
        if(ret) {
            FormRes.setText("Successfully Registered.");
        } else {
            FormRes.setText("Couldn't register.");
        }
    }
}
