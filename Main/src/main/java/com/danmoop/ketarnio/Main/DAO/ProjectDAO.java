package com.danmoop.ketarnio.Main.DAO;

import com.danmoop.ketarnio.Main.Interface.ProjectInterface;
import com.danmoop.ketarnio.Main.Service.ProjectService;
import com.danmoop.ketarnio.Main.model.Project;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProjectDAO implements ProjectInterface
{
    @Autowired
    private ProjectService projectService;

    @Override
    public List<Project> findAll()
    {
        return projectService.findAll();
    }

    @Override
    public Project findByProjectName(String projectName)
    {
        return projectService.findByProjectName(projectName);
    }
}