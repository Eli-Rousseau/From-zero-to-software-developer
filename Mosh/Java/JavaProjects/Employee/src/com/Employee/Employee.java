package com.Employee;

public class Employee {

    // Initialize the employee fields
    private double baseSalary = 50_000;
    private double hourlyRate = 20;

    // Initialize the constructor of the employee class
    public Employee(double baseSalary, double hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
    }

    // Initialize method for the employee wage calculation
    public double employeeWageCalculator(double extraHours) {
        return baseSalary + (hourlyRate * extraHours);
    }

    // Initialize employee's base salary setter method
    private void setBaseSalary(double baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Employee's base salary can't be zero or less.");
        }
        this.baseSalary = baseSalary;
    }

    // Initialize employee's base salary getter method
    private double getBaseSalary() {
        return this.baseSalary;
    }

    // Initialize employee's hourly work rate setter method
    private void setHourlyRate(double hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Employee's hourly work rate can't be zero or less.");
        }
        this.hourlyRate = hourlyRate;
    }

    // Initialize employee's hourly work rate getter method
    private double getHourlyRate() {
        return this.hourlyRate;
    }
}
