package com.aspire.javatraining.repository;

import com.aspire.javatraining.model.Employee;

import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    // JDBC connection details
    private static final String URL = "jdbc:mysql://localhost:3306/java";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                // Set other employee properties as needed
                employees.add(employee);
            }

        } catch (SQLException e) {
            logger.error(String.valueOf(e)); // Handle this exception properly in a real-world scenario
        }

        return employees;
    }

    public Employee getEmployeeById(long id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = ?")
        ) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getLong("id"));
                employee.setName(resultSet.getString("name"));
                // Set other employee properties as needed
                return employee;
            }

        } catch (SQLException e) {
            logger.error(String.valueOf(e)); // Handle this exception properly in a real-world scenario
        }

        return null;
    }

    public Employee addEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO employee (name) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, employee.getName());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long generatedId = generatedKeys.getLong(1);
                    employee.setId(generatedId);
                    return employee;
                }
            }

        } catch (SQLException e) {
            logger.error(String.valueOf(e)); // Handle this exception properly in a real-world scenario
        }

        return null;
    }

    public Employee updateEmployee(long id, Employee updatedEmployee) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE employee SET name = ? WHERE id = ?")
        ) {
            statement.setString(1, updatedEmployee.getName());
            statement.setLong(2, id);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                updatedEmployee.setId(id);
                return updatedEmployee;
            }

        } catch (SQLException e) {
            logger.error(String.valueOf(e)); // Handle this exception properly in a real-world scenario
        }

        return null;
    }

    public boolean deleteEmployee(long id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = ?")
        ) {
            statement.setLong(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            logger.error(String.valueOf(e)); // Handle this exception properly in a real-world scenario
        }

        return false;
    }
}