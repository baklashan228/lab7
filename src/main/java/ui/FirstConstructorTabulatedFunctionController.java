package ui;

import functions.TabulatedFunction;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class FirstConstructorTabulatedFunctionController implements Initializable {

    public AnchorPane anchorPane;
    public Text enterSize;
    public VBox vBox;
    @FXML
    private TableView<TablePoint> table;

    @FXML
    private TextField textF;

    @FXML
    private TableColumn<TablePoint, Double> xColumn;

    @FXML
    private TableColumn<TablePoint, Double> yColumn;

    @FXML
    private Button creationButton;

    @FXML
    private Pane pane;

    private TableController controller;

    void setMainController(TableController controller) {
        this.controller = controller;
    }

    @FXML
    void sizeEnter(ActionEvent event){


            int size = Integer.parseInt(textF.getText());

            if (size < 2) throw new IllegalArgumentException();

            for (int i = 0; i < size; i++) {
                table.getItems().add(new TablePoint());
            }

            pane.setVisible(false);

            table.setVisible(true);
            creationButton.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        table.setFixedCellSize(30);
        table.prefHeightProperty().bind(table.fixedCellSizeProperty().multiply(Bindings.size(table.getItems()).add(1.4)));

        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));

        DoubleStringConverter stringConverter = new DoubleStringConverter();

        xColumn.setCellFactory(TextFieldTableCell.forTableColumn(stringConverter));
        xColumn.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setX(e.getNewValue()));

        yColumn.setCellFactory(TextFieldTableCell.forTableColumn(stringConverter));
        yColumn.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setY(e.getNewValue()));

        table.setEditable(true);

        table.setVisible(false);
        creationButton.setVisible(false);

        table.getSelectionModel().setCellSelectionEnabled(true);
    }

    @FXML
    void creatingFunction(){

            double[] xValues = new double[table.getItems().size()];
            double[] yValues = new double[table.getItems().size()];

            for (int i = 0; i < table.getItems().size(); i++) {
                xValues[i] = table.getItems().get(i).x;
                yValues[i] = table.getItems().get(i).y;
            }
            TabulatedFunction func = ChoosenFactory.getInstance().getFactory().create(xValues, yValues);
            controller.functionPresentation(func);
            Stage stage = (Stage) creationButton.getScene().getWindow();
            stage.close();
    }

}
