package com.homeWork3.controllers;

import com.homeWork3.models.Job;
import com.homeWork3.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/job/")
    public List<Job> selectAll() {
        return jobService.selectAll();
    }

    @GetMapping("/job/{id}")
    public Job select(@PathVariable("id") int id) {
        return jobService.select(id);
    }

    @PostMapping("/job/add")
    public String addJob(Job job) {
        jobService.add(job);
        return "Job was added.";
    }

    @DeleteMapping("/job/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        jobService.delete(id);
        return "Job was deleted.";
    }
}
