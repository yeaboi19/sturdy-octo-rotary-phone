import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("JavaFX/User/Fxml/Login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
/*
TODO: configure User intended Controller files || DONE
TODO: configure Admin intended User Controller files || in progress
TODO: configure Admin intended Admin Controller files || not even started


 */

    public static void main(String[] args) {
        launch(args);
    }
}
/*

Old rose  - BB8588 || 187 133 136
artichoke - A3A380 || 163 163 128
cornsilk  - EFEBCE || 239 235 206


 */