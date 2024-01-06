package ui;

import functions.factory.ArrayTabulatedFunctionFactory;
import functions.factory.LinkedListTabulatedFunctionFactory;
import functions.factory.TabulatedFunctionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
public class SettingsController implements Initializable {

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    void save(ActionEvent event) {
        Map<String, TabulatedFunctionFactory> map = new HashMap<String, TabulatedFunctionFactory>();
        map.put("Массив", new ArrayTabulatedFunctionFactory());
        map.put("Список", new LinkedListTabulatedFunctionFactory());

        ChoosenFactory.getInstance().setFactory(map.get(choice.getValue()));
        Stage stage = (Stage) choice.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Массив", "Список");
        choice.getItems().addAll(list);
        choice.getSelectionModel().select(0);
    }
}