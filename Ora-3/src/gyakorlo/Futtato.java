package gyakorlo;

public class Futtato {
    public static void main(String [] args) {
        //Feladat1 st = new Feladat1();

        Thread t1 = new Thread(new Feladat1("szal1"));
        Thread t2 = new Thread(new Feladat1("szal2"));
        Thread t3 = new Thread(new Feladat1("szal3"));
        Thread t4 = new Thread(new Feladat1("szal4"));
        Thread t5 = new Thread(new Feladat1("szal5"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
