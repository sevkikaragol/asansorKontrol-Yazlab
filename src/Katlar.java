
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;


public class Katlar {
    
    static Object anahtar = new Object();
    
    public static ArrayList<ArrayList<Integer>> asansorKuyruklar = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> katGezenler = new ArrayList<>();
  
    public void olustur() {
        for(int i=0; i < 5; i++) {
       asansorKuyruklar.add(new ArrayList());
       katGezenler.add(new ArrayList());
    }
    }
            //Arraylistler'in baslangicta ici bos oldugu icin remove 
            //islemi yapamıyoruz. Bu yuzden ArrayList'in icini doldurduk.
            //Static tanimli oldugu icin hepsinde degisti.
    
}
