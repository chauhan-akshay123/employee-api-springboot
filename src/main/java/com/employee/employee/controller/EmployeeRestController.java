package com.employee.employee.controller;

import com.employee.employee.EmployeeApplication;
import com.employee.employee.dao.EmployeeDao;
import com.employee.employee.entity.Employee;
import com.employee.employee.request.EmployeeRequest;
import com.employee.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Rest API Endpoints", description = "Description related to emplyees")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @Operation(summary = "Get all Employees", description = "Retrieves a list of employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @Operation(summary = "Fetch single employee", description = "Get a single employee from database")
    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable @Min(value = 1) long employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        return theEmployee;
    }

    @Operation(summary = "Create a new employee", description = "Add a new employee to database")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @Operation(summary = "Update an employee", description = "Update the details of a current employee")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable @Min(value=1) long employeeId, @Valid @RequestBody EmployeeRequest employeeRequest){
        Employee dbEmployee = employeeService.update(employeeId, employeeRequest);
        return dbEmployee;
    }

    @Operation(summary = "Delete a employee", description = "Remove an employee from the database")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable @Min(value = 1) long employeeId){
        employeeService.deleteById(employeeId);
    }

}
