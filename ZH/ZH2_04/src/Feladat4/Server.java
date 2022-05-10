package Feladat4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String args[])
    {

        int port;
        ServerSocket server_socket;
        BufferedReader input;
        String no = "Nem szökőév";
        String yes = "Szökőév";

        try
        {
            port = Integer.parseInt(args[0]);
        }
        catch (Exception e)
        {
            System.out.println("port = 1500 (default)");
            port = 2400;
        }

        try
        {

            server_socket = new ServerSocket(port);
            System.out.println("Szerver varakozik a kliensre port:" +
                    server_socket.getLocalPort());

            // szervert egy vegtelen ciklusban elinditjuk
            while (true)
            {
                Socket socket = server_socket.accept();
                System.out.println("Uj kapcsolat elfogadva " +
                        socket.getInetAddress() +
                        ":" + socket.getPort());
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                try
                {
                    while(true)
                    {
                        Integer year = Integer.parseInt(input.readLine());
                        if (year==null) break;
                        if(year % 400 == 0)
                        {
                            System.out.println(yes);
                        } else if (year % 100 == 0)
                        {
                            System.out.println(no);
                        } else if (year % 4 == 0)
                        {
                            System.out.println(yes);
                        }
                    }
                }
                catch (IOException e)
                {
                    System.out.println(e);
                }

                try {
                    socket.close();
                    System.out.println("Kapcsolat lezarasa");
                }
                catch (IOException e) {
                    System.out.println(e);
                }


            }
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}