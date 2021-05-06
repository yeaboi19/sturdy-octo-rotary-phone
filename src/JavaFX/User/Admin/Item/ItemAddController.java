package JavaFX.User.Admin.Item;

import Items.ItemAdd;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemAddController {
    @FXML
    TextField name;
    @FXML
    TextField price;
    @FXML
    Button addButton;
    @FXML
    Button back;
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
    public void onAddButtonClicked(){
        ItemAdd itemAdd = new ItemAdd();
        double price1=Double.valueOf(price.getText());
        int errCode = itemAdd.add(name.getText(),price1);
        if(errCode==1){
            error.setText(name.getText()+" just got added");
        }else{
            error.setText("this item is already added");
        }
    }
}
