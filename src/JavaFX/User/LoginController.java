package JavaFX.User;

import User.User;
import User.UserLogin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    public void onSubmitButtonPressed(){
        UserLogin userLogin = new UserLogin();
        User Temp =userLogin.login(userName.getText(),email.getText(),password.getText());
        System.out.println(Temp);
        /* TODO: when logged in display name on Select Scenes || DIFFICULTY:HARD */
        if(!Temp.equals(Temp.empty()) && Temp.equals(Temp.Admin())){
            Stage stage =new Stage();
            Parent parent;

            stage = (Stage) submit.getScene().getWindow();
            try {
                parent = FXMLLoader.load(getClass().getResource("Admin/User/Fxml/UserEditSelect.fxml"));
                Scene scene =new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(!Temp.equals(Temp.empty())){
            Stage stage =new Stage();
            Parent parent;

            stage = (Stage) submit.getScene().getWindow();
            try {
                parent = FXMLLoader.load(getClass().getResource("Fxml/ItemSelect.fxml"));
                Scene scene =new Scene(parent);
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }/*TODO: Make an "Error Label"*/
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
