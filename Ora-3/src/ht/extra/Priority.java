package ht.extra;

// Prioritasok vizsgalata
class MyThread1 extends Thread {
  boolean running = true;
  MyThread1(String name) {
    super(name);
  }

  public void stopp() { running = false; }

  public void run() {
    while (running) {
      System.out.println( getName() ); 
      //yield();
    }
  }
}

public class Priority {
  static public void main(String s[]) {
    MyThread1 a, b, c;
    int var = 50;

    a = new MyThread1("Athread");
    b = new MyThread1("Bthread");
    c = new MyThread1("Cthread");
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

    System.out.println("Start... " + 
                       a.getPriority()+","+b.getPriority()+","+c.getPriority());
    a.start();  b.start(); c.start();

    try { Thread.sleep( var); } catch (InterruptedException e) {}
    b.setPriority(b.getPriority() + 4);
    System.out.println("\nB szal norm+4: " +
                       a.getPriority()+","+b.getPriority()+","+c.getPriority());

    try { Thread.sleep( var); } catch (InterruptedException e) {}
    b.setPriority(b.getPriority() - 8);
    System.out.println("\nB szal norm-4: " +
                       a.getPriority()+","+b.getPriority()+","+c.getPriority());

    try { Thread.sleep( var); } catch (InterruptedException e) {}
    b.setPriority(b.getPriority() + 4);
    System.out.println("\nB szal norm : " +
                       a.getPriority()+","+b.getPriority()+","+c.getPriority());

    try { Thread.sleep( var); } catch (InterruptedException e) {}
    System.out.println("\nStopping...");
    a.stopp(); b.stopp(); c.stopp();
  }
}
