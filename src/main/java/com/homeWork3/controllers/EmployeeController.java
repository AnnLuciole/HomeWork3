package com.homeWork3.controllers;

import com.homeWork3.models.Employee;
import com.homeWork3.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("employee", employeeService.selectAll());
        return "employee/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.select(id));
        return "employee/show";
    }

    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") Employee employee) {
        return "employee/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("employee") Employee employee,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "employee/new";

        employeeService.add(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeService.select(id));
        return "employee/edit";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect:/employee";
    }
}
