package ui;

import functions.TabulatedFunction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {


    public Button tableButton;
    public Pane pane;
    @FXML
    private TableView<TablePoint> table;


    @FXML
    private TableColumn<TablePoint, Double> xColumn;

    @FXML
    private TableColumn<TablePoint, Double> yColumn;

    TabulatedFunction function;


    public void tableCreation(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FirstConstructorTabulatedFunction.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 800, 700);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.setTitle("Создание функции");
        stage.show();
        FirstConstructorTabulatedFunctionController controller = fxmlLoader.getController();
        controller.setMainController(this);
    }

    public void functionPresentation(TabulatedFunction function) {

        this.function = function;

        table.getItems().clear();

        for (int i = 0; i < function.getCount(); i++) {
            table.getItems().add(new TablePoint(function.getX(i), function.getY(i)));
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        table.setPlaceholder(new Label(""));


        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));

        DoubleStringConverter stringConverter = new DoubleStringConverter();

        yColumn.setCellFactory(TextFieldTableCell.forTableColumn(stringConverter));
        yColumn.setOnEditCommit(e -> {
            e.getTableView().getItems().get(e.getTablePosition().getRow()).setY(e.getNewValue());
            function.setY(   e.getTablePosition().getRow(), e.getNewValue());
        });

        table.setEditable(true);
        table.getSelectionModel().setCellSelectionEnabled(true);
    }
}
