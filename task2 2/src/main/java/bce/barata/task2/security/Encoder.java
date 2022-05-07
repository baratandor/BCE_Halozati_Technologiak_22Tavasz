package bce.barata.task2.security;

import bce.barata.task2.models.ReturnValues;
import bce.barata.task2.repository.UserRepository;
import org.springframework.context.annotation.Bean;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class Encoder
{
    @Bean
    public static String CustomEncoder(String password, byte[] saltInput) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        SecureRandom sr = new SecureRandom();
        byte salt[] = saltInput;

        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 10, 512);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] hash = secretKeyFactory.generateSecret(keySpec).getEncoded();
        String output = Base64.getMimeEncoder().encodeToString(hash);

        return output;
    }

    public static ReturnValues CustomEncoder(String password) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        ReturnValues rv = new ReturnValues();
        SecureRandom sr = new SecureRandom();
        byte salt[] = new byte[16];

        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, 10, 512);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] hash = secretKeyFactory.generateSecret(keySpec).getEncoded();
        String output = Base64.getMimeEncoder().encodeToString(hash);

        rv.setPassword(output);
        rv.setSalt(salt);

        return rv;
    }
}
