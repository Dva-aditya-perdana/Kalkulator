package com.example.kalkulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                Objects.requireNonNull(
                        HelloApplication.class.getResource("/com/example/kalkulator/hello-view.fxml")
                )
        );

        Scene scene = new Scene(loader.load(), 400, 550);

        stage.setTitle("Kalkulator JavaFX");
        stage.setScene(scene);

        stage.setResizable(true);
        stage.setMaximized(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
