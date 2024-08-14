package com.taxcalculator;

public class TaxCalculator2025 implements TaxCalculator {

    // Initialize the class fields
    private double taxableIncome;

    // Initialize the class constructor method
    public TaxCalculator2025(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    // Initialize method to calculate tax in 2025
    public double calculateTax() {
        return this.taxableIncome * 0.5;
    }
}
