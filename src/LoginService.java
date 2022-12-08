import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoginService {

    formand f1 = new formand();
    KasserUI kasser = new KasserUI();
    Træner træner = new Træner();
    Scanner in = new Scanner(System.in);


    public void formandlogin() throws IOException {
        System.out.print(Farver.ANSI_GREEN_BACKGROUND);
        System.out.println("Succes");
        System.out.println("Du er nu logget ind som formand");
        System.out.print(Farver.ANSI_RESET);
        f1.indmeldelse();
    }

    public void trænerLogin() throws FileNotFoundException {
        System.out.print(Farver.ANSI_GREEN_BACKGROUND);
        System.out.println("Succes");
        System.out.println("Du er nu logget ind som træner");
        System.out.print(Farver.ANSI_RESET);

        System.out.println("Vil du se bedste tider?, Hvis ja så skriv ja ellers skriv nej");
        String trainerChoice = in.nextLine();

        String seVidere = "";
        int choose = 0;

        boolean controller = true;
        while (controller) {
            if (trainerChoice.equalsIgnoreCase("nej")) {
                System.out.println("Logger ud...");
                controller = false;
            }

            if (trainerChoice.equalsIgnoreCase("ja")) {
                System.out.println("Hvilken diciplin vil du se resultater for?\n" + "tast 1 for Bryst\ntast 2 for Crawl\n" +
                        "tast 3 for Butterfly\ntast 4 for Rygcrawl\ntast 9 for at stoppe");
                choose = in.nextInt();

                switch (choose) {
                    case 1:
                        træner.findBedstetider("Bryst");
                        break;
                    case 2:
                        træner.findBedstetider("Crawl");
                        break;
                    case 3:
                        træner.findBedstetider("Butterfly");
                        break;
                    case 4:
                        træner.findBedstetider("Rygcrawl");
                        break;
                    default:
                        System.out.println("Invalid input prøv igen");
                        break;
                    case 9:
                        System.out.print(Farver.ANSI_RED);
                        System.out.println("Du har valgt at afslutte...");
                        System.out.print(Farver.ANSI_RESET);
                        controller = false;
                        break;
                }

                if (choose == 9) {
                    controller = false;
                    break;
                }
                System.out.println("Vil du se mere?, Hvis ja så skriv ja. Hvis ikke så skriv s");
                in.nextLine();
                seVidere = in.nextLine();

                if (seVidere.equalsIgnoreCase("s")) {
                    System.out.print(Farver.ANSI_RED);
                    System.out.println("Logger ud....");
                    System.out.print(Farver.ANSI_RESET);
                    controller = false;
                    break;

                }

            }
        }
    }
    public void kasserLogin() throws FileNotFoundException {
        System.out.print(Farver.ANSI_GREEN_BACKGROUND);
        System.out.println("Succes");
        System.out.println("Du er nu logget ind som kasser");
        System.out.print(Farver.ANSI_RESET);
        System.out.println("Hvilken muligheder kunne du tænke dig at se?");


        while (true) {
            System.out.print(Farver.ANSI_BLUE_BACKGROUND);
            System.out.println("Tast 1 hvis du gerne vil se på personer der er i restance\nTast 2 hvis du gerne vil se" +
                    " summenbeløbet af alle kunder der er i restance\nTast 3" +
                    " hvis du gerne vil se på begge to\nTast 9 for at afslutte programmet");
            System.out.print(Farver.ANSI_RESET);
            int answer = in.nextInt();
            switch (answer) {
                case 1:
                    kasser.kasserui();
                    break;
                case 2:
                    kasser.beregnGældPrisen();
                    break;
                case 3:
                    kasser.kasserui();
                    kasser.beregnGældPrisen();
                    break;

                case 9:
                    System.out.print(Farver.ANSI_RED);
                    System.out.println("du har valgt at logge af....");
                    System.out.print(Farver.ANSI_RESET);
                    break;
                default:
                    System.out.println("vælg en valid muligheder");
            }
            if (answer==9){
                break;
            }
        }
    }

}
