package com.aspire.javatraining.controller;

import com.aspire.javatraining.model.Employee;
import com.aspire.javatraining.service.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {

    @Test
    void testViewAllEmployees() {
        EmployeeService mockService = mock(EmployeeService.class);
        EmployeeController employeeController = new EmployeeController(mockService);

        List<Employee> expectedEmployees = List.of(
                new Employee("John Doe"),
                new Employee("Jane Doe")
        );

        when(mockService.getAllEmployees()).thenReturn(expectedEmployees);

        // Assuming a display method that prints employees to console
        employeeController.viewAllEmployees();

        // Verify that the service method was called
        verify(mockService).getAllEmployees();
    }

    // Similar tests for viewEmployeeById, addEmployee, updateEmployee, and deleteEmployee methods
}