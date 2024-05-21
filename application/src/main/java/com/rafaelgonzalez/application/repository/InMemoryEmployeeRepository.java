package com.rafaelgonzalez.application.repository;

import com.rafaelgonzalez.application.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee( 1, "Rafael", "Gonzalez",  "od.gonzalez.rafael@gmail.com"));
        DATABASE.add(new Employee( 2, "test1", "tester1",  "test1@gmail.com"));
        DATABASE.add(new Employee( 3, "test2", "tester2",  "tester3@gmail.com"));
    }

    public Employee addEmployee(Employee employee){
        DATABASE.add(employee);
        return employee;
    }

    //Get employee
    public List<Employee> getEmployees(){
        return List.copyOf(DATABASE);
    }

    //Get one employee
    public Employee findByEmployee(Integer id){
        return DATABASE
                .stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
    }

    //Update employee
    public Employee updateEmployee(Employee employee){
        DATABASE
                .stream()
                .filter(emp -> emp.getId().equals(employee.getId()))
                .findFirst()
                .ifPresent(emp -> DATABASE.set(DATABASE.indexOf(emp), employee));
        return employee;
    }

    //Delete employee
    public Boolean deleteById(Integer id){
        Employee employee = DATABASE
                .stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
        DATABASE.remove(employee);
        return TRUE;
    }
}
