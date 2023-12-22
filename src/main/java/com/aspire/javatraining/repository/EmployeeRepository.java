package com.aspire.javatraining.repository;

import com.aspire.javatraining.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {

    private final Map<Long, Employee> employeeMap = new HashMap<>();
    private long idCounter = 1;

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    public Employee getEmployeeById(long id) {
        return employeeMap.get(id);
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(generateId());
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Employee updateEmployee(long id, Employee updatedEmployee) {
        if (employeeMap.containsKey(id)) {
            updatedEmployee.setId(id);
            employeeMap.put(id, updatedEmployee);
            return updatedEmployee;
        }
        return null; // Employee not found
    }

    public boolean deleteEmployee(long id) {
        return employeeMap.remove(id) != null;
    }

    private synchronized long generateId() {
        return idCounter++;
    }
}
