package ui;


import functions.TabulatedFunction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import operations.TabulatedFunctionOperationService;

import java.net.URL;
import java.util.ResourceBundle;

public class OperationsController implements Initializable {

    @FXML
    public ChoiceBox<String> opChoice;
    @FXML
    public TableColumn<TablePoint, Double> yColumn;
    @FXML
    public TableColumn<TablePoint, Double> xColumn;
    @FXML
    public TableView<TablePoint> table;
    public AnchorPane anchorPane;

    @FXML
    Parent firstTable;

    @FXML
    Parent secondTable;
    @FXML
    TableController firstTableController;
    @FXML
    TableController secondTableController;
    @FXML
    public Pane pane;

    TabulatedFunction function;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        table.setPlaceholder(new Label(""));

        ObservableList<String> list = FXCollections.observableArrayList("+", "-", "*", ":");
        opChoice.getItems().addAll(list);

        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));

        opChoice.getSelectionModel().select(0);

    }

    public void doOperation(ActionEvent action){

        TabulatedFunctionOperationService operationService = new TabulatedFunctionOperationService();

            switch (opChoice.getValue()) {

                case "+":
                    function = operationService.add(firstTableController.function, secondTableController.function);
                    break;

                case "-":
                    function = operationService.sub(firstTableController.function, secondTableController.function);
                    break;

                case "*":
                    function = operationService.multiply(firstTableController.function, secondTableController.function);
                    break;

                case ":":
                    function = operationService.divide(firstTableController.function, secondTableController.function);
                    break;

            }
            table.getItems().clear();
            for (int i = 0; i < function.getCount(); i++) {
                table.getItems().add(new TablePoint(function.getX(i), function.getY(i)));
            }
        }
}
