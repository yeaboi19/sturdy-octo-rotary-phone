package JavaFX.User;

import FileIO.FileIO;
import Items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemSelectController implements Initializable {
    @FXML
    TableView tableView;
    @FXML
    TableColumn columnName;
    @FXML
    TableColumn columnPrice;
    @FXML
    TableView selectedTableView;
    @FXML
    TableColumn selectedColumnName;
    @FXML
    TableColumn selectedColumnPrice;
    @FXML
    Button finish;
    @FXML
    Label errorLabel;
    ArrayList<Item> ItemArray = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnName.setCellValueFactory(new PropertyValueFactory("name"));
        columnPrice.setCellValueFactory(new PropertyValueFactory("price"));
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        itemObservableList.addAll(fileIO.getItemList());
        tableView.setItems(itemObservableList);

        //-------------------------------------------------------------------------------------



        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    System.out.println(mouseEvent.getButton().name());
                    int index = tableView.getSelectionModel().getSelectedIndex();
                    Item item = (Item) tableView.getItems().get(index);
                    ItemArray.add(item);


                    selectedColumnName.setCellValueFactory(new PropertyValueFactory("name"));
                    selectedColumnPrice.setCellValueFactory(new PropertyValueFactory("price"));
                    ObservableList<Item> selectedItemObservableList = FXCollections.observableArrayList();
                    selectedItemObservableList.addAll(ItemArray);
                    selectedTableView.setItems(selectedItemObservableList);
                    errorLabel.setText("");
                }
            }
        });
        selectedTableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    System.out.println(mouseEvent.getButton().name());
                    int index = selectedTableView.getSelectionModel().getSelectedIndex();
                    Item item = (Item) selectedTableView.getItems().get(index);
                    ItemArray.remove(item);


                    selectedColumnName.setCellValueFactory(new PropertyValueFactory("name"));
                    selectedColumnPrice.setCellValueFactory(new PropertyValueFactory("price"));
                    ObservableList<Item> selectedItemObservableList = FXCollections.observableArrayList();
                    selectedItemObservableList.addAll(ItemArray);
                    selectedTableView.setItems(selectedItemObservableList);
                    errorLabel.setText("");
                }
            }
        });
    }

    public void onFinishButtonPressed() {
        if (ItemArray.size()!=0) {
            FileIO fileIO = new FileIO();
            if(fileIO.exportList(ItemArray)==1){
                errorLabel.setText("successfully wrote list to device");
            }else{
                errorLabel.setText("an error occurred");
            }
        }
    }
}