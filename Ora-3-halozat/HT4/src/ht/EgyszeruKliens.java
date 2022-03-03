package ht;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class EgyszeruKliens {
    public static void main(String [] args) {
        //Socket s = new Socket("146.110.132.227",123456);
        try {
            Socket s = new Socket("127.0.0.1", 1234);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String hellomsg = bfr.readLine();
            System.out.println(hellomsg);

            hellomsg = bfr.readLine();
            System.out.println(hellomsg);

            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}