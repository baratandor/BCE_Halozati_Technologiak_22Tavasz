package ht;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class EgyszeruSzerver {

    public static void main(String [] args){
        try {
            ServerSocket ss = new ServerSocket(1234);            
            while (true) {
                Socket s = ss.accept();

                String hellow = "Hello!";
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                pw.println(hellow);

                
                Calendar c = Calendar.getInstance();
                String datum = c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE);
                pw.print(datum);

                pw.flush();
                pw.close();
                s.close();
                //ss.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
