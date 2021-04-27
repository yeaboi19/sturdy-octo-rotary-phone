package JavaFX.User.Admin.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class UserEditSelectController {
    @FXML
    Button add;
    @FXML
    Button edit;
    @FXML
    Button remove;
    @FXML
    Button back;
    @FXML
    Button go;

    public void onAddButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) add.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/UserAdd.fxml"));
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onEditButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) edit.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/UserEdit.fxml"));
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onRemoveButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) remove.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/UserRemove.fxml"));
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onBackButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) back.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("../../Fxml/Login.fxml"));//insert UserLogin.fmxl path here...
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onGoButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) go.getScene().getWindow();
        try {
            parent = FXMLLoader.load( getClass().getResource("../Item/Fxml/ItemEditSelect.fxml"));//insert ItemEditSelect.fxml path here...
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
