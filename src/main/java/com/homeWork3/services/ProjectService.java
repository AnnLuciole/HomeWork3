package com.homeWork3.services;

import com.homeWork3.dao.ProjectDAO;
import com.homeWork3.models.Employee;
import com.homeWork3.models.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService {

    private final ProjectDAO projectDAO = new ProjectDAO();

    public void add(Project project) {
        projectDAO.add(project);
    }

    public Project select(int id) {
        return projectDAO.select(id);
    }

    public List<Project> selectAll() { return projectDAO.selectAll(); }

    public List<Employee> selectAllEmployeesByProjectId(int id) {
        return projectDAO.selectAllEmployeesByProjectId(id);
    }

    public Project delete(int id) {
        return projectDAO.delete(id);
    }
}
