package com.homeWork3.controllers;

import com.homeWork3.models.Project;
import com.homeWork3.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Project>> selectAll() {
        return new ResponseEntity<> (projectService.selectAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> select(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(projectService.select(id), HttpStatus.OK);
    }
    @GetMapping("/add")
    public String addProject(@RequestBody String projectTitle) {
        projectService.add(projectTitle);
        return "Project was added.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        projectService.delete(id);
        return "Project was deleted.";
    }
}
