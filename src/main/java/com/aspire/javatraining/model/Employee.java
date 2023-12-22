package com.aspire.javatraining.model;

public class Employee {
    private long id;
    private String name;

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
