package JavaFX.User.Admin.Item;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemEditSelectController {//Wesit onXXXButtonClicked-is magivrad unda meweros onXXXHyperlinkClicked mara mezareba gadarqmeva
    @FXML
    Hyperlink add;
    @FXML
    Hyperlink edit;
    @FXML
    Hyperlink remove;
    @FXML
    Hyperlink back;
    @FXML
    Hyperlink go;
    public void onAddButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) add.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/ItemAdd.fxml"));
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

        stage = (Stage) add.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/ItemEdit.fxml"));
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

        stage = (Stage) add.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/ItemRemove.fxml"));
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

        stage = (Stage) add.getScene().getWindow();
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

        stage = (Stage) add.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("../User/Fxml/UserEditSelect.fxml"));//insert UserEditSelect.fmxl path here...
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
