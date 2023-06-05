package com.homeWork3.models;

import javax.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int id;

    @Column(name = "project_title", nullable = false)
    private String projectTitle;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "project_employees",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "employee_id") }
    )
    private List<Employee> allEmployees = new ArrayList<>();
}
