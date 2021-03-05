
import java.util.logging.Level;
import java.util.logging.Logger;

public class KontrolThread extends Thread {

    private int toplamBekleyen = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(KontrolThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for (int i = 0; i < 5; i++) {
                toplamBekleyen += Katlar.asansorKuyruklar.get(i).size();
            }
            
            if(toplamBekleyen<20){
                AsansorThread2.durum=false;
                AsansorThread3.durum=false;
                AsansorThread4.durum=false;
                AsansorThread5.durum=false;
            }
            else if(toplamBekleyen<40){
                AsansorThread2.durum=true;
                AsansorThread3.durum=false;
                AsansorThread4.durum=false;
                AsansorThread5.durum=false;
            }
            else if(toplamBekleyen<60){
                AsansorThread2.durum=true;
                AsansorThread3.durum=true;
                AsansorThread4.durum=false;
                AsansorThread5.durum=false;
            }
            else if(toplamBekleyen<80){
                AsansorThread2.durum=true;
                AsansorThread3.durum=true;
                AsansorThread4.durum=true;
                AsansorThread5.durum=false;
            }
            else{
                AsansorThread2.durum=true;
                AsansorThread3.durum=true;
                AsansorThread4.durum=true;
                AsansorThread5.durum=true;
            }
            //System.out.println("Toplam bekleyen : "+toplamBekleyen);
            this.toplamBekleyen=0;
        }
    }

}
