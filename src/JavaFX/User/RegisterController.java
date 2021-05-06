package JavaFX.User;

import User.User;
import User.UserLogin;
import User.UserReg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    @FXML
    TextField userName;
    @FXML
    TextField email;
    @FXML
    TextField password;
    @FXML
    Button submit;
    @FXML
    Button logScene;
    @FXML
    Label error;
    public void onSubmitButtonPressed(){
        UserReg userReg = new UserReg();
        int errCode = userReg.reg(userName.getText(),email.getText(), password.getText());

        if(errCode==1) {
            UserLogin userLogin = new UserLogin();
            User Temp =userLogin.login(userName.getText(),email.getText(),password.getText());

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
                }
            } else {
                error.setText("TextFields cannot be empty");
            }
        }else if(errCode==0){
            error.setText("This user is already registered");
        }
    }
    public void onLogSceneButtonPressed(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) logScene.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/Login.fxml"));
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
