package example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Simple Model-View Data Binding");
        Pet pet = new Pet("Rat", "Lariska", "Shapoklyak", 5, 0);
        HBox root = new HBox(10);

        ViewPet viewPet = new ViewPet(pet);
        root.getChildren().add(viewPet.getPane());

        root.getChildren().add(new Separator(Orientation.VERTICAL));

        root.getChildren().add(editBlock(pet));

        Scene scene = new Scene(root, 900, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox editBlock(Pet pet) {
        VBox editPane = new VBox(10);
        editPane.setPadding(new Insets(20));

        Label labelTitle = new Label("Enter new information");
        labelTitle.setFont(Font.font(20));

        TextField editType = new TextField("Rat");
        editType.setFont(Font.font(20));
        editType.setPrefSize(150, 40);

        editType.setOnKeyPressed((KeyEvent ke) -> {
            System.out.println("TextField. Key pressed: " + ke.getText());
            if (ke.getText().equals("l") && ke.isControlDown()) {
                editType.setFont(Font.font("Arial", 30));
            }
            if (ke.getCode() == KeyCode.S && ke.isControlDown()) {
                editType.setFont(Font.font("Times New Roman", 5));
            }
        });

        editType.setOnKeyReleased((KeyEvent ke) -> {
            System.out.println("TextField. Key released: " + ke.getText());
        });

        TextField editName = new TextField("Lariska");
        editName.setFont(Font.font(20));
        editName.setPrefSize(150, 40);

        editName.setOnKeyPressed((KeyEvent ke) -> {
            System.out.println("TextField. Key pressed: " + ke.getText());
            if (ke.getText().equals("l") && ke.isControlDown()) {
                editName.setFont(Font.font("Arial", 30));
            }
            if (ke.getCode() == KeyCode.S && ke.isControlDown()) {
                editName.setFont(Font.font("Times New Roman", 5));
            }
        });

        editType.setOnKeyReleased((KeyEvent ke) -> {
            System.out.println("TextField. Key released: " + ke.getText());
        });

        TextField editOwner = new TextField("Shapoklyak");
        editOwner.setFont(Font.font(20));
        editOwner.setPrefSize(150, 40);

        Spinner<Integer> editYear = new Spinner<>(0, 20, 0, 1);
        editYear.setPrefSize(100, 40);
        editYear.setStyle("-fx-font-size: 20");

        Spinner<Integer> editMonth = new Spinner<>(0, 12, 0, 1);
        editMonth.setPrefSize(100, 40);
        editMonth.setStyle("-fx-font-size: 20");

        Button btn = new Button("Edit");
        btn.setFont(Font.font(20));
        btn.setOnAction((ActionEvent event) -> {
            pet.setTypePet(editType.getText());
            pet.setNamePet(editName.getText());
            pet.setNameOwner(editOwner.getText());
            pet.setYearsPat(editYear.getValue());
            pet.setMonthPat(editMonth.getValue());

        });

        editPane.getChildren().addAll(labelTitle, editType, editName, editOwner, editYear, editMonth, btn);
        return editPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
