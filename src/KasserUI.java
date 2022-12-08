import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class KasserUI {

    ArrayList<String> container = new ArrayList<>();
    ArrayList<String> containerForSum = new ArrayList<>();


    public void kasserui() throws FileNotFoundException {
        Scanner læser = new Scanner(new File("almindelig.txt"));
        while (læser.hasNextLine()){
            container.add(læser.nextLine());

        }
        int numb = 1;
        for (int i = 0; i <container.size() ; i++) {
            if (container.get(i).contains("Vedkommende")) {
                System.out.println(numb + " " + container.get(i));
                numb++;
            }
        }

        container.clear();
    }
    public void beregnGældPrisen() throws FileNotFoundException {

        Scanner læser = new Scanner(new File("almindelig.txt"));
        while (læser.hasNextLine()){

            container.add(læser.nextLine());

        }
        int counter = 1;
        System.out.println("Gæld kan bemærkes nedestående");
        for (int i = 0; i <container.size() ; i++) {


            if (container.get(i).charAt(0)=='d') {
                System.out.println(counter + " " + container.get(i));
                counter++;
                containerForSum.add(container.get(i).substring(0,12));
            }
        }

        int[] sumholder = new int[containerForSum.size()];

        for(int i = 0; i<containerForSum.size();i++) {
            sumholder[i] = Integer.parseInt(containerForSum.get(i).replaceAll("\\D", ""));
        }

        int sum = 0;
        for (int i = 0; i <sumholder.length ; i++) {
            sumholder[i]=sumholder[i]/10;
            sum+=sumholder[i];
        }

        System.out.print(Farver.ANSI_RED_BACKGROUND);
        System.out.print(Farver.ANSI_BLACK);
        System.out.println("Den samlede mængde gæld der skal tilbagebetales er " + sum);
        System.out.print(Farver.ANSI_RESET);

        container.clear();
        containerForSum.clear();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new KasserUI().beregnGældPrisen();
        new KasserUI().kasserui();

    }
}
