package ht;

class Pelda5 {
    public static void main(String [] args) { 
      (new MyThread5()).start();
      while (true) { System.out.println("Viszlat");}
    }
}

class MyThread5 extends Thread {
	public void run() { while (true) { System.out.println("Szia!\n"); } }
}
