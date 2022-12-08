import java.util.Random;
import java.util.Scanner;

public class KonkurrencSvømmerService {

    private boolean kanCrawl;
    private boolean kanBryst;
    private boolean kanRygCrawl;
    private boolean kanButterfly;
    private KonkurrenceSvømmer hej = new KonkurrenceSvømmer();



    public KonkurrencSvømmerService(){
    }

    public boolean isKanCrawl() {
        return kanCrawl;
    }

    public void setKanCrawl(boolean kanCrawl) {
        this.kanCrawl = kanCrawl;
    }

    public boolean isKanBryst() {
        return kanBryst;
    }

    public void setKanBryst(boolean kanBryst) {
        this.kanBryst = kanBryst;
    }

    public boolean isKanRygCrawl() {
        return kanRygCrawl;
    }

    public void setKanRygCrawl(boolean kanRygCrawl) {
        this.kanRygCrawl = kanRygCrawl;
    }

    public boolean isKanButterfly() {
        return kanButterfly;
    }

    public void setKanButterfly(boolean kanButterfly) {
        this.kanButterfly = kanButterfly;
    }


    public void KonkurrencesvømmerIndmelser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Indtast medlems navn");
        hej.setName(in.nextLine());

        System.out.println("Indtast medlems fødselsdato i formatet ÅÅÅÅ-MM-DD");
        hej.setDateOfBirth(in.nextLine());

        System.out.println("Indtast konkurrencesvømmerens disciplin. Indtast c for crawl, b for bryst," +
                " bf for butterfly, rg for rygcrawl");

        String s = in.nextLine();

        while (true) {
            if (s.equalsIgnoreCase("c")) {
                setKanCrawl(true);
            } else if (s.equalsIgnoreCase("b")) {
                setKanBryst(true);
            } else if (s.equalsIgnoreCase("bf")) {
                setKanButterfly(true);
            } else if (s.equalsIgnoreCase("rg")) {
                setKanRygCrawl(true);
            }
            System.out.println("vil du tilføje mere. Tast ja, hvis du vil tilføje mere, ellers tast nej");
            String q = in.nextLine();
            if (q.equalsIgnoreCase("ja")) {
                System.out.println("Indtast konkurrencesvømmerens disciplin. Indtast c for crawl, b for bryst," +
                        " bf for butterfly, rg for rygcrawl");
                s = in.nextLine();
            } else if (q.equalsIgnoreCase("nej")) {
                break;
            }

        }
    }
    public double bedsteTider(){
        Random random = new Random();

        double resultat = random.nextInt(1000)+2000;

        double sumResultat = resultat/100;


        return sumResultat;
    }
    public String returnerSvømmestil() {

        String b = "";
        String kb = "";
        String kc = "";
        String krc = "";

        if (isKanBryst() == true) {

            b = " Bedste tid for Bryst er " +bedsteTider() + " sekunder\n";
        }
        if (isKanButterfly() == true) {
            kb =  " Bedste tid for Butterfly er " +bedsteTider() + " sekunder\n";
        }
        if (isKanCrawl() == true) {
            kc = " Bedste tid for Crawl er " +bedsteTider() + " sekunder\n";
        }
        if (isKanRygCrawl() == true) {
            krc =  " Bedste tid for Rygcrawl er " +bedsteTider() + " sekunder";

        }
        String samlet = b + kb + kc + krc;

        return samlet.substring(1, samlet.length() - 1) ;
    }
    public String holdForTrænere(){

        Svømmehold s;
        Træner træner = new Træner();
        træner.setName("Hardy Akira Madsen");
        Træner træner1 = new Træner();
        træner1.setName("Patrick Agergaard");

        String holder = "";

        if (hej.getAgeInYears() >= 18) {

            holder= træner.getName();

            s = Svømmehold.SENIOR;
        } else {

            holder= træner1.getName();
            s = Svømmehold.JUNIOR;
        }
        return holder;

    }
    public Enum hold() {

        Enum e;

        if (hej.getAgeInYears() >= 18) {

            e = Svømmehold.SENIOR;
        } else {
            e = Svømmehold.JUNIOR;
        }
        return e;
    }

    @Override
    public String toString() {

        return
                "Navn: " + hej.getName() + ", " + hej.getName() + " er tilmeldt følgende svømmestile: " + returnerSvømmestil() + ": Alder: " +
                        hej.getAgeInYears() + " hold: " + hold() + " Træner: " +holdForTrænere() ;



    }

}
