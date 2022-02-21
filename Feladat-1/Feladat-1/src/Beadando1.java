// Készítsen egy egyszerű titkosítást lehetővé alkalmazást, amely egy szöveges állományban a karaktereket a rákövetkezőre cseréli ki. (Pl alma bmnb) 
// Az alkalmazástól elvárjuk, hogy tetszőleges hosszúságú szöveges állományokat képes legyen kezelni.

import java.util.Scanner;

public class Beadando1 {
    public static void main(String[] args) throws Exception {
        Scanner inptObj = new Scanner(System.in);
        System.out.println("Add meg a titkosítandó szót!");

        char[] inpword = inptObj.nextLine().toCharArray();
        char[] topsecret = new char[inpword.length];
        
        for (int i = 0; i < inpword.length; i++) {
            int ascival = inpword[i] + 1;
            topsecret[i] = (char)ascival;            
          }
        System.out.println(topsecret);
        inptObj.close();

    }
}
