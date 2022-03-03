package ht.extra;

// Race Condition alap problema
import java.io.*;

class LogIro {                               // A kritikus resz
  private FileWriter logfile;

  public void message( String msg ) {
    try {                                    // File nyitas
      logfile = new FileWriter( "race1.log", true );
    } catch (IOException e) {                // Hiba kezeles
      System.out.println( "Error: " + e.getMessage() ); 
      System.exit(1); 
    }
    try {                                    // iras a file-ba
      logfile.write( msg );
    } catch (IOException e) {                // Hiba kezeles 
      System.out.println( "Error: " + e.getMessage() ); 
      System.exit(2); 
    }
    try {                                    // File bezaras
      logfile.close();
    } catch (IOException e) {                // Hiba kezeles
      System.out.println( "Error: " + e.getMessage() ); 
      System.exit(3); 
    }
  }
}

class TextSzal extends Thread {              // Szal, ami irogat a
  private LogIro lf;                         // log file-ba

  TextSzal( LogIro lf, String ID) {
    super(ID);      this.lf = lf;
  }

  public void run() {
    while (true) {
      lf.message( getName() );              // Kiirja a nevet es
      lf.message( " fut\n" );                 // az allapotot
    }
  }
}

public class Versenges1 {
  public static void main(String args[]) {
    LogIro log = new LogIro();              // Log file def.
    TextSzal t1 = new TextSzal( log, "1. szal" ),
             t2 = new TextSzal( log, "2. szal" );
    t1.start();
    t2.start();
  }
}
