package example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class ViewPet {
    private Pet pet;
    private GridPane grid;
    private Text type;
    private Text name;
    private Text year;
    private Text month;
    private Text ownerPat;

    private void createPane(){
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Label typeTitle=new Label("Type: ");
        typeTitle.setFont(Font.font("Roboto",FontWeight.BOLD,20));
        grid.add(typeTitle,0,1);

        type=new Text();
        type.setFont(Font.font("Roboto", FontWeight.NORMAL,20));
        grid.add(type,1,1,2,1);

        Label nameTitle=new Label("Name: ");
        nameTitle.setFont(Font.font("Roboto",FontWeight.BOLD,20));
        grid.add(nameTitle,0,2);

        name=new Text();
        name.setFont(Font.font("Roboto",FontWeight.NORMAL,20));
        grid.add(name,1,2,2,1);

        Label ownerTitle=new Label("Owner: ");
        ownerTitle.setFont(Font.font("Roboto",FontWeight.BOLD,20));
        grid.add(ownerTitle,0,3);

        ownerPat=new Text();
        ownerPat.setFont(Font.font("Roboto",FontWeight.NORMAL,20));
        grid.add(ownerPat,1,3,2,1);

        Label yearsOldTitle=new Label("Age:");
        yearsOldTitle.setFont(Font.font("Roboto",FontWeight.BOLD,20));
        grid.add(yearsOldTitle,0,4);

        Label yearTitle=new Label("year");
        yearTitle.setFont(Font.font("Roboto",FontWeight.NORMAL,20));
        grid.add(yearTitle,2,4);

        year=new Text();
        year.setFont(Font.font("Roboto",FontWeight.NORMAL,20));
        grid.add(year,1,4);

        month=new Text();
        month.setFont(Font.font("Roboto",FontWeight.NORMAL,20));
        grid.add(month,3,4);

        Label monthTitle=new Label("month");
        monthTitle.setFont(Font.font("Roboto",FontWeight.NORMAL,20));
        grid.add(monthTitle,4,4);
    }

    public GridPane getPane() {
        return grid;
    }

    public void addInfPet(Pet pet){
        this.pet=pet;
        type.textProperty().bind(this.pet.typePetStringProperty());
        name.textProperty().bind(this.pet.namePetStringProperty());
        ownerPat.textProperty().bind(this.pet.nameOwnerStringProperty());
        year.textProperty().bind(this.pet.yearsPatProperty().asString());
        month.textProperty().bind(this.pet.monthPatProperty().asString());
    }

    public ViewPet(Pet pet){
        createPane();
        addInfPet(pet);
    }
}
