package com.employee.employee.dao;

import com.employee.employee.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(long theId);

    Employee save(Employee theEmployee);

    void deleteById(long theId);
}
