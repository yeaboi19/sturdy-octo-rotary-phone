package JavaFX.User.Admin.Item;

import FileIO.FileIO;
import Items.Item;
import Items.ItemRemove;
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
    @FXML
    Label error;

    public void onRemoveButtonClicked() {
        if (name.getText().isEmpty() && price.getText().isEmpty()) {
            error.setText("please fill all the textFields");
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("you sure you want to delete item \"" + name.getText() + "\"?");
            alert.show();
            if (alert.showAndWait().get().getButtonData().isDefaultButton()) {
                ItemRemove itemRemove = new ItemRemove();
                int errCode = itemRemove.remove(name.getText(), Double.valueOf(price.getText()));

                nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
                priceColumn.setCellValueFactory(new PropertyValueFactory("price"));

                ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
                FileIO fileIO = new FileIO();
                itemObservableList.addAll(fileIO.getItemList());
                tableView.setItems(itemObservableList);
                if (errCode == 1) {
                    error.setText("successfully removed " + name.getText());
                    name.setText("");
                    price.setText("");
                } else {
                    error.setText("error try again");
                }
            }
        }
    }

    public void onBackButtonClicked() {
        Stage stage = new Stage();
        Parent parent;

        stage = (Stage) back.getScene().getWindow();
        try {
            parent = FXMLLoader.load(getClass().getResource("../Item/Fxml/ItemEditSelect.fxml"));//insert ItemEditSelect.fxml path here...
            Scene scene = new Scene(parent);
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

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    System.out.println(mouseEvent.getButton().name());
                    int index = tableView.getSelectionModel().getSelectedIndex();
                    Item item = (Item) tableView.getItems().get(index);

                    name.setText(item.getName());
                    price.setText(String.valueOf(item.getPrice()));
                }
            }
        });

    }
}
