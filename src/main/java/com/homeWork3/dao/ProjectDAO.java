package com.homeWork3.dao;

import com.homeWork3.models.Employee;
import com.homeWork3.models.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Project project) {
        entityManager.persist(project);
        entityManager.flush();
    }

    public Project select(int id) {
        return entityManager.find(Project.class, id);
    }

    public List<Project> selectAll() {
        return entityManager.createQuery("from Project", Project.class).getResultList();
    }

    public List<Employee> selectAllEmployeesByProjectId(int id) {
        return entityManager.find(Project.class, id).getAllEmployees();
    }

    public Project delete(int id) {
        Project project = select(id);
        entityManager.remove(project);
        entityManager.flush();
        return project;
    }
}
