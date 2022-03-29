package example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Information of Pet");
        Pet pet=new Pet("Rat","Lariska","Shapoklyak",10,1);
        VBox root=new VBox(10);
        root.setAlignment(Pos.CENTER);
        ViewPet viewPet = new ViewPet(pet);
        root.getChildren().add(viewPet.getPane());
        Button btn = new Button("+");
        btn.setPrefSize(50,50);
        btn.setOnAction((event -> {
            pet.increaseTheAgeOfThePet();
            viewPet.setInform();
        }));
        root.getChildren().add(btn);
        Scene scene=new Scene(root,500,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
