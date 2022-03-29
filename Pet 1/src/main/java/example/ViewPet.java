package example;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Label;


public class ViewPet {
    private Pet pet;
    private GridPane grid;
    private Text type;
    private Text name;
    private Text yearsOld;
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

        yearsOld=new Text();
        yearsOld.setFont(Font.font("Roboto",FontWeight.NORMAL,20));
        grid.add(yearsOld,1,4);
    }

    public GridPane getPane() {
        return grid;
    }

    public void setPet(Pet pet){
        this.pet=pet;
        setInform();
    }

    public void setInform(){
        type.setText(pet.getTypePet());
        name.setText(pet.getNamePet());
        ownerPat.setText(pet.getNameOwner());
        if(pet.getYearsPat()<3) {
            yearsOld.setText(pet.getYearsPat() + " year " + pet.getMonthPat() + " months ");
        }
        else{
            yearsOld.setFill(Color.FIREBRICK);
            yearsOld.setText("Wrong! Rats don't live that long =(");
        }
    }

    public ViewPet(Pet pet){
        createPane();
        setPet(pet);
    }
}
