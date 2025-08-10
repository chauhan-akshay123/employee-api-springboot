package com.employee.employee.service;

import com.employee.employee.entity.Employee;
import com.employee.employee.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(long theId);

  Employee save(EmployeeRequest theEmployeeRequest);

  Employee update(long id, EmployeeRequest employeeRequest);

  Employee convertToEmployee(long id, EmployeeRequest employeeRequest);

  void deleteById(long theId);

}
