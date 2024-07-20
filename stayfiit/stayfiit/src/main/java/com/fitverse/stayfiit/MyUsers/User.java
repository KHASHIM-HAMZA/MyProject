package com.fitverse.stayfiit.MyUsers;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private String UserName;
    private String Email;
    private String Password;


    public User() {
    }

    public User(Long id, String userName, String email, String password) {
        Id = id;
        UserName = userName;
        Email = email;
        Password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", UserName='" + UserName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
