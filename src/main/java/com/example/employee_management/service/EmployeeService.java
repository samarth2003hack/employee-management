package com.example.employee_management.service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return repository.getEmployeeById(id);
    }

    public void createEmployee(Employee employee) {
        repository.saveEmployee(employee);
    }

    public boolean deleteEmployee(int id){
        return repository.deleteEmployee(id);
    }
}