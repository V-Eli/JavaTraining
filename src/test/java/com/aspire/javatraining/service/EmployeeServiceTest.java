package com.aspire.javatraining.service;

import com.aspire.javatraining.model.Employee;
import com.aspire.javatraining.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {

    @Test
    void testGetAllEmployees() {
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);

        List<Employee> expectedEmployees = List.of(
                new Employee("John Doe"),
                new Employee("Jane Doe")
        );

        when(mockRepository.getAllEmployees()).thenReturn(expectedEmployees);

        List<Employee> result = employeeService.getAllEmployees();

        assertNotNull(result);
        assertEquals(expectedEmployees.size(), result.size());
    }

    @Test
    void testGetEmployeeById() {
        EmployeeRepository mockRepository = mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(mockRepository);

        long employeeId = 1L;
        Employee expectedEmployee = new Employee("John Doe");

        when(mockRepository.getEmployeeById(employeeId)).thenReturn(expectedEmployee);

        Employee result = employeeService.getEmployeeById(employeeId);

        assertNotNull(result);
        assertEquals(expectedEmployee.getName(), result.getName());
    }

    // Similar tests for addEmployee, updateEmployee, and deleteEmployee methods
}