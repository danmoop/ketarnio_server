package com.danmoop.ketarnio.Main.model;

public class InboxMessage
{
    private String author;
    private String content;
    private String timeStamp;

    public InboxMessage() {}

    public InboxMessage(String author, String content, String timeStamp)
    {
        this.author = author;
        this.content = content;
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

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
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
