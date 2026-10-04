package com.example.employee_management.repository;

import com.example.employee_management.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        employees.add(new Employee(1, "Samarth", 30000));
        employees.add(new Employee(2, "Rahul", 35000));
        employees.add(new Employee(3, "Amit", 40000));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    public void saveEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean deleteEmployee(int id){
        for(Employee employee:employees){
            if(employee.getId()==id){
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }

    public boolean updateEmployee(int id, Employee updateEmployee){
        for(Employee employee:employees){
            if(employee.getId()==id){
                employee.setName(updateEmployee.getName());
                employee.setSalary(updateEmployee.getSalary());
                return true;
            }
        }
        return false;
    }
}