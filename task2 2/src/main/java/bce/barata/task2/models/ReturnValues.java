package bce.barata.task2.models;

public class ReturnValues
{
    private String password;
    private byte[] salt;

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    public byte[] getSalt(){return salt;}
    public void setSalt(byte[] salt){this.salt = salt;}
}
