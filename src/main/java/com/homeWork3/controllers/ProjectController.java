package com.homeWork3.controllers;

import com.homeWork3.models.Project;
import com.homeWork3.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping({"", "/", "list"})
    public List<Project> showAllProjects() {
        return projectService.selectAll();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable(value = "id", required = true) int id, Model model,
                       RedirectAttributes attributes) {
        model.addAttribute("person", projectService.select(id));
        return "list";
    }

    @GetMapping("/new")
    public String newProject(@ModelAttribute("project") Project project) {
        return "form";
    }

    @PostMapping()
    public String create(@ModelAttribute("project") @Valid Project project, BindingResult bindingResult,
                           RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        projectService.add(project);
        attributes.addFlashAttribute("flashMessage",
                "Project " + project.getProjectTitle() + " successfully created!");
        return "redirect:/project";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("job", projectService.select(id));
        return "project/edit";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@RequestParam(value = "id", required = true, defaultValue = "") int id,
                         RedirectAttributes attributes) {
        Project project = projectService.delete(id);
        attributes.addFlashAttribute("flashMessage", (null == project) ?
                "Project are not exists!" :
                "Project " + project.getProjectTitle() + " successfully deleted!");
        return "redirect:/project";
    }
}
