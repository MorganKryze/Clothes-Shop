package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/homescreen.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1100, 800);
        scene.getStylesheets().add(App.class.getResource("styles/default.css").toExternalForm());
        primaryStage.setTitle("Women Shop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
