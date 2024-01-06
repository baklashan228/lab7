package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    public Button differentiation;

    @FXML
    public Button graphics;

    @FXML
    public Button operations;

    @FXML
    public Button settings;

    @FXML
    void initialize() {

    }
    public void operations(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("operations.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 1200, 752);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);

        stage.setScene(scene);
        stage.show();
    }
    public void diffFunction(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("DiffFunction.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 940, 750);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.show();

    }
    public void settings(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("settings.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 700);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.show();
    }
}
