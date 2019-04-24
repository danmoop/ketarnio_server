package com.danmoop.ketarnio.Main.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(value = "projects")
public class Project
{
    private String projectName;
    private String creatorName;
    private List<String> members;
    private List<String> admins;

    public Project(String projectName, String creatorName, List<String> members, List<String> admins)
    {
        this.projectName = projectName;
        this.creatorName = creatorName;
        this.members = members;
        this.admins = admins;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getCreatorName()
    {
        return creatorName;
    }

    public void setCreatorName(String creatorName)
    {
        this.creatorName = creatorName;
    }

    public List<String> getMembers()
    {
        return members;
    }

    public void setMembers(List<String> members)
    {
        this.members = members;
    }

    public List<String> getAdmins()
    {
        return admins;
    }

    public void setAdmins(List<String> admins)
    {
        this.admins = admins;
    }
}