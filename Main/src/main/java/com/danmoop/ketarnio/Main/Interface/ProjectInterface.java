package com.danmoop.ketarnio.Main.Interface;

import com.danmoop.ketarnio.Main.model.Project;

import java.util.List;

public interface ProjectInterface
{
    void save(Project project);
    List<Project> findAll();
    Project findByProjectName(String projectName);
    Project findByCreatorName(String creatorName);
}