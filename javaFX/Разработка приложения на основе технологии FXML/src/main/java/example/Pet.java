package example;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pet {
    private StringProperty typePet;
    private StringProperty namePet;
    private IntegerProperty monthPat;
    private IntegerProperty yearsPat;
    private StringProperty nameOwner;

    public StringProperty typePetStringProperty() {
        if (typePet == null) {
            typePet = new SimpleStringProperty();
        }
        return typePet;
    }

    public final void setTypePet(String value) {

        typePetStringProperty().set(value);
    }

    public final String getTypePet() {
        return typePetStringProperty().get();
    }

    public StringProperty namePetStringProperty() {
        if (namePet == null) {
            namePet = new SimpleStringProperty();
        }
        return namePet;
    }

    public final void setNamePet(String value) {
        namePetStringProperty().set(value);
    }

    public final String getNamePet() {
        return namePetStringProperty().get();
    }

    public IntegerProperty monthPatProperty() {
        if (monthPat == null) {
            monthPat = new SimpleIntegerProperty();
        }
        return monthPat;
    }

    public final void setMonthPat(Integer value) {
        monthPatProperty().set(value);
    }

    public final Integer getMonthPat() {
        return monthPatProperty().get();
    }


    public IntegerProperty yearsPatProperty() {
        if (yearsPat == null) {
            yearsPat = new SimpleIntegerProperty();
        }
        return yearsPat;
    }

    public final void setYearsPat(Integer value) {
        yearsPatProperty().set(value);
    }

    public final Integer getYearsPat() {
        return yearsPatProperty().get();
    }

    public StringProperty nameOwnerStringProperty() {
        if (nameOwner == null) {
            nameOwner = new SimpleStringProperty();
        }
        return nameOwner;
    }

    public final void setNameOwner(String value) {
        nameOwnerStringProperty().set(value);
    }

    public final String getNameOwner() {
        return nameOwnerStringProperty().get();
    }

    public Pet(String typePet, String namePet, String nameOwner, int monthPat, int yearsPat) {
        typePetStringProperty().set(typePet);
        namePetStringProperty().set(namePet);
        nameOwnerStringProperty().set(nameOwner);
        monthPatProperty().set(monthPat);
        yearsPatProperty().set(yearsPat);
    }
}
