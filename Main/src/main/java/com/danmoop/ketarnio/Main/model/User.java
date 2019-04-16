package com.danmoop.ketarnio.Main.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "users")
public class User
{
    private String username;
    private String email;
    private String password;
    private String timeStamp;

    public User() {}

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}