package com.taxcalculator;

public class TaxReport {

    // Initialize the class fields
    private TaxCalculator calculator;

    // Initialize a class constructor method
    public TaxReport(TaxCalculator calculator){
        this.calculator = calculator;
    }

    // Initialize method to print the tax report to the console
    public void show() {
        var tax = this.calculator.calculateTax();
        System.out.println(tax);
    }

    // Initialize setter method for the calculator object;
    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }
}
