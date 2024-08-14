package com.Employee;

public class Main {

    public static void main(String[] args) {

        // Initialize an employee object
        var employee1 = new Employee(30_000, 12.5);

        // Calculate the employee's wage
        double employeesWage = employee1.employeeWageCalculator(20);

        // Print the employee's wage to the console
        System.out.println("Employee's wage: €" + employeesWage);
    }
}