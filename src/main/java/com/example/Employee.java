package com.example;

public class Employee {
    public int id;
    public String name;
    public String position;
    public double salary;

    @Override
    public String toString() {
        return String.format("%d: %s (%s) - %.2f", id, name, position, salary);
    }
}
