package com.homeWork3.services;

import com.homeWork3.dao.EmployeeDAO;
import com.homeWork3.models.Employee;
import com.homeWork3.models.Project;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    public Employee select(int id) {
        return employeeDAO.select(id);
    }

    public List<Project> selectAllProjectsByEmployeeId(int id) {
        return employeeDAO.selectAllProjectsByEmployeeId(id);
    }
    public List<Employee> selectAll() {
        return employeeDAO.selectAll();
    }
    public Employee delete(int id) {
        return employeeDAO.delete(id);
    }
}
