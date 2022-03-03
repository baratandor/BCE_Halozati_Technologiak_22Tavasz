package ht;

public class EgyszeruSzamolasMod extends Thread {
  static int n = 1;                          // Osztaly szintu szamlalo
  static Object kritikusResz = new Object();// Egy objektum segitsegevel

  public void run() {
    for (int i=1; i<=40; i++) {
      synchronized (kritikusResz) {         // szinkronizalunk
        System.out.print(n + " ");           // kiirjuk, majd
        n++;                                 // noveljuk
      }                                      // Szinkronizacios blokk vege
    }
  }
    
  public static void main(String args[]) {
    Thread thr1 = new EgyszeruSzamolasMod(),        // Ket szalat letrehozunk,
           thr2 = new EgyszeruSzamolasMod();
    thr1.start();                                    // majd elindutunk
    thr2.start();
  }
}