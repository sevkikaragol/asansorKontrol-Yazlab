
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginThread extends Thread {

    public int musteriSayisi, gidilecekKat;

    @Override
    public void run() {

        Random random = new Random();
        while (true) {
            musteriSayisi = random.nextInt(10) + 1;
            gidilecekKat = random.nextInt(4) + 1;

            for (int i = 0; i < musteriSayisi; i++) {

                Katlar.asansorKuyruklar.get(0).add(gidilecekKat);

            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("LoginThread hatası.");
            }

        }

    }
}
