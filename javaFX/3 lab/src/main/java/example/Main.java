package example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Model Dialog");
        Pet pet=new Pet("Rat","Lariska","Shapoklyak",5,0);
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        ViewPet viewPet = new ViewPet(pet);
        root.getChildren().add(viewPet.getPane());
        Button btn = new Button();
        btn.setText("Edit");
        btn.setFont(Font.font(20));
        btn.setOnAction((ActionEvent event) -> {
            PetEditDialog petEditDialog = new PetEditDialog(pet);
        });
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 700, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
