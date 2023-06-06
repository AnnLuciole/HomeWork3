package com.homeWork3.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.homeWork3.models.Project;
import com.homeWork3.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public List<Project> selectAll() {
        return projectService.selectAll();
    }

    @GetMapping("/{id}")
    public Project select(@PathVariable(value = "id") int id) {
        return projectService.select(id);
    }
    @GetMapping("/add")
    public String addProject(Project project) {
        projectService.add(project);
        return "Project was added.";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") int id) {
        projectService.delete(id);
        return "Project was deleted.";
    }
}
