package ht;

class Pelda6 {
    public static void main(String [] args) { 
      (new MyThread6()).start();
      while (true) { 
         System.out.println("Viszlat");
         Thread.yield();
       }
    }
}

class MyThread6 extends Thread {
	public void run() { while (true) { System.out.println("Szia!\n"); } }
}
