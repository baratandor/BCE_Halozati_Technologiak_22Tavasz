package bce.barata.task2.security;

import org.springframework.context.annotation.Bean;

public class Encoder
{
    @Bean
    public static String CustomEncoder(String password)
    {
        char[] inpword = password.toCharArray();
        char[] topsecret = new char[inpword.length];

        for (int i = 0; i < inpword.length; i++)
        {
            int ascival = inpword[i] + 1;
            topsecret[i] = (char)ascival;
        }

        String output = topsecret.toString();
        System.out.println("ez "+topsecret.toString());
        System.out.println("ez "+inpword.toString());
        System.out.println("ez "+password);

        return output;
    }
}
