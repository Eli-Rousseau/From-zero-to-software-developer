package com.mortgage_calculator;

// Initialize a class to calculate the mortgage
public class MortgageCalculator {

    // Initialize the input fields for calculating the mortgage
    private int principal;
    private float monthlyInterest;
    private int numberOfPayments;

    // Initialize a constructor method for the class fields
    public MortgageCalculator(int principal, float monthlyInterest, int numberOfPayments) {
        this.principal = principal;
        this.monthlyInterest = monthlyInterest;
        this.numberOfPayments = numberOfPayments;
    }

    // Initialize a method to calculate the monthly mortgage
    public double mortgageCalculator() {

        // Calculate the mortgage
        double mortgage = this.principal
                * ((this.monthlyInterest * Math.pow(1 + this.monthlyInterest, this.numberOfPayments))
                / (Math.pow(1 + this.monthlyInterest, this.numberOfPayments) - 1));

        // Return the mortgage value
        return mortgage;
    }

    // Initialize a method to calculate the remaining payment after each month
    public double remainingPaymentCalculator(int numberOfPaymentsMade) {

        // Calculate the remaining payment
        double remainingPayment = this.principal
                * ((Math.pow(1 + this.monthlyInterest, this.numberOfPayments) - Math.pow(1 + this.monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + this.monthlyInterest, this.numberOfPayments) - 1));

        // Return the remainingPayment value
        return remainingPayment;
    }
}
