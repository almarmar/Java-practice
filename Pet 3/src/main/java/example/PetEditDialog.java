package example;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class PetEditDialog {
    private Pet pet;
    private Stage dialog;
    private Spinner<Integer> yearsPatEdit;
    private Spinner<Integer> monthPatEdit;
    private ComboBox<String> typePatEdit;
    private Font font;
    private GridPane root;
    private TextField namePetEdit;
    private TextField nameOwnerEdit;
    private ButtonType result = ButtonType.CANCEL;

    private void createNameText() {
        Label namePet = new Label("Name Pet:");
        namePet.setFont(font);
        root.add(namePet, 0, 1);
        namePetEdit = new TextField();
        namePetEdit.setFont(Font.font(24));
        namePetEdit.setText(pet.getNamePet());
        root.add(namePetEdit, 1, 1);
    }
    private void createNameText1() {
        Label nameOwner = new Label("Name Owner:");
        nameOwner.setFont(font);
        root.add(nameOwner, 0, 3);
        nameOwnerEdit = new TextField();
        nameOwnerEdit.setFont(Font.font(24));
        nameOwnerEdit.setText(pet.getNameOwner());
        root.add(nameOwnerEdit, 1, 3);
    }

    private void createComboBox() {
        Label holidayOrg = new Label("Type:");
        holidayOrg.setFont(font);
        root.add(holidayOrg, 0, 0);
        typePatEdit = new ComboBox<>();
        typePatEdit.setStyle("-fx-font-size: 24 pt");
        typePatEdit.getItems().addAll(
                "Dog",
                "Cat",
                "Rat",
                "Hamster",
                "Parrot",
                "Guinea pig",
                "Horse",
                "Mink",
                "Mouse",
                "Muskrat"
        );
        typePatEdit.setValue(pet.getTypePet());
        root.add(typePatEdit, 1, 0);
    }

    private void createSpinner() {
        Label personnelOrg = new Label("Years:");
        personnelOrg.setFont(font);
        root.add(personnelOrg, 0, 2);
        yearsPatEdit = new Spinner<>(0, 20,pet.getYearsPat());
        yearsPatEdit.setStyle("-fx-font-size: 24 pt");
        yearsPatEdit.setEditable(true);
        root.add(yearsPatEdit, 1, 2);
        Label drinkVolumeOrg = new Label("Month:");
        drinkVolumeOrg.setFont(font);
        root.add(drinkVolumeOrg, 2, 2);
        monthPatEdit = new Spinner<>(0, 12, pet.getMonthPat());
        monthPatEdit.setStyle("-fx-font-size: 24 pt");
        monthPatEdit.setEditable(true);
        root.add(monthPatEdit, 3, 2);

    }

    private void createButtons() {
        Button btnOk = new Button("Ok");
        btnOk.setFont(Font.font(24));
        root.add(btnOk, 0, 5);
        btnOk.setOnAction((ActionEvent e) -> {
            if (isInputValid())
                handleOk();
            else message();
        });
        Button btnCancel = new Button("Cancel");
        btnCancel.setFont(Font.font(24));
        root.add(btnCancel, 1, 5);
        btnCancel.setOnAction((ActionEvent e) -> {
            handleCancel();
        });
    }

    private void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Data entry error");
        alert.setHeaderText("Name entry error");
        alert.setContentText("\"The name of the owner and the pet must begin with a capital letter and contain only letters of the English alphabet\\n \"");
        alert.showAndWait();
    }

    public PetEditDialog(Pet pet){
        this.pet=pet;
        dialog=new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Edit Pat Information");
        root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        font = Font.font("Roboto", FontWeight.NORMAL, 20);
        createNameText();
        createNameText1();
        createSpinner();
        createComboBox();
        createButtons();
        Scene scene = new Scene(root, 600, 500);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    private boolean isInputValid() {
        return namePetEdit.getText().matches("[A-Z][a-z]+") & nameOwnerEdit.getText().matches("[A-Z][a-z]+");
    }

    private void handleOk() {
        pet.setNamePet(namePetEdit.getText());
        pet.setNameOwner(nameOwnerEdit.getText());
        pet.setYearsPat(yearsPatEdit.getValue());
        pet.setTypePet(typePatEdit.getValue().toString());
        pet.setMonthPat(monthPatEdit.getValue());
        result = ButtonType.OK;
        dialog.close();
    }

    private void handleCancel() {
        result = ButtonType.CANCEL;
        dialog.close();
    }

    public ButtonType getResult() {
        return result;
    }
}
