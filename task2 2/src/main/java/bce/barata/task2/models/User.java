package bce.barata.task2.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User
{


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Size(min = 6)
    @Column(nullable = false, unique = true)
    private String name;
    private String password;

    public User(long id, String name, String password) {}
    public User() {}
    public User(String name, String password) {}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
    public long getId(){return id;}
    public void setId(long id){this.id = id;}

}
