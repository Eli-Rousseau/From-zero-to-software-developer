package com.mortgage_calculator;

import java.text.NumberFormat;

// Initialize a class to print the mortgage calculations
public class MortgageReport {

    // Initialize the fields for the mortgage report
    private int principal;
    private float monthlyInterest;
    private int numberOfPayments;

    private final int MONTHSINYEAR = 12;
    private final int PERCENT = 100;

    private MortgageCalculator calculatorInstance;

    private final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();

    // Initialize a constructor method the class fields
    public MortgageReport(int principal, float annualInterest, int period) {
        this.principal = principal;
        this.monthlyInterest = (annualInterest / MONTHSINYEAR) / PERCENT;
        this.numberOfPayments = period * MONTHSINYEAR;

        calculatorInstance = new MortgageCalculator(principal, monthlyInterest, numberOfPayments);
    }

    // Initialize a method to print the mortgage
    public void printMortgage() {

        // Call the mortgageCalculator method
        double mortgage = this.calculatorInstance.mortgageCalculator();

        // Format the mortgage into a desired money format
        String formatedMortgage = currencyInstance.format(mortgage);

        // Prompt the mortgage value to the console
        System.out.println("\nMORTGAGE\n--------\nMonthly Payments: " + formatedMortgage + "\n");
    }

    // Initialize a method to print the monthly payments balance
    public void printPaymentCalender() {

        // Print the payment title to the console
        System.out.println("PAYMENT CALENDER\n---------------");

        // Initialize the remaining payment variable
        double remainingPayment;

        // Prompt the remaining payment until finished
        for (int month = 1; month <= numberOfPayments; month++) {

            // Call the remainingPaymentCalculator to calculate the remainingPayment in a given year
            remainingPayment = this.calculatorInstance.remainingPaymentCalculator(month);

            // Format the remainingPayment into a desired money format
            String formatedRemainingPayment = currencyInstance.format(remainingPayment);

            // Print the formatedRemainingPayment to the console
            System.out.println(formatedRemainingPayment);
        }
    }
}
