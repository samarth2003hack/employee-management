package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = service.getEmployeeById(id);

        if (employee != null) {
            return ResponseEntity.ok(employee);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
       Employee savedEmployee= service.createEmployee(employee);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpoyee(@PathVariable int id){
        boolean deleted = service.deleteEmployee(id);
        if(deleted){
            return ResponseEntity.ok("Employee deleted successfully !");
        }
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee updateEmployee){
        boolean updated = service.updateEmployee(id,updateEmployee);

        if(updated){
            return ResponseEntity.ok("Employee updated sucessfully !");
        }
        return ResponseEntity.notFound().build();
    }
}