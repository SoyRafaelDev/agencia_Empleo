package com.rafaelgonzalez.application.resource;

import com.rafaelgonzalez.application.model.Employee;
import com.rafaelgonzalez.application.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/api/employees")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "mySQLEmployee")EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees (){
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee (@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.findByEmployee(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee){
        //employee.setId(employeeService.getEmployees().size() + 1); la uso para el test en memoria interna
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee (@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.deleteById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee (@PathVariable("id") Integer id, @RequestBody Employee employee){
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    protected static URI getLocation(Integer id) {
        return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
