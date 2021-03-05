
import java.util.Random;

public class ExitThread extends Thread {

    public int musteriSayisi, bulunanKat;

    @Override
    public void run() {

        Random random = new Random();
        while (true) {
            musteriSayisi = random.nextInt(5) + 1;
            bulunanKat = random.nextInt(4) + 1;

            for (int i = 0; i < musteriSayisi ; i++) {
                if(Katlar.katGezenler.get(bulunanKat).size()==0) break;
                Katlar.asansorKuyruklar.get(bulunanKat).add(0);
                Katlar.katGezenler.get(bulunanKat).remove(0);
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("ExitThread hatası.");
            }

        }
    }

}
