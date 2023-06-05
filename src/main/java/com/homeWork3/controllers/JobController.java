package com.homeWork3.controllers;

import com.homeWork3.models.Job;
import com.homeWork3.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/job")
    public List<Job> index() {
        return jobService.selectAll();
    }

    @GetMapping("/job/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("job", jobService.select(id));
        return "job/show";
    }

    @PostMapping("/job/new")
    public String newJob(@ModelAttribute("job") Job job) {
        return "job/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("job") Job job,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "job/new";

        jobService.add(job);
        return "redirect:/job";
    }

    @GetMapping("/job/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("job", jobService.select(id));
        return "job/edit";
    }

    @DeleteMapping("/job/{id}")
    public String delete(@PathVariable("id") int id) {
        jobService.delete(id);
        return "redirect:/job";
    }
}
