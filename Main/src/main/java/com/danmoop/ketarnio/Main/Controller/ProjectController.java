package com.danmoop.ketarnio.Main.Controller;

import com.danmoop.ketarnio.Main.DAO.ProjectDAO;
import com.danmoop.ketarnio.Main.DAO.UserDAO;
import com.danmoop.ketarnio.Main.model.InboxMessage;
import com.danmoop.ketarnio.Main.model.Project;
import com.danmoop.ketarnio.Main.model.ProjectNotification;
import com.danmoop.ketarnio.Main.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class ProjectController
{
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ProjectDAO projectDAO;

    @PostMapping("/createProject")
    public void createProject(@RequestBody Object projectNameObject, Principal principal)
    {
        String projectName = Misc.getJSON(projectNameObject).get("text").toString();
        int budget = Integer.parseInt(Misc.getJSON(projectNameObject).get("budget").toString());

        List<String> admins = new ArrayList<>();
        List<String> members = new ArrayList<>();

        admins.add(principal.getName());
        members.add(principal.getName());

        Project project = new Project(projectName, principal.getName(), members, admins, budget);
        projectDAO.save(project);

        UserModel user = userDAO.findByUsername(principal.getName());
        user.addProject(projectName);
        userDAO.save(user);
    }

    @PostMapping("/getProject")
    public Project getProject(Principal principal, @RequestBody Object object)
    {
        UserModel user = userDAO.findByUsername(principal.getName());

        String projectName = Misc.getJSON(object).get("text").toString();

        Project project = projectDAO.findByProjectName(projectName);

        if(project.getMembers().contains(user.getUsername()))
            return project;

        return null;
    }

    @PostMapping("/setProjectNotification")
    public void setNotification(Principal principal, @RequestBody Object object)
    {
        String projectName = Misc.getJSON(object).get("projectName").toString();
        String notificationText = Misc.getJSON(object).get("text").toString();

        System.out.println(object.toString());

        Project project = projectDAO.findByProjectName(projectName);
        UserModel user = userDAO.findByUsername(principal.getName());

        if(project != null && user != null && project.getAdmins().contains(principal.getName()))
        {
            project.setProjectNotification(new ProjectNotification(principal.getName(), notificationText, new Date().toString()));
            projectDAO.save(project);
        }
    }

    @PostMapping("/removeProjectNotification")
    public void removeProjectNotification(Principal principal, @RequestBody Object object)
    {
        String projectName = Misc.getJSON(object).get("projectName").toString();

        Project project = projectDAO.findByProjectName(projectName);

        if(project.getAdmins().contains(principal.getName()))
        {
            project.setProjectNotification(null);
            projectDAO.save(project);
        }
    }

    @PostMapping("/setProjectBudget")
    public Project projectWithNewBudget(Principal principal, @RequestBody Object object)
    {
        String projectName = Misc.getJSON(object).get("projectName").toString();
        long budget = Long.parseLong(Misc.getJSON(object).get("budget").toString());
        String reasonOfChange = Misc.getJSON(object).get("reasonOfChange").toString();

        Project project = projectDAO.findByProjectName(projectName);

        if(project != null && project.getAdmins().contains(principal.getName()))
        {
            InboxMessage inboxMessage = new InboxMessage(
                    principal.getName(), // message author
                    principal.getName() + " has set a new project budget.\nReason of change: " + reasonOfChange + "\nTotal: " + budgetDifference(project.getBudget(), budget), // message content
                    new Date().toString() // when was message created
            );

            project.addMessage(inboxMessage);
            project.setBudget(budget);

            projectDAO.save(project);
        }

        return project; // a modified project sent back to user and replaced instead of the old one
    }

    @PostMapping("/deleteAllInboxMessages")
    public Project project(Principal principal, @RequestBody Object object)
    {
        Project project = projectDAO.findByProjectName(Misc.getJSON(object).get("projectName").toString());

        if(project.getAdmins().contains(principal.getName()))
        {
            project.clearInbox();

            project.addMessage(new InboxMessage(
                    principal.getName(),
                    principal.getName() + " has cleared project inbox",
                    new Date().toString()
            ));

            projectDAO.save(project);
        }

        return project;
    }

    private String budgetDifference(long oldBudget, long newBudget)
    {
        long difference = newBudget - oldBudget;

        if(difference > 0)
            return "+" + difference;
        else
            return String.valueOf(difference);
    }
}