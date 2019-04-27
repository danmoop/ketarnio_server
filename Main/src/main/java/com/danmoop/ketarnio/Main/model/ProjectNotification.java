package com.danmoop.ketarnio.Main.model;

public class ProjectNotification
{
    private String author;
    private String text;
    private String timeStamp;

    public ProjectNotification(String author, String text, String timeStamp)
    {
        this.author = author;
        this.text = text;
        this.timeStamp = timeStamp;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp = timeStamp;
    }
}