import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LogIn {
    Scanner in = new Scanner(System.in);
    LoginService loginService = new LoginService();
    public void login() throws InterruptedException, IOException {

        String s = "";
        String p = "";

        int counter = 0;

        while (true) {

            System.out.print(Farver.ANSI_BLUE);
            System.out.println("Indtast din brugernavn:");

            s = in.nextLine();

            System.out.println("Indtast din kode");
            p = in.nextLine();

            if (s.equalsIgnoreCase("Træner") && p.equalsIgnoreCase("træner123")) {
                System.out.print(Farver.ANSI_RESET);
                loginService.trænerLogin();

                break;

            }
            if (s.equalsIgnoreCase("kasser") && p.equalsIgnoreCase("kasser123")) {
                System.out.print(Farver.ANSI_RESET);
                loginService.kasserLogin();
                break;
            }
            if (s.equalsIgnoreCase("formand") && p.equalsIgnoreCase("formand123")) {
                System.out.print(Farver.ANSI_RESET);
                loginService.formandlogin();

                break;

            }
            else {
                System.out.print(Farver.ANSI_RESET);
                System.out.println("Forkert brugernavn eller kode prøv igen");
                counter++;
                if (counter >= 3) {
                    System.out.print(Farver.ANSI_RED);
                    System.out.println("Vent venligst 30 sek!!");
                    for (int i = 30; i >= 0; i--) {
                        System.out.print("\r" + i);
                        Thread.sleep(1000);
                        if (i==0){
                            System.out.println();
                        }
                    }
                }

            }
        }
    }

}

