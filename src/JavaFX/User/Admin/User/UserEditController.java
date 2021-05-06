package JavaFX.User.Admin.User;

import FileIO.FileIO;
import Items.Item;
import User.User;
import User.UserEdit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UserEditController implements Initializable {
    @FXML
    TextField ogUsername;
    @FXML
    TextField ogEmail;
    @FXML
    TextField ogPassword;
    @FXML
    TextField edUsername;
    @FXML
    TextField edEmail;
    @FXML
    TextField edPassword;
    @FXML
    TableView tableView;
    @FXML
    TableColumn userNameColumn;
    @FXML
    TableColumn emailColumn;
    @FXML
    TableColumn passwordColumn;
    @FXML
    Button submit;
    @FXML
    Button selScene;
    @FXML
    Label error;
    public void onSubmitButtonClicked(){
        UserEdit userEdit = new UserEdit();
        int errCode = userEdit.Edit(ogUsername.getText(),ogEmail.getText(),ogPassword.getText(),edUsername.getText(),edEmail.getText(),edPassword.getText());
        if(ogUsername.getText().isEmpty() && ogEmail.getText().isEmpty() && ogPassword.getText().isEmpty() && edUsername.getText().isEmpty() && edEmail.getText().isEmpty() && edPassword.getText().isEmpty()) {
            error.setText("please fill all the textFields");
        }else{
            if (errCode == 1) {
                userNameColumn.setCellValueFactory(new PropertyValueFactory("uName"));
                emailColumn.setCellValueFactory(new PropertyValueFactory("Email"));
                passwordColumn.setCellValueFactory(new PropertyValueFactory("pass"));
                ObservableList<User> UserObservableList = FXCollections.observableArrayList();
                FileIO fileIO = new FileIO();
                UserObservableList.addAll(fileIO.getUserList());
                tableView.setItems(UserObservableList);
                error.setText("edited " + ogUsername.getText() + " to " + edUsername.getText());
                ogUsername.setText("");
                ogEmail.setText("");
                ogPassword.setText("");
                edUsername.setText("");
                edEmail.setText("");
                edPassword.setText("");
            } else if (errCode == -1) {
                error.setText("wrong username/email/pass");
            }
        }
    }
    public void onSelSceneButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) selScene.getScene().getWindow();
        try {
            parent = FXMLLoader.load( getClass().getResource("Fxml/UserEditSelect.fxml"));
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
        ObservableList<User> userObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        userObservableList.addAll(fileIO.getUserList());
        tableView.setItems(userObservableList);

    }
}
