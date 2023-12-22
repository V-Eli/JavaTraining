package com.aspire.javatraining; // Name of the Package

//Imports of all packages used in the Main Application. Model of all components are not imported
import com.aspire.javatraining.repository.EmployeeRepository;
import com.aspire.javatraining.service.EmployeeService;
import com.aspire.javatraining.controller.EmployeeController;

public class Main {

    public static void main(String[] args) {
        // Initialize components
        EmployeeRepository employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        EmployeeController employeeController = new EmployeeController(employeeService);

        // Start the application
        employeeController.processUserInput();
    }
}