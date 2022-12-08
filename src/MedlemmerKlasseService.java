import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

public class MedlemmerKlasseService {

    private final int seniorPris = 1600;
    private final int juniorPris = 1000;
    private KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer();


    //overridden method
    public int getAgeInYears() {

        LocalDate birthYear = LocalDate.parse(konkurrenceSvømmer.getDateOfBirth());

        long ageDifference = ChronoUnit.YEARS.between(birthYear, LocalDate.now());

        return (int) ageDifference;
    }
    public int prisTjek() {
        if (konkurrenceSvømmer.isAktiv()==true) {
            if (getAgeInYears() >= 60) {
                konkurrenceSvømmer.setPrice(seniorPris / 100 * 75);
            } else if (getAgeInYears() >= 18 && getAgeInYears() < 60) {
                konkurrenceSvømmer.setPrice(seniorPris);
            } else if (getAgeInYears() < 18) {
                konkurrenceSvømmer.setPrice(juniorPris);
            }
        } else if (konkurrenceSvømmer.isAktiv() == false) {
            konkurrenceSvømmer.setPrice(500);
        }
        return konkurrenceSvømmer.getPrice();
    }
    public String debt() {

        Random random = new Random();
        int n = 0;
        double restancePrice = 0;
        String s = "";

        int randomizer = random.nextInt(99+1);
        int månedRandom = random.nextInt(3+1);

        if (randomizer<10){
            konkurrenceSvømmer.setRestance(true);
        }
        if (konkurrenceSvømmer.isRestance()==true&&månedRandom>0){

            n = månedRandom;
            restancePrice = prisTjek() * 1.06;

            restancePrice= n*restancePrice;
            s= ("Vedkommende har ikke betalt i "+ n + " år\n"  + "debt: "+restancePrice );
        } else if(konkurrenceSvømmer.isRestance()!=true)  {
            s= "Personen har ingen restance";
        }
        return s;
    }
    public void createMember(){
        Scanner in = new Scanner(System.in);
        System.out.println("Indtast medlems navn");
        konkurrenceSvømmer.setName(in.nextLine());

        System.out.println("Indtast medlems fødselsdato i formatet ÅÅÅÅ-MM-DD");
        konkurrenceSvømmer.setDateOfBirth(in.nextLine());

        System.out.println("Er " + konkurrenceSvømmer.getName() + " aktiv eller ej.\nHvis ja så tast ja.\nHvis ikke så tast nej ");

        String s = in.nextLine();
        if (s.equalsIgnoreCase("ja")) {
            konkurrenceSvømmer.setAktiv(true);
        } else {
            konkurrenceSvømmer.setAktiv(false);
        }
    }

    //Aktivitetsform i forhold til konkurrencesvømmere samt om de skal på senior eller juniorholdet
    public Svømmehold aktivitetsForm(boolean konkurrenceSvømmer) {
        Svømmehold s;


        if (getAgeInYears() >= 18 && konkurrenceSvømmer == true) {
            s = Svømmehold.SENIOR;
            return Svømmehold.SENIOR;
        } else {
            s = Svømmehold.JUNIOR;
            return Svømmehold.JUNIOR;

        }
//
    }
    public String toString() {
        return
                "age='" + getAgeInYears() + '\'' +
                        ", name='" + konkurrenceSvømmer.getName() + '\'' +
                        ", aktiv=" + konkurrenceSvømmer.isAktiv() +
                        " "+ debt() +
                        ", price=" + prisTjek();

    }
}
