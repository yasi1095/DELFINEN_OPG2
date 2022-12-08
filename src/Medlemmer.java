import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Medlemmer {

    private String dateOfBirth;
    private String name;

    private boolean aktiv;
    private boolean restance;
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public Medlemmer(String dateOfBirth, String name, boolean aktiv, boolean restance) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.aktiv = aktiv;
        this.restance = restance;
    }

    public Medlemmer(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public boolean isRestance(){
        return restance;
    }
    public void setRestance(boolean restance){
        this.restance = restance;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPrice() {
        return price;
    }
    public int getAgeInYears() {

        LocalDate birthYear = LocalDate.parse(getDateOfBirth());

        long ageDifference = ChronoUnit.YEARS.between(birthYear, LocalDate.now());

        return (int) ageDifference;
    }


}