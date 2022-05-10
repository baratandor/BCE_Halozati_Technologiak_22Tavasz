package edu.corvinus.ZH2_03.model;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterModel
{
    @Email(message = "Nem e-mail cím!", regexp = "^(.+)@(\\S+) $.")
    @Pattern(regexp = "^(.+)@(\\S+) $.")
    @NotNull
    @Size(min = 3)
    @Valid
    private String name;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z]{5,}$")
    @NotNull
    @Size(min = 5)
    @Valid
    private String password;
    @NotNull
    private String password2;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword2()
    {
        return password2;
    }

    public void setPassword2(String password2)
    {
        this.password2 = password2;
    }

    public RegisterModel(String email, String password, String password2)
    {
        this.name = email;
        this.password = password;
        this.password2 = password2;
    }
    public RegisterModel(){}
}
