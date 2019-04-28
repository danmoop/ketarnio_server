package com.danmoop.ketarnio.Main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(value = "projects")
public class Project
{
    @Id
    private String id;

    private String projectName;
    private String creatorName;
    private int budget;
    private List<String> members;
    private List<String> admins;
    private ProjectNotification projectNotification;
    private List<Task> activeTasks;
    private List<Task> completedTasks;
    private List<InboxMessage> messages;

    public Project(String projectName, String creatorName, List<String> members, List<String> admins, int budget)
    {
        this.projectName = projectName;
        this.creatorName = creatorName;
        this.members = members;
        this.admins = admins;
        this.budget = budget;

        this.projectNotification = null;

        this.activeTasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
        this.messages = new ArrayList<>();
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

    public int getBudget()
    {
        return budget;
    }

    public void setBudget(int budget)
    {
        this.budget = budget;
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

    public ProjectNotification getProjectNotification()
    {
        return projectNotification;
    }

    public void setProjectNotification(ProjectNotification projectNotification)
    {
        this.projectNotification = projectNotification;
    }

    public List<Task> getActiveTasks()
    {
        return activeTasks;
    }

    public void setActiveTasks(List<Task> activeTasks)
    {
        this.activeTasks = activeTasks;
    }

    public List<Task> getCompletedTasks()
    {
        return completedTasks;
    }

    public void setCompletedTasks(List<Task> completedTasks)
    {
        this.completedTasks = completedTasks;
    }

    public List<InboxMessage> getMessages()
    {
        return messages;
    }

    public void setMessages(List<InboxMessage> messages)
    {
        this.messages = messages;
    }
}