package com.rafaelgonzalez.application.service;

import com.rafaelgonzalez.application.model.Employee;

import java.util.List;

public interface EmployeeService {
    //Save employee
    Employee addEmployee(Employee employee);

    //Get employee
    List<Employee> getEmployees();

    //Get one employee
    Employee findByEmployee(Integer id);

    //Update employee
    Employee updateEmployee(Integer id, Employee employee);

    //Delete employee
    Boolean deleteById(Integer id);
}
