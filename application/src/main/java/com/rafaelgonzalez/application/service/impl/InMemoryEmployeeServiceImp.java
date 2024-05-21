package com.rafaelgonzalez.application.service.impl;

import com.rafaelgonzalez.application.model.Employee;
import com.rafaelgonzalez.application.repository.InMemoryEmployeeRepository;
import com.rafaelgonzalez.application.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Qualifier(value = "inMemory")
public class InMemoryEmployeeServiceImp implements EmployeeService {
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
         return inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return inMemoryEmployeeRepository.getEmployees();
    }

    @Override
    public Employee findByEmployee(Integer id) {
        return inMemoryEmployeeRepository.findByEmployee(id);
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
       return inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return inMemoryEmployeeRepository.deleteById(id);
    }
}
