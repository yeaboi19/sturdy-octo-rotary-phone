package JavaFX.User.Admin.Item;

import FileIO.FileIO;
import Items.Item;
import Items.ItemEdit;
import User.User;
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

public class ItemEditController implements Initializable {
    @FXML
    TextField ogName;
    @FXML
    TextField ogPrice;
    @FXML
    TextField edName;
    @FXML
    TextField edPrice;
    @FXML
    Button submit;
    @FXML
    Button back;
    @FXML
    TableView itemTableview;
    @FXML
    TableColumn nameColumn;
    @FXML
    TableColumn priceColumn;
    @FXML
    Label error;


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

    public void onSubmitButtonClicked() {
        if (ogName.getText().isEmpty() && ogPrice.getText().isEmpty()) {
            error.setText("please fill all the textFields");
        } else {
            ItemEdit itemEdit = new ItemEdit();
            double priceOg = Double.valueOf(ogPrice.getText());
            double priceEd = Double.valueOf(edPrice.getText());
            int errCode =itemEdit.Edit(ogName.getText(), priceOg, edName.getText(), priceEd);

            nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
            priceColumn.setCellValueFactory(new PropertyValueFactory("price"));

            ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
            FileIO fileIO = new FileIO();
            itemObservableList.addAll(fileIO.getItemList());
            itemTableview.setItems(itemObservableList);
            if (errCode == 1) {
                error.setText("successfully edited " + ogName.getText()+" to "+edName.getText());
                ogName.setText("");
                ogPrice.setText("");
                edName.setText("");
                edPrice.setText("");
            } else {
                error.setText("error try again");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        itemObservableList.addAll(fileIO.getItemList());
        itemTableview.setItems(itemObservableList);


        itemTableview.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    System.out.println(mouseEvent.getButton().name());
                    int index = itemTableview.getSelectionModel().getSelectedIndex();
                    Item item = (Item) itemTableview.getItems().get(index);

                    ogName.setText(item.getName());
                    ogPrice.setText(String.valueOf(item.getPrice()));
                }
            }
        });
    }
}
//TODO: make label //ok  //done
//TODO: