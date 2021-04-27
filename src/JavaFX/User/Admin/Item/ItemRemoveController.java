package JavaFX.User.Admin.Item;

import FileIO.FileIO;
import Items.Item;
import Items.ItemRemove;
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

public class ItemRemoveController implements Initializable {
    @FXML
    TextField name;
    @FXML
    TextField price;
    @FXML
    Button remove;
    @FXML
    Button back;
    @FXML
    TableView tableView;
    @FXML
    TableColumn nameColumn;
    @FXML
    TableColumn priceColumn;

    public void onRemoveButtonClicked(){
        ItemRemove itemRemove = new ItemRemove();
        itemRemove.remove(name.getText(),Double.valueOf(price.getText()));

        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        itemObservableList.addAll(fileIO.getItemList());
        tableView.setItems(itemObservableList);
    }

    public void onBackButtonClicked(){
        Stage stage =new Stage();
        Parent parent;

        stage = (Stage) back.getScene().getWindow();
        try {
            parent = FXMLLoader.load( getClass().getResource("../Item/Fxml/ItemEditSelect.fxml"));//insert ItemEditSelect.fxml path here...
            Scene scene =new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        itemObservableList.addAll(fileIO.getItemList());
        tableView.setItems(itemObservableList);
    }
}
