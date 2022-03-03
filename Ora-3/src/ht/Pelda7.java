package ht;

class Pelda7 {
    public static void main(String [] args) { 
      (new Thread(new MyRunnable())).start();    }
}

class MyRunnable implements Runnable {
	public void run() { while (true) { 
         System.out.println("Szia!\n"); } 
     }
}
