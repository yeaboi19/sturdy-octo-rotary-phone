package JavaFX.User;

import User.User;
import User.UserLogin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class LoginController {
    @FXML
    TextField userName;
    @FXML
    TextField email;
    @FXML
    TextField password;
    @FXML
    Button submit;
    @FXML
    Button regScene;
    @FXML
    Label error;
    public void onSubmitButtonPressed() {
        UserLogin userLogin = new UserLogin();
        User Temp = userLogin.login(userName.getText(), email.getText(), password.getText());
        System.out.println(Temp);
        /* TODO: when logged in display name on Select Scenes || DIFFICULTY:HARD */
        if (!userName.getText().isEmpty() && !email.getText().isEmpty() && !password.getText().isEmpty()) {//1111111
            if (!Temp.equals(Temp.empty()) && Temp.equals(Temp.Admin())) {
                Stage stage = new Stage();
                Parent parent;

                stage = (Stage) submit.getScene().getWindow();
                try {
                    parent = FXMLLoader.load(getClass().getResource("Admin/User/Fxml/UserEditSelect.fxml"));
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (!Temp.equals(Temp.empty())) {
                Stage stage = new Stage();
                Parent parent;

                stage = (Stage) submit.getScene().getWindow();
                try {
                    parent = FXMLLoader.load(getClass().getResource("Fxml/ItemSelect.fxml"));
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (error.getText().equalsIgnoreCase("incorrect input")) {
                    error.setText("incorrect input ...");
                } else {
                    error.setText("incorrect input");
                }
                /*DONE: Make an "Error Label" B)*/
            }
        } else {
            error.setText("TextFields cannot be empty");
        }
    }
    public void onRegSceneButtonPressed(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) regScene.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/Register.fxml"));
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
