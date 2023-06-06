package com.homeWork3.controllers;

import com.homeWork3.models.Job;
import com.homeWork3.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/job")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Job>> selectAll() {
        return new ResponseEntity<>(jobService.selectAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> select(@PathVariable("id") int id) {
        return new ResponseEntity<Job>(jobService.select(id), HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public void addJob(@RequestBody String jobTitle) {
        jobService.add(jobTitle);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        jobService.delete(id);
        return "Job was deleted.";
    }
}
