package com.taxcalculator;

public class TaxCalculator2024 implements TaxCalculator {

    // Initialize the class fields
    private double taxableIncome;

    // Initialize a class constructor method
    public TaxCalculator2024(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    // Initialize method to calculate tax in 2024
    public double calculateTax() {
        return this.taxableIncome * 0.3;
    }
}
