package example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {;

    private ObservableList<Pet> data = FXCollections.observableArrayList(
            new Pet("Rat", "Lariska", "Shapoklyak", 5, 0));

    @Override
    public void start(Stage stage) {
        try{
            stage.setTitle("Pet");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("MainWindow.fxml"));
            Parent root = loader.load();
            MainWindowController controller = loader.getController();
            controller.setData(data);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            System.out.println("Loader error");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
