package com.aspire.javatraining.model;

// Class Declaration. This should equal the modal for the table in the DB
public class Employee {
    private long id; // Field for the id
    private String name; // Field for the name

    // Empty constructor
    public Employee() {
        // Default initialization or setup code here
    }

    // Constructor with parameters
    public Employee(String name) {
        this.name = name;
    }

    // Getter and Setter methods for id and name

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
