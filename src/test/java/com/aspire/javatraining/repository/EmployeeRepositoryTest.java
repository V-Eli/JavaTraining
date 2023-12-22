package com.aspire.javatraining.repository;

import com.aspire.javatraining.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {

    @Test
    void testAddAndGetEmployee() {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        Employee employeeToAdd = new Employee("John Doe");
        Employee addedEmployee = employeeRepository.addEmployee(employeeToAdd);

        Employee retrievedEmployee = employeeRepository.getEmployeeById(addedEmployee.getId());
        assertNotNull(retrievedEmployee);
        assertEquals(addedEmployee.getId(), retrievedEmployee.getId());
        assertEquals(addedEmployee.getName(), retrievedEmployee.getName());
    }

    @Test
    void testUpdateEmployee() {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        Employee employeeToAdd = new Employee("Jane Doe");
        Employee addedEmployee = employeeRepository.addEmployee(employeeToAdd);

        Employee updatedEmployee = new Employee("Updated Name");
        Employee result = employeeRepository.updateEmployee(addedEmployee.getId(), updatedEmployee);

        assertNotNull(result);
        assertEquals(updatedEmployee.getName(), result.getName());
    }

    @Test
    void testDeleteEmployee() {
        EmployeeRepository employeeRepository = new EmployeeRepository();

        Employee employeeToAdd = new Employee("Jack Doe");
        Employee addedEmployee = employeeRepository.addEmployee(employeeToAdd);

        boolean isDeleted = employeeRepository.deleteEmployee(addedEmployee.getId());

        assertTrue(isDeleted);

        Employee retrievedEmployee = employeeRepository.getEmployeeById(addedEmployee.getId());
        assertNull(retrievedEmployee);
    }
}
