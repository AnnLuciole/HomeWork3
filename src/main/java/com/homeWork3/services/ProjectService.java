package com.homeWork3.services;

import com.homeWork3.dao.ProjectDAO;
import com.homeWork3.models.Employee;
import com.homeWork3.models.Project;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    private final ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public void add(String projectTitle) {
        projectDAO.add(projectTitle);
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
