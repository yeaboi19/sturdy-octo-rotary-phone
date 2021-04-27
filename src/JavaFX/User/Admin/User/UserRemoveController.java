package JavaFX.User.Admin.User;

import FileIO.FileIO;
import User.User;
import User.UserRemove;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserRemoveController implements Initializable {
    @FXML
    TextField userName;
    @FXML
    TextField email;
    @FXML
    TextField password;
    @FXML
    Button remove;
    @FXML
    Button selScene;
    @FXML
    TableView tableView;
    @FXML
    TableColumn userNameColumn;
    @FXML
    TableColumn emailColumn;
    @FXML
    TableColumn passwordColumn;
    public void onRemoveButtonClicked(){
        UserRemove userRemove = new UserRemove();
        userRemove.remove(userName.getText(),email.getText(),password.getText());

        userNameColumn.setCellValueFactory(new PropertyValueFactory("uName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory("Email"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory("pass"));
        ObservableList<User> UserObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        UserObservableList.addAll(fileIO.getUserList());
        tableView.setItems(UserObservableList);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userNameColumn.setCellValueFactory(new PropertyValueFactory("uName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory("Email"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory("pass"));
        ObservableList<User> UserObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        UserObservableList.addAll(fileIO.getUserList());
        tableView.setItems(UserObservableList);
    }
}