package JavaFX.User.Admin.User;

import User.UserLogin;
import User.UserReg;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
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
    @FXML
    Label error;
    public void onSubmitButtonClicked(){
        if(userName.getText().isEmpty() && email.getText().isEmpty() && password.getText().isEmpty()){
            error.setText("please fill all the textFields");
        }else{
            UserReg userReg = new UserReg();
            int errCode=userReg.reg(userName.getText(),email.getText(),password.getText());
            if(errCode==1){
                error.setText("successfully registered "+userName.getText());
                userName.setText("");
                email.setText("");
                password.setText("");
            }else if(errCode==0){
                error.setText("this user is already registered");
            }
        }
    }
    public void onSelSceneButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) selScene.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/UserEditSelect.fxml"));
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
