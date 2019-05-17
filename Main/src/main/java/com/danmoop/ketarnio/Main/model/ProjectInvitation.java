package com.danmoop.ketarnio.Main.model;

public class ProjectInvitation
{
    private String projectName;
    private String author;
    private String timeStamp;

    public ProjectInvitation(String projectName, String author, String timeStamp)
    {
        this.projectName = projectName;
        this.author = author;
        this.timeStamp = timeStamp;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getAuthor() {
        return author;
    }

    public String getTimeStamp() {
        return timeStamp;
    }
}