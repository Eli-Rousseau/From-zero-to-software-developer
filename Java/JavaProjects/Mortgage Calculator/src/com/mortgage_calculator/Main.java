package com.mortgage_calculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initialize constants
        final int MONTHSINYEAR = 12;
        final int PERCENTAGE = 100;

        // Initialize a scanner
        Scanner scanner = new Scanner(System.in);

        // Ask user for its principal deposit
        int principal;
        while (true) {
            System.out.print("Principal (€1k - €1M): ");
            principal = scanner.nextInt();

            if (principal >= 1_000 && principal <= 1_000_000) { // Verify principal falls in between €1k-1M
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        // Ask the user for its interest rate
        float rate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            rate = scanner.nextFloat();

            if (rate > 0 && rate <= 30) { // Verify interest rate falls between 0-30
                break;
            }
            System.out.println("Enter a value greater than zero and less than or equal to 30.");
        }
        rate = (rate / MONTHSINYEAR) / PERCENTAGE;

        // Ask the user for the period of mortgage
        int period;
        while (true) {
            System.out.print("Period (Years): ");
            period = scanner.nextInt();

            if (period >= 1 && period <= 30) {
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }
        period *= MONTHSINYEAR;

        // Calculate the mortgage
        double mortgage = principal
                * ((rate * Math.pow(1 + rate, period))
                / (Math.pow(1 + rate, period) - 1));

        // Format the mortgage into a desired money format
        String mortgageCurrency = NumberFormat.getCurrencyInstance().format(mortgage);

        // Return the mortgage value
        System.out.println("Mortgage: " + mortgageCurrency);
    }
}
