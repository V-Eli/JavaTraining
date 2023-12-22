package com.aspire.javatraining.controller;
import com.aspire.javatraining.model.Employee;
import com.aspire.javatraining.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void displayMenu() {
        System.out.println("Employee Management System");
        System.out.println("1. View All Employees");
        System.out.println("2. View Employee by ID");
        System.out.println("3. Add Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewAllEmployees();
                    break;
                case 2:
                    viewEmployeeById();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    deleteEmployee();
                    break;
                case 0:
                    System.out.println("Exiting the Employee Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public void viewAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        employees.forEach(System.out::println);
    }

    private void viewEmployeeById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        long id = scanner.nextLong();

        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        Employee employee = new Employee(name);
        employeeService.addEmployee(employee);

        System.out.println("Employee added successfully.");
    }

    private void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        long id = scanner.nextLong();
        // Consume the newline character
        scanner.nextLine();
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee != null) {
            System.out.print("Enter new employee name: ");
            String newName = scanner.nextLine();

            existingEmployee.setName(newName);
            employeeService.updateEmployee(id, existingEmployee);

            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        long id = scanner.nextLong();

        if (employeeService.deleteEmployee(id)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}