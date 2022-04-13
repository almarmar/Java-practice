package example;

public class Pet {
    private String typePet;
    private String namePet;
    private String nameOwner;
    private int monthPat;
    private int yearsPat;

    public String getTypePet() {
        return typePet;
    }
    public String getNamePet() {
        return namePet;
    }
    public String getNameOwner() {
        return nameOwner;
    }
    public int getMonthPat() {
        return monthPat;
    }

    public int getYearsPat() {
        return yearsPat;
    }

    public Pet(String typePet, String namePet, String nameOwner, int monthPat,int yearsPat){
        this.typePet=typePet;
        this.namePet=namePet;
        this.nameOwner=nameOwner;
        this.monthPat=monthPat;
        this.yearsPat=yearsPat;
    }
    public void increaseTheAgeOfThePet(){
        monthPat++;
        if(monthPat==12){
            yearsPat++;
            monthPat=0;
        }
    }
}
