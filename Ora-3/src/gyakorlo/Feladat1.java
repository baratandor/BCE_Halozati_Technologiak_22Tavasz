package gyakorlo;


public class Feladat1 implements Runnable{

    String name = "default";

    public Feladat1(String s) {
        this.name = s;
    }


    public void run() {
        //ciklus, pénzdobás, ellenőrzés 3+ fejnek }
        
        int dbfejek = 0;
        for (int i = 0; i < 1000; i++) {
            if(Math.random() < 0.5) {
                dbfejek++;
            } else {
                dbfejek = 0;
            }
            if (dbfejek >= 3) {
                System.out.println(this.name + " - A sorban kidobott fejek szama: " + dbfejek);
            }
        }

    }
}
