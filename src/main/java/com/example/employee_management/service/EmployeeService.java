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
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void createEmployee(Employee employee) {
        repository.save(employee);
    }

    public boolean deleteEmployee(int id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    public boolean updateEmployee(int id, Employee updateEmployee) {

        if (repository.existsById(id)) {

            updateEmployee.setId(id);
            repository.save(updateEmployee);

            return true;
        }

        return false;
    }
}