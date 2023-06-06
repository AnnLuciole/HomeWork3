package com.homeWork3.controllers;

import com.homeWork3.models.Employee;
import com.homeWork3.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> selectAll() {
        return employeeService.selectAll();
    }

    @GetMapping("/{id}")
    public Employee select(@PathVariable("id") int id) {
        return employeeService.select(id);
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.add(employee);
        return "Employee was added.";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "Employee was deleted.";
    }
}
