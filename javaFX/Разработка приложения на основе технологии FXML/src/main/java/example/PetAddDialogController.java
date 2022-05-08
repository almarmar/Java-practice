package example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PetAddDialogController {
    @FXML
    private TextField addType;
    @FXML
    private TextField addName;
    @FXML
    private TextField addYear;
    @FXML
    private TextField addMonth;
    @FXML
    private TextField addOwnerName;

    private Stage dialogStage;
    private Pet pet;
    private ButtonType result = ButtonType.CANCEL;
    String errorMessage = "";

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPet(Pet pet) {
        this.pet= pet;
    }

    public ButtonType getResult() {
        return result;
    }

    private boolean isInputValid() {
        if (addType.getText() == null || addType.getText().length() == 0) {
            errorMessage += "No valid pet type! ";
        }
        if (addName.getText() == null || addName.getText().length() == 0) {
            errorMessage += "No valid pet name! ";
        }
        if (addYear.getText() == null || addYear.getText().length() == 0) {
            errorMessage += "No valid years! ";
        }
        if (addMonth.getText() == null || addMonth.getText().length() == 0) {
            errorMessage += "No valid month! ";
        }
        if (addOwnerName.getText() == null || addOwnerName.getText().length() == 0) {
            errorMessage += "No valid owner name! ";
        }
        if (errorMessage.length() == 0)
            return true;
        else
            return false;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            pet.setTypePet(addType.getText());
            pet.setNamePet(addName.getText());
            pet.setYearsPat(Integer.parseInt(addYear.getText()));
            pet.setMonthPat(Integer.parseInt(addMonth.getText()));
            pet.setNameOwner(addOwnerName.getText());
            result = ButtonType.OK;
            dialogStage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(
                    getClass().getResource("alertstyle.css").toExternalForm());
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancel() {
        result = ButtonType.CANCEL;
        dialogStage.close();
    }
}
