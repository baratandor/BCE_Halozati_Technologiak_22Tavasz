package ht;

class Pelda3 {
    public static void main(String [] args) { 
       MyThread3 t = new MyThread3();
       t.start();
    }
}
class MyThread3 extends Thread {
	public void run() { while (true) { System.out.println("Szia!\n"); } }
}
