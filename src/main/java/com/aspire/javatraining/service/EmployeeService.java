package com.aspire.javatraining.service;

import com.aspire.javatraining.model.Employee;
import com.aspire.javatraining.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.getEmployeeById(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public void updateEmployee(long id, Employee updatedEmployee) {
        employeeRepository.updateEmployee(id, updatedEmployee);
    }

    public boolean deleteEmployee(long id) {
        return employeeRepository.deleteEmployee(id);
    }
}