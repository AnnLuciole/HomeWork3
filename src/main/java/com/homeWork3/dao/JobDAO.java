package com.homeWork3.dao;

import com.homeWork3.models.Employee;
import com.homeWork3.models.Job;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public JobDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void add(String jobTitle) {
        Job job = new Job();
        job.setJobTitle(jobTitle);
        sessionFactory.getCurrentSession().persist(job);
        sessionFactory.getCurrentSession().flush();
    }

    public Job select(int id) {
        return sessionFactory.getCurrentSession().find(Job.class, id);
    }

    public List<Job> selectAll() {
        return sessionFactory.getCurrentSession().createQuery("from Job", Job.class).getResultList();
    }

    public List<Employee> selectAllEmployeesByJobId(int id) {
        return sessionFactory.getCurrentSession().find(Job.class, id).getAllEmployees();
    }

    public Job delete(int id) {
        Job job = select(id);
        sessionFactory.getCurrentSession().remove(job);
        sessionFactory.getCurrentSession().flush();
        return job;
    }
}
