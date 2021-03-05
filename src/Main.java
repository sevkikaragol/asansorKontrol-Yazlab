
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void yazdir(){
        
        int bir = 0, iki = 0, uc = 0, dort = 0;
            try{
                for (int i = 0; i < Katlar.asansorKuyruklar.get(0).size(); i++) {
                    
                switch (Katlar.asansorKuyruklar.get(0).get(i)) {

                    case 1:
                        bir++;
                        break;

                    case 2:
                        iki++;
                        break;
                    case 3:
                        uc++;
                        break;
                    case 4:
                        dort++;
                        break;

                }

            }
           
            }
            catch(NullPointerException e){
                System.out.println("Switch() yerindeki hata");
            }
            System.out.print("          0. Kat : [");
            if(bir!=0){
                System.out.print("["+bir+",1]");
            }
            if(iki!=0){
                System.out.print("["+iki+",2]");
            }
            if(uc!=0){
                System.out.print("["+uc+",3]");
            }
            if(dort!=0){
                System.out.print("["+dort+",4]");
            }
            System.out.print("]");
            System.out.println("");
            
    }
    
    public static void main(String[] args) {
        


        Katlar a = new Katlar();
        a.olustur(); //Arraylistler'in baslangicta ici bos oldugu icin remove 
        //islemi yapamıyoruz. Bu yuzden ArrayList'in icini doldurduk.
        //Static tanimli oldugu icin hepsinde degisti.

        LoginThread girisKuyruk = new LoginThread();
        ExitThread cikisThread = new ExitThread();
        AsansorThread asansor1 = new AsansorThread();
        AsansorThread2 asansor2 = new AsansorThread2();
        AsansorThread3 asansor3 = new AsansorThread3();
        AsansorThread4 asansor4 = new AsansorThread4();
        AsansorThread5 asansor5 = new AsansorThread5();
        KontrolThread kontrol = new KontrolThread();
        
        girisKuyruk.start();
        cikisThread.start();
        asansor1.start();
        asansor2.start();
        asansor3.start();
        asansor4.start();
        asansor5.start();
        kontrol.start();

        while(true){
            synchronized(Katlar.anahtar){
            
            System.out.println("************************************************");
            System.out.println("0. kat --> Kuyruk : "+Katlar.asansorKuyruklar.get(0).size());
            System.out.println("1. kat --> Toplam : "+(int)(Katlar.katGezenler.get(1).size()+Katlar.asansorKuyruklar.get(1).size())+" Kuyruk : "+Katlar.asansorKuyruklar.get(1).size());
            System.out.println("2. kat --> Toplam : "+(int)(Katlar.katGezenler.get(2).size()+Katlar.asansorKuyruklar.get(2).size())+" Kuyruk : "+Katlar.asansorKuyruklar.get(2).size());
            System.out.println("3. kat --> Toplam : "+(int)(Katlar.katGezenler.get(3).size()+Katlar.asansorKuyruklar.get(3).size())+" Kuyruk : "+Katlar.asansorKuyruklar.get(3).size());
            System.out.println("4. kat --> Toplam : "+(int)(Katlar.katGezenler.get(4).size()+Katlar.asansorKuyruklar.get(4).size())+" Kuyruk : "+Katlar.asansorKuyruklar.get(4).size());
            
            System.out.println("Cikis Yapan Kisi Sayisi : "+(int)(asansor1.getExitCounter() + asansor2.getExitCounter() + asansor3.getExitCounter() + asansor4.getExitCounter() + asansor5.getExitCounter()));
            
            System.out.println("Asansör 1");
            System.out.println("          Durum : "+asansor1.durum);
            System.out.println("          Bulundugu Kat : "+asansor1.anlikKat);
            System.out.println("          Hedef Kat : "+asansor1.hedefKat);
            if(asansor1.yon==1)
                System.out.println("          Yon : Yukari");
            else
                System.out.println("          Yon : Asagi"); 
            System.out.println("          Kapasite : 10");
            System.out.println("          Icindeki Insan Sayisi : "+asansor1.icindekiInsanKuyruk.size());
            System.out.println("          Icindekiler : "+asansor1.icindekiInsanKuyruk);
           
            System.out.println("Asansör 2");
            System.out.println("          Durum : "+asansor2.durum);
            System.out.println("          Bulundugu Kat : "+asansor2.anlikKat);
            System.out.println("          Hedef Kat : "+asansor2.hedefKat);
            if(asansor2.yon==1)
                System.out.println("          Yon : Yukari");
            else
                System.out.println("          Yon : Asagi"); 
            System.out.println("          Kapasite : 10");
            System.out.println("          Icindeki Insan Sayisi : "+asansor2.icindekiInsanKuyruk.size());
            System.out.println("          Icindekiler : "+asansor2.icindekiInsanKuyruk);
           
            System.out.println("Asansör 3");
            System.out.println("          Durum : "+asansor3.durum);
            System.out.println("          Bulundugu Kat : "+asansor3.anlikKat);
            System.out.println("          Hedef Kat : "+asansor3.hedefKat);
            if(asansor3.yon==1)
                System.out.println("          Yon : Yukari");
            else
                System.out.println("          Yon : Asagi"); 
            System.out.println("          Kapasite : 10");
            System.out.println("          Icindeki Insan Sayisi : "+asansor3.icindekiInsanKuyruk.size());
            System.out.println("          Icindekiler : "+asansor3.icindekiInsanKuyruk);
           
            System.out.println("Asansör 4");
            System.out.println("          Durum : "+asansor4.durum);
            System.out.println("          Bulundugu Kat : "+asansor4.anlikKat);
            System.out.println("          Hedef Kat : "+asansor4.hedefKat);
            if(asansor4.yon==1)
                System.out.println("          Yon : Yukari");
            else
                System.out.println("          Yon : Asagi"); 
            System.out.println("          Kapasite : 10");
            System.out.println("          Icindeki Insan Sayisi : "+asansor4.icindekiInsanKuyruk.size());
            System.out.println("          Icindekiler : "+asansor4.icindekiInsanKuyruk);
           
            System.out.println("Asansör 5");
            System.out.println("          Durum : "+asansor5.durum);
            System.out.println("          Bulundugu Kat : "+asansor5.anlikKat);
            System.out.println("          Hedef Kat : "+asansor5.hedefKat);
            if(asansor5.yon==1)
                System.out.println("          Yon : Yukari");
            else
                System.out.println("          Yon : Asagi"); 
            System.out.println("          Kapasite : 10");
            System.out.println("          Icindeki Insan Sayisi : "+asansor5.icindekiInsanKuyruk.size());
            System.out.println("          Icindekiler : "+asansor5.icindekiInsanKuyruk);
           
            System.out.println("Katlarda Asansor Kuyrugunda Bekleyenler");
            yazdir();
            if(Katlar.asansorKuyruklar.get(1).size()==0) System.out.println("          1. Kat : []");
            else System.out.println("          1. Kat : ["+Katlar.asansorKuyruklar.get(1).size()+",0]");
            
            if(Katlar.asansorKuyruklar.get(2).size()==0) System.out.println("          2. Kat : []");
            else System.out.println("          2. Kat : ["+Katlar.asansorKuyruklar.get(2).size()+",0]");
            
            if(Katlar.asansorKuyruklar.get(3).size()==0) System.out.println("          3. Kat : []");
            else System.out.println("          3. Kat : ["+Katlar.asansorKuyruklar.get(3).size()+",0]");
            
            if(Katlar.asansorKuyruklar.get(4).size()==0) System.out.println("          4. Kat : []");
            else System.out.println("          4. Kat : ["+Katlar.asansorKuyruklar.get(4).size()+",0]");
            
            }
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }


    }
}
