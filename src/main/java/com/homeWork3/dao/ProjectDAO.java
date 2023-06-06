package com.homeWork3.dao;

import com.homeWork3.models.Employee;
import com.homeWork3.models.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ProjectDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(String projectTitle) {
        Project project = new Project();
        project.setProjectTitle(projectTitle);
        sessionFactory.getCurrentSession().persist(project);
        sessionFactory.getCurrentSession().flush();
    }

    public Project select(int id) {
        return sessionFactory.getCurrentSession().find(Project.class, id);
    }

    public List<Project> selectAll() {
        return sessionFactory.getCurrentSession().createQuery("from Project", Project.class).getResultList();
    }

    public List<Employee> selectAllEmployeesByProjectId(int id) {
        return sessionFactory.getCurrentSession().find(Project.class, id).getAllEmployees();
    }

    public Project delete(int id) {
        Project project = select(id);
        sessionFactory.getCurrentSession().remove(project);
        sessionFactory.getCurrentSession().flush();
        return project;
    }
}
