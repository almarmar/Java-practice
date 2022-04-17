package example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class Main extends Application {

    private TableView<Pet> table = new TableView<>();

    private ObservableList<Pet> data = FXCollections.observableArrayList(
            new Pet("Rat", "Lariska", "Shapoklyak", 5, 0));

    private void createTable() {
        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(new PropertyValueFactory<Pet, String>("typePet"));
        typeCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn nameCol = new TableColumn("Name Pet");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<Pet, String>("namePet"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn nameOwnerCol = new TableColumn("Owner");
        nameOwnerCol.setMinWidth(100);
        nameOwnerCol.setCellValueFactory(new PropertyValueFactory<Pet, String>("nameOwner"));
        nameOwnerCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn yearsCol = new TableColumn("Years");
        yearsCol.setMinWidth(100);
        yearsCol.setCellValueFactory(new PropertyValueFactory<Pet, Integer>("yearsPat"));
        yearsCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        TableColumn monthCol = new TableColumn("Months");
        monthCol.setMinWidth(100);
        monthCol.setCellValueFactory(new PropertyValueFactory<Pet, Integer>("monthPat"));
        monthCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        table.setItems(data);
        table.getColumns().addAll(typeCol, nameCol, nameOwnerCol, yearsCol, monthCol);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Table View Pet");
        primaryStage.setWidth(550);
        primaryStage.setHeight(550);

        createTable();

        Label label = new Label("Pet List");
        label.setFont(new Font("Roboto", 20));

        VBox root = new VBox();
        root.setSpacing(5);
        root.setPadding(new Insets(10, 0, 0, 10));
        root.setStyle("-fx-font-size: 12 pt");
        root.getChildren().addAll(label, table, dataEditGroup());

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox dataEditGroup() {
        HBox hb = new HBox();
        TextField addType = new TextField();
        addType.setPromptText("Type");
        addType.setMinWidth(100);
        TextField addName = new TextField();
        addName.setPromptText("Name");
        addName.setMinWidth(100);
        TextField addOwner = new TextField();
        addOwner.setPromptText("Owner");
        addOwner.setMinWidth(100);
        TextField addYears = new TextField();
        addYears.setPromptText("Years");
        addYears.setMinWidth(100);
        TextField addMonths = new TextField();
        addMonths.setPromptText("Months");
        addMonths.setMinWidth(100);

        final Button addButton = new Button("+");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Pet(
                    addType.getText(),
                    addName.getText(),
                    addOwner.getText(),
                    Integer.parseInt(addYears.getText()),
                    Integer.parseInt(addMonths.getText())));
            addType.clear();
            addName.clear();
            addOwner.clear();
            addYears.clear();
            addMonths.clear();
        });
        hb.getChildren().addAll(addType, addName, addOwner, addYears, addMonths, addButton);
        hb.setSpacing(3);
        return hb;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
