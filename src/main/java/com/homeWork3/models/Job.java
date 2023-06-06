package com.homeWork3.models;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int id;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @OneToMany(mappedBy = "job", fetch = FetchType.EAGER)
    private List<Employee> allEmployees = new ArrayList<>();
}
