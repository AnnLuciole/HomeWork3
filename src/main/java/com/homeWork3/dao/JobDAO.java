package com.homeWork3.dao;

import com.homeWork3.models.Employee;
import com.homeWork3.models.Job;
import com.homeWork3.models.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JobDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Job job) {
        entityManager.persist(job);
        entityManager.flush();
    }

    public Job select(int id) {
        return entityManager.find(Job.class, id);
    }

    public List<Job> selectAll() {
        return entityManager.createQuery("from Job", Job.class).getResultList();
    }

    public List<Employee> selectAllEmployeesByJobId(int id) {
        return entityManager.find(Job.class, id).getAllEmployees();
    }

    public Job delete(int id) {
        Job job = select(id);
        entityManager.remove(job);
        entityManager.flush();
        return job;
    }
}
