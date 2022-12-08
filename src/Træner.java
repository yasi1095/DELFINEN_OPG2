import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Træner {
    ArrayList<String> container = new ArrayList<>();
    ArrayList<String> containerForLeadingnums = new ArrayList<>();
    private String name;

    public Træner() {

    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void findBedstetider(String inputStilArt) throws FileNotFoundException {

        Scanner læser = new Scanner(new File("konkurrence.txt"));


        while (læser.hasNextLine()) {

            container.add(læser.nextLine());
        }

        for (int i = 0; i < container.size(); i++) {

            if (container.get(i).contains(inputStilArt)) {
                containerForLeadingnums.add(container.get(i));
            }
        }


        int[] q = new int[containerForLeadingnums.size()];

        for (int i = 0; i < containerForLeadingnums.size(); i++) {

            q[i] = Integer.parseInt(containerForLeadingnums.get(i).replaceAll("\\D", ""));

        }


        double[] yasin2 = new double[containerForLeadingnums.size()];
        String yasin[] = new String[q.length];


        for (int i = 0; i < yasin.length; i++) {
            yasin[i] = String.valueOf(q[i]);

        }

        for (int i = 0; i < q.length; i++) {

            if (yasin[i].length() == 3) {
                yasin2[i] = Double.parseDouble(yasin[i].substring(0, 3));

            }
            if (yasin[i].length() == 5) {
                yasin2[i] = Double.parseDouble(yasin[i].substring(0, 3));

            } else if (yasin[i].length() == 4) {
                yasin2[i] = Double.parseDouble(yasin[i].substring(0, 4));

            } else if (yasin[i].length() == 6) {
                yasin2[i] = Double.parseDouble(yasin[i].substring(0, 4));
            }
        }

        int countToFive;
        if (yasin2.length < 5) {
            countToFive = yasin.length;
        } else {
            countToFive = 5;
        }
        System.out.print("Top " + countToFive + " bedste tider for " + inputStilArt + "\n");

        for (int i = 0; i < yasin2.length; i++) {

            if ((yasin2[i] / 100) > 10) {
                yasin2[i] = yasin2[i] / 100;
            } else {
                yasin2[i] = yasin2[i] / 10;
            }

        }
        Arrays.sort(yasin2);

        for (int i = 0; i < countToFive; i++) {
            System.out.println(yasin2[i]);
        }

        String[] kombinererNavne = new String[countToFive];

        for (int i = 0; i < countToFive; i++) {
            kombinererNavne[i] = String.valueOf(yasin2[i]);
        }


        container.clear();
        containerForLeadingnums.clear();
        læser.close();

    }
}
