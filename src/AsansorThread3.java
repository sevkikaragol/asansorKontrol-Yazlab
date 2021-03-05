
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AsansorThread3 extends Thread {

    public int yon = 1;                        // yukari 1, asagi 0
    public static boolean durum = false;        // aktif true, bekleme false
    public int kapasite = 10;                  // maks 10
    public int hedefKat = 0;
    public int anlikKat = 0;
    public int exitCounter = 0;
    public int controlCount = 0;
    public int icindekiInsanSayisi = 0;
    public int durumSayaci=0;
    public boolean insanVarmi=false;
    public static ArrayList<Integer> icindekiInsanKuyruk = new ArrayList<>();
    
    public int getExitCounter() {
        return exitCounter;
    }

    public void setExitCounter(int exitCounter) {
        this.exitCounter += exitCounter;
    }

    @Override
    public void run() {
        //System.out.println("3. asansör çalışıyor.------------------------------------------------------------------------------------------------------------");
        
        while (true) {
            System.out.print("");
            if (this.durum == true) {
                this.insanVarmi=true;
                hareketEt();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AsansorThread2.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println("********************************************");
            }
            else if(this.durum == false){
                if(this.insanVarmi==true){
                    hareketEt();
                    try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AsansorThread2.class.getName()).log(Level.SEVERE, null, ex);
                }
                    //System.out.println("********************************************");
                }
                else{
                    System.out.print("");
                }
            }
        }
    }

    private void hareketEt() {
        synchronized(Katlar.anahtar){
        if (this.yon == 1) {
            //System.out.println("Yukarı doğru gidiyorum..");
            if (this.anlikKat == 0) {
                for(int i = this.icindekiInsanSayisi ; i < this.kapasite ; i++) {
                    if(Katlar.asansorKuyruklar.get(this.anlikKat).size()==0) break;
                    this.icindekiInsanKuyruk.add(Katlar.asansorKuyruklar.get(this.anlikKat).get(0));
                    this.icindekiInsanSayisi++;
                    Katlar.asansorKuyruklar.get(this.anlikKat).remove(0);

                }
                //System.out.println(this.anlikKat + ". katta asansör içindeki kuyruk : "+ this.icindekiInsanKuyruk);
            } 
            else {
                //int geciciSize = this.icindekiInsanKuyruk.size();
                for (int i = 0 ; i < this.icindekiInsanKuyruk.size() ; i++) {
                    if (this.icindekiInsanKuyruk.get(i) == this.anlikKat) {
                        this.icindekiInsanKuyruk.remove(i);
                        i--;
                        Katlar.katGezenler.get(this.anlikKat).add(0);
                        this.icindekiInsanSayisi--;
                    }
                }
                if(this.icindekiInsanKuyruk.size()==0 && this.anlikKat != 4){
                    for(int i=this.anlikKat+1 ; i <= 4 ; i++){
                        if(Katlar.asansorKuyruklar.get(i).size() == 0){
                            this.controlCount++;
                            //System.out.println("Controlcounter : "+this.controlCount);
                        }
                       
                    }
                    if(controlCount == 4 - this.anlikKat){
                        //System.out.println(this.anlikKat+"'tan daha yukarıda bekleyen yok ve asansör boşaldı, bu yüzden aşağı doğru gitmeye başlıyorum.");
                        this.yon=0;
                        this.controlCount=0;
                        return;
                    }
                    this.controlCount=0;
                }
                //System.out.println(this.anlikKat + ". katta asansör içindeki kuyruk : " + this.icindekiInsanKuyruk);
            }

            if(this.icindekiInsanKuyruk.size()!=0){
            int geciciHedef = 5;
            for (int i = 0; i < icindekiInsanKuyruk.size(); i++) {
                if (icindekiInsanKuyruk.get(i) < geciciHedef && this.anlikKat != 4) {
                    geciciHedef = icindekiInsanKuyruk.get(i);
                }
            }
            this.hedefKat = geciciHedef;
        }
            else if(this.icindekiInsanKuyruk.size()==0){
                for(int i = 4 ; i > this.anlikKat ; i--){
                    if(Katlar.asansorKuyruklar.get(i).size()>0){
                        this.hedefKat = i;
                        break;
                    }
                }
            }
            if(this.anlikKat==4) this.hedefKat=0;
            //System.out.println("Şu an ki hedef kat : "+ this.hedefKat);


            
            if(this.durum == false && this.icindekiInsanKuyruk.size()!=0){
                this.insanVarmi=true;
                
            }
            else if(this.durum == false && this.icindekiInsanKuyruk.size()==0){
                this.insanVarmi=false;
                return;
            }

            if (this.anlikKat == 4) {
                this.yon = 0;
            } else {
                this.anlikKat++;
            }

            
            
            
            
        } else if (this.yon == 0) {
            //System.out.println("Aşağı doğru gidiyorum.");
            this.hedefKat=0;
            if (this.anlikKat == 0) {
                for (int i = 0; i < this.icindekiInsanKuyruk.size(); i++) {
                        this.icindekiInsanKuyruk.remove(i);
                        i--;
                        this.icindekiInsanSayisi--;
                        this.setExitCounter(1);
                    
                }
                //System.out.println(this.anlikKat+". katta asansör içindeki kuyruk : "+this.icindekiInsanKuyruk);
            } 
            else {
                for (int i = this.icindekiInsanSayisi; i < this.kapasite ; i++) {
                    if(Katlar.asansorKuyruklar.get(this.anlikKat).size()==0) break;
                    this.icindekiInsanKuyruk.add(Katlar.asansorKuyruklar.get(this.anlikKat).get(0));
                    this.icindekiInsanSayisi++;
                    Katlar.asansorKuyruklar.get(this.anlikKat).remove(0);

                }
                //System.out.println(this.anlikKat+". katta asansör içindeki kuyruk : "+this.icindekiInsanKuyruk);
            }
            //System.out.println("Şu an ki hedef kat : "+ this.hedefKat);
            
   
            
            if(this.durum == false && this.icindekiInsanKuyruk.size()!=0){
                this.insanVarmi=true;
                
            }
            else if(this.durum == false && this.icindekiInsanKuyruk.size()==0){
                this.insanVarmi=false;
                return;
            }
            
            if (this.anlikKat == 0) {
                this.yon = 1;
            } else {
                this.anlikKat--;
            }
        }
        //System.out.println("AVM'den çıkış yapan insan sayısı : "+ this.exitCounter);
    }
    }

}
