package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    // get a single employee by id
    Employee findById(int theId);

    // save a new employee
    Employee save(Employee theEmployee);

  //  void saveEmployee(Employee theEmployee);

  //  void Update(Employee theEmployee);

    // delete employee by id
    void deleteById(int theId);
}
