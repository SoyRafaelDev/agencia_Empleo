package com.rafaelgonzalez.application.service.impl;

import com.rafaelgonzalez.application.model.Employee;
import com.rafaelgonzalez.application.repository.JpaEmployeeRepository;
import com.rafaelgonzalez.application.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "mySQLEmployee")
public class JpaEmployeeServiceImp implements EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee findByEmployee(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        return jpaEmployeeRepository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setFirstName(employee.getFirstName());
                    existingEmployee.setLastName(employee.getLastName());
                    existingEmployee.setEmail(employee.getEmail());
                    return jpaEmployeeRepository.save(existingEmployee);
                })
                .orElseThrow();
    }

    @Override
    public Boolean deleteById(Integer id) {
        jpaEmployeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
