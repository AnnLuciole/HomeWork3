package com.homeWork3.services;

import com.homeWork3.dao.JobDAO;
import com.homeWork3.models.Employee;
import com.homeWork3.models.Job;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobService {

    private final JobDAO jobDAO = new JobDAO();

    public void add(Job job) {
        jobDAO.add(job);
    }

    public Job select(int id) {
        return jobDAO.select(id);
    }

    public List<Job> selectAll() { return jobDAO.selectAll();}

    public List<Employee> selectAllEmployeesByJobId(int id) {
        return jobDAO.selectAllEmployeesByJobId(id);
    }

    public void delete(int id) {
        jobDAO.delete(id);
    }
}
