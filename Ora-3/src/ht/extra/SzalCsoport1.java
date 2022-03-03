package ht.extra;

// Szalcsoport infok
class Szal extends Thread {
  Szal(String name) {  super(name); }            // nevet is eltoroljuk
  public void run() {                            // nem csinal semmi
    try {                                        // kuloneset
      for (int i=0; i<5; i++)
        sleep(100);
    } catch (InterruptedException e) {}
  }
}

public class SzalCsoport1 {
  public static void main(String args[]) {
    Szal[] sok_szal = new Szal[15];              // a letrehozando szalak

    for (int i=0; i<15; i++)                     // mindet installaljuk,
      sok_szal[i] = new Szal(i +  ". szál");
    for (int i=0; i<5; i++)                      // de csak 5-ot inditunk el
      sok_szal[2*i].start();

    ThreadGroup aktCsop = Thread.currentThread().getThreadGroup();
    int instNum = aktCsop.activeCount();         // csoportban levok
    Thread[] th = new Thread[instNum];           // referenciakhoz
    int futok = aktCsop.enumerate(th);           // a futok lekerdezese es
                                                 // megszamlalasa
    System.out.println("Nyomkovetesi info:");    // a nyomkovetesi lista
    aktCsop.list();                              // kiirasa
    System.out.println("Csoport Nev: " + aktCsop.getName());
    System.out.println("Peldany #: " + instNum);
    System.out.println("Futok #: " + futok);
    System.out.println("Futok listaja");

    for (int i=0; i<futok; i++)
       System.out.println("\t"+i+". szal: "+th[i].getName());
  }
}
