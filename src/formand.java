import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class formand extends Medlemmer {
    public void indmeldelse() throws IOException {

        while (true) {
            Scanner in = new Scanner(System.in);
            ArrayList<KonkurrencSvømmerService> MedlemslistenforKonkurrencesvømmere = new ArrayList<>();
            ArrayList<MedlemmerKlasseService> MedlemslistenforAlmindelige = new ArrayList<>();

            System.out.println("Vil du tilføje et almindeligt medlem eller en konkurrencesvømmer?\n" +
                    "1:  Tast a for almindeliig \n2:  Tast k for konkurrencesvømmer. \n" +
                    "3:  Tast s hvis du vil logge af ");
            String input = in.nextLine();
            if (input.equalsIgnoreCase("k")) {
                KonkurrencSvømmerService ks1 = new KonkurrencSvømmerService();

                ks1.KonkurrencesvømmerIndmelser();

                MedlemslistenforKonkurrencesvømmere.add(ks1);

                System.out.println(ks1);
                PrintWriter konkurrence = new PrintWriter(new FileWriter(new File("konkurrence.txt"), true));

                konkurrence.println(MedlemslistenforKonkurrencesvømmere);

                MedlemslistenforKonkurrencesvømmere.clear();

                konkurrence.flush();
                konkurrence.close();
            } else if (input.equalsIgnoreCase("a")) {
                MedlemmerKlasseService m1 = new MedlemmerKlasseService();
                m1.createMember();

                MedlemslistenforAlmindelige.add(m1);
                System.out.println(m1);

                PrintWriter almindelig = new PrintWriter(new FileWriter(new File("almindelig.txt"), true));
                almindelig.println(MedlemslistenforAlmindelige);

                MedlemslistenforAlmindelige.clear();

                almindelig.flush();
                almindelig.close();

            } else if (input.equalsIgnoreCase("s")) {
                System.out.print(Farver.ANSI_RED);
                System.out.println("Du har valgt at logge af...");
                System.out.print(Farver.ANSI_RESET);
                break;
            }

        }
    }
}