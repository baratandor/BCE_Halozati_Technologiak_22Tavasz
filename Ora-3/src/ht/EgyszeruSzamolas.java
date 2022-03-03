package ht;

public class EgyszeruSzamolas extends Thread {
  static int n = 1;                          // Oszt�ly szint� sz�ml�l�

  public void run() {
    for (int i=1; i<=40; i++) {
      System.out.print(n + " ");             // kiirjuk, majd
      n++;                                   // noveljük
    }
  }
    
  public static void main(String args[]) {
    Thread thr1 = new EgyszeruSzamolas(),    // Ket szalat letrehozunk,
           thr2 = new EgyszeruSzamolas();
    thr1.start();                            // majd elinditunk
    thr2.start();
  }
}


