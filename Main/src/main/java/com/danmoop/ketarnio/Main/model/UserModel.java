package com.danmoop.ketarnio.Main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "users")
public class UserModel
{
    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private String timeStamp;
    private String role;
    private List<InboxMessage> messages;

    public UserModel() {}

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

    public String getRole()
    {
        return role;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public List<InboxMessage> getMessages()
    {
        return messages;
    }

    public void setMessages(List<InboxMessage> messages)
    {
        this.messages = messages;
    }

    public void addInboxMessage(InboxMessage message)
    {
        messages.add(message);
    }

    public void removeMessage(InboxMessage message)
    {
        messages.remove(message);
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public boolean areFieldsEmpty()
    {
        return username.equals("") && email.equals("");
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
        return "UserModel{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}