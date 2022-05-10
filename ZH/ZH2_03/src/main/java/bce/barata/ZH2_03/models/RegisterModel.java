package bce.barata.ZH2_03.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class RegisterModel
{
    @Size(min = 3, message = "Minimum 3 karakter hossz szükséges!")
    @Email(message = "Nem valódi e-mail cím!"/*, regexp = "^(.+)@(\\S+) $."*/)
    private String name;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{6,}$",message = "Tartalmaznia kell kis- és nagybetűt!")
    private String password;

    private String password2;
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    public String getPassword2(){return password2;}
    public void setPassword2(String password2){this.password2 = password2;}
}
