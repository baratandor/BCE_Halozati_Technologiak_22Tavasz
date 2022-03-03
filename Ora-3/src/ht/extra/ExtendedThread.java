package ht.extra;

class MyThread extends Thread {
  public void run() {
    System.out.println("Hello, ez itt a " + getName() + " Thread" );
  }
}

public class ExtendedThread {
  static public void main(String args[]) {
    MyThread a, b;

    a = new MyThread();
    b = new MyThread();
    a.start();
    b.start();
  }
}


