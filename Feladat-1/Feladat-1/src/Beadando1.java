// Készítsen egy egyszerű titkosítást lehetővé alkalmazást, amely egy szöveges állományban a karaktereket a rákövetkezőre cseréli ki. (Pl alma bmnb) 
// Az alkalmazástól elvárjuk, hogy tetszőleges hosszúságú szöveges állományokat képes legyen kezelni.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Beadando1 {
    public static void main(String[] args) throws Exception {
        Scanner usrinp = new Scanner(System.in);
        System.out.println("Add meg a fájl elérési útvonalát!");
        String inptFilePath = usrinp.nextLine().toString();
        System.out.println(inptFilePath);
        FileInputStream inpFile = new FileInputStream(inptFilePath);
        DataInputStream inpData = new DataInputStream(inpFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(inpData));
        File fout = new File("out.txt");
        FileOutputStream outstream = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outstream));

        String inptLine;

        while ((inptLine = br.readLine()) != null) {
            char [] inptLineChar = inptLine.toCharArray();
            System.out.println(inptLineChar.toString());
            char [] topsecret = new char[inptLineChar.length];
            for (int i = 0; i < inptLineChar.length; i++) {
                if (inptLineChar[i] == ' ') {
                    topsecret[i] = inptLineChar[i];
                    System.out.println("space");                  
                }
                else {
                    int ascival = inptLineChar[i] + 1;
                    topsecret[i] = (char)ascival;
                    System.out.println(topsecret[i]);
                }

            }
            System.out.println(topsecret);
            bw.write(topsecret);
            //bw.newLine();
        }

        bw.close();
        inpData.close();
        usrinp.close();
    }
}
