package bce.barata.task2.models;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterModel
{
    @Size(min = 6)
    private String name;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{6,}$")
    private String password;
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
}
