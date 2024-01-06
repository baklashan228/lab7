package ui;

import functions.factory.ArrayTabulatedFunctionFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("ЛР 7");
        stage.setScene(scene);
        stage.show();
        ChoosenFactory.getInstance().setFactory(new ArrayTabulatedFunctionFactory());
    }

    public static void main(String[] args) {
        launch();
    }
}