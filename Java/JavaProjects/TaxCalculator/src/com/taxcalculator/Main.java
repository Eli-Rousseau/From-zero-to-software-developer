package com.taxcalculator;

public class Main {

    public static void main(String[] args) {

        // Instantiate the calculator object
        var calculator = new TaxCalculator2024(100_000);

        // Instantiate the taxReport object
        var taxReport = new TaxReport(calculator);

        // Print the taxReport to the console
        taxReport.show();

        taxReport.setCalculator(new TaxCalculator2025(120_000));
        taxReport.show();
    }
}
