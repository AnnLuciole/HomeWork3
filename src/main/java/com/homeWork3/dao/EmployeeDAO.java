package com.homeWork3.dao;

import com.homeWork3.models.Employee;
import com.homeWork3.models.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Employee employee) {
        entityManager.persist(employee);
        entityManager.flush();
    }

    public Employee select(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> selectAll() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    public List<Project> selectAllProjectsByEmployeeId(int id) {
        return entityManager.find(Employee.class, id).getAllProjects();
    }

    public Employee delete(int id) {
        Employee emp = select(id);
        entityManager.remove(id);
        entityManager.flush();
        return emp;
    }
}
