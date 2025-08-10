package com.employee.employee.service;

import com.employee.employee.dao.EmployeeDao;
import com.employee.employee.entity.Employee;
import com.employee.employee.request.EmployeeRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
       return employeeDao.findAll();
    }

    @Override
    public Employee findById(long theId){
        Employee theEmployee = employeeDao.findById(theId);
        return theEmployee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest){
        Employee theEmployee = convertToEmployee(0, employeeRequest);
        return employeeDao.save(theEmployee);
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest){
        Employee theEmployee = convertToEmployee(id, employeeRequest);
        return employeeDao.save(theEmployee);
    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest){
        return new Employee(id, employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getEmail());
    }

    @Transactional
    @Override
    public void deleteById(long theId){
        employeeDao.deleteById(theId);
    }

}
