package javaFX.auth.math;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestCalcGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("calculatorGUI.fxml"));
        Scene scene = new Scene(root);
      //scene.getStylesheets().add(0, "style/my.css");
        primaryStage.setTitle("FXML Welcome!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
