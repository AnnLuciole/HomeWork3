package com.homeWork3.dao;

import com.homeWork3.models.Employee;
import com.homeWork3.models.Project;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(String employeeName) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        sessionFactory.getCurrentSession().persist(employee);
        sessionFactory.getCurrentSession().flush();
    }

    public Employee select(int id) {
        return sessionFactory.getCurrentSession().find(Employee.class, id);
    }

    public List<Employee> selectAll() {
        return sessionFactory.getCurrentSession().
                createQuery("from Employee", Employee.class).
                getResultList();
    }

    public List<Project> selectAllProjectsByEmployeeId(int id) {
        return sessionFactory.getCurrentSession().
                find(Employee.class, id).getAllProjects();
    }

    public Employee delete(int id) {
        Employee emp = select(id);
        sessionFactory.getCurrentSession().remove(id);
        sessionFactory.getCurrentSession().flush();
        return emp;
    }
}
