package ht;

public class Szalhasznalo {
    public static void main(String [] args) {
        Pelda3Sajat st = new Pelda3Sajat();

        Thread t = new Thread(st);
        t.start();


        Pelda3Szal st2 = new Pelda3Szal();
        st2.start();

        while (true) {
            System.out.println("Szia-3");
        }
    }
}
