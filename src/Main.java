import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        new Main().run();
    }
    public void run() throws IOException, InterruptedException {

        LogIn log = new LogIn();
        log.login();

    }
}

