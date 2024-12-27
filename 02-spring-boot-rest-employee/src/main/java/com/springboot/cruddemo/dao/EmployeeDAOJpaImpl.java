package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager=theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee",
                Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the students
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // return the employee
        return theEmployee;

    }

    @Override
    public Employee save(Employee theEmployee) {

        // save the employee

        // if id==0 then insert/update

        // return the saved employee
        return entityManager.merge(theEmployee);
    }

    /*
    @Override
    public void Update(Employee theEmployee) {
        entityManager.merge(theEmployee);
    }
     */

    /*
    @Override
    public void saveEmployee(Employee theEmployee) {
        entityManager.persist(theEmployee);
    }
     */

    @Override
    public void deleteById(int theId) {
        // find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId);

        // remove the employee from the database
        entityManager.remove(theEmployee);
    }
}
