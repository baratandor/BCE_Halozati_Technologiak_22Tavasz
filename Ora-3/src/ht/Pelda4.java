package ht;

class Pelda4 {
   public static void main(String [] args) {
        (new Thread() {
           public void run() { while (true) { System.out.println("Szia!\n"); } }
         }).start();
   }
}
