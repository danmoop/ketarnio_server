package com.danmoop.ketarnio.Main.Controller;

import com.danmoop.ketarnio.Main.DAO.ProjectDAO;
import com.danmoop.ketarnio.Main.DAO.UserDAO;
import com.danmoop.ketarnio.Main.model.Project;
import com.danmoop.ketarnio.Main.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
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

        List<String> admins = new ArrayList<>();
        List<String> members = new ArrayList<>();

        admins.add(principal.getName());
        members.add(principal.getName());

        Project project = new Project(projectName, principal.getName(), members, admins);
        projectDAO.save(project);

        UserModel user = userDAO.findByUsername(principal.getName());
        user.addProject(projectName);
        userDAO.save(user);
    }
}