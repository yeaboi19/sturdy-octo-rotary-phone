package JavaFX.User.Admin.User;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class UserEditSelectController {
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

    public void onAddHyperlinkClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) add.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/UserRegister.fxml"));
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onEditHyperlinkClicked(){
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
    public void onRemoveHyperlinkClicked(){
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
    public void onBackHyperlinkClicked(){
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
    public void onGoHyperlinkClicked(){
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
