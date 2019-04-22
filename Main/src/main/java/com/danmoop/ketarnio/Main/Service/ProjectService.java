package com.danmoop.ketarnio.Main.Service;

import com.danmoop.ketarnio.Main.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProjectService extends MongoRepository<Project, String>
{
    Project findByProjectName(String projectName);
    List<Project> findAll();
}