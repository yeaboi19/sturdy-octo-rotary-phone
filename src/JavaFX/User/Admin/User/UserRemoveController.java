package JavaFX.User.Admin.User;

import FileIO.FileIO;
import User.User;
import User.UserRemove;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    @FXML
    Label error;

    public void onRemoveButtonClicked() {
        if (userName.getText().isEmpty() && email.getText().isEmpty() && password.getText().isEmpty()) {
            error.setText("please fill all the textFields");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("you sure you want to delete user \"" + userName.getText() + "\"?");
            alert.show();
            if (alert.showAndWait().get().getButtonData().isDefaultButton()) {
                UserRemove userRemove = new UserRemove();
                int errCode = userRemove.remove(userName.getText(), email.getText(), password.getText());

                userNameColumn.setCellValueFactory(new PropertyValueFactory("uName"));
                emailColumn.setCellValueFactory(new PropertyValueFactory("Email"));
                passwordColumn.setCellValueFactory(new PropertyValueFactory("pass"));
                ObservableList<User> UserObservableList = FXCollections.observableArrayList();
                FileIO fileIO = new FileIO();
                UserObservableList.addAll(fileIO.getUserList());
                tableView.setItems(UserObservableList);
                if (errCode == 1) {
                    error.setText("successfully removed " + userName.getText());
                    userName.setText("");
                    email.setText("");
                    password.setText("");
                } else {
                    error.setText("error try again");
                }
            }
        }
    }

    public void onSelSceneButtonClicked() {
        Stage stage = new Stage();
        Parent parent;

        stage = (Stage) selScene.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("Fxml/UserEditSelect.fxml"));
            Scene scene = new Scene(parent);
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

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    System.out.println(mouseEvent.getButton().name());
                    int index = tableView.getSelectionModel().getSelectedIndex();
                    User user = (User) tableView.getItems().get(index);

                    userName.setText(user.getUName());
                    email.setText(user.getEmail());
                    password.setText(user.getPass());
                }
            }
        });


    }
}
//TODO: updating tableview after removin user
//TODO: clicking from tableview...