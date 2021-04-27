package JavaFX.User.Admin.User;

import User.UserLogin;
import User.UserReg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UserRegisterController {
    @FXML
    TextField userName;
    @FXML
    TextField email;
    @FXML
    TextField password;
    @FXML
    Button submit;
    @FXML
    Button selScene;
    public void onSubmitButtonClicked(){
        UserReg userReg = new UserReg();
        userReg.reg(userName.getText(),email.getText(),password.getText());
    }
    public void onSelSceneButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) selScene.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/UserEditSelect.fxml"));//insert UserEditSelect.fxml path here...
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
