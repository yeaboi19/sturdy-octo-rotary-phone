package JavaFX.User.Admin.Item;

import FileIO.FileIO;
import Items.Item;
import Items.ItemEdit;
import User.User;
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

    public void onSubmitButtonClicked(){
        ItemEdit itemEdit = new ItemEdit();
        if(edPrice==null){
            edPrice=ogPrice;
        }else if(edName==null){
            edName=ogName;
        }
        double priceOg=Double.valueOf(ogPrice.getText());
        double priceEd=Double.valueOf(edPrice.getText());
        itemEdit.Edit(ogName.getText(),priceOg,edName.getText(),priceEd);

        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));

        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        itemObservableList.addAll(fileIO.getItemList());
        itemTableview.setItems(itemObservableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        FileIO fileIO = new FileIO();
        itemObservableList.addAll(fileIO.getItemList());
        itemTableview.setItems(itemObservableList);
    }
}
//TODO: make label
//TODO: