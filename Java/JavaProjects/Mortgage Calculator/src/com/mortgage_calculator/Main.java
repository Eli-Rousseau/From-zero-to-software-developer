package com.mortgage_calculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    // Initialize constants
    final static int MONTHSINYEAR = 12;
    final static int PERCENTAGE = 100;

    public static void main(String[] args) {

        // Call the readNumber method to collect the values for the input user variables
        int principal = (int) readNumber("Principal (€1k - €1M): ", 1_000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 0, 30);
        int period = (int) readNumber("Period (Years): ", 1, 30);

        // Calculate the monthly interest rate
        float monthlyInterest = (annualInterest / MONTHSINYEAR) / PERCENTAGE;

        // Calculate the number of due total payments
        int numberOfPayments = period * MONTHSINYEAR;

        // Call the printMortgage function to print the mortgage on the console
        printMortgage(principal, monthlyInterest, numberOfPayments);

        // Call the printPaymentCalendar function to print the  payment calendar to the console
        printPaymentCalender(principal, monthlyInterest, period, numberOfPayments);
    }

    public static double readNumber(String queryMessage, int lowerLimit, int upperLimit) {

        // Initialize a scanner
        Scanner scanner = new Scanner(System.in);

        // Initialize the user input value
        double userValue;

        // Prompt user for a number until valid
        while(true) {

            // Prompt the query number to the user
            System.out.print(queryMessage);

            // Read in the user input value
            userValue = scanner.nextDouble();

            // Verify whether the user input value respects the lower and upper limits
            if (userValue >= lowerLimit && userValue <= upperLimit) {
                break;
            }

            // Print error message to the console
            System.out.println("The entered value should be between " + lowerLimit + " and " + upperLimit);
        }

        // Return the valid user input value
        return userValue;
    }

    public static double mortgageCalculator(int principal, float monthlyInterest, int numberOfPayments) {

        // Calculate the mortgage
        double mortgage = principal
                * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        // Return the mortgage value
        return mortgage;
    }

    public static void printMortgage(int principal, float monthlyInterest, int numberOfPayments) {

        // Call the mortgageCalculator method
        double mortgage = mortgageCalculator(principal, monthlyInterest, numberOfPayments);

        // Format the mortgage into a desired money format
        String formatedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        // Prompt the mortgage value to the console
        System.out.println("\nMORTGAGE\n--------\nMonthly Payments: " + formatedMortgage + "\n");
    }

    public static double remainingPaymentCalculator(int principal, float monthlyInterest, int numberOfPayments, int numberOfPaymentsMade) {

        // Calculate the remaining payment
        double remainingPayment = principal
                * ( ( Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade) )
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1) );

        // Return the remainingPayment value
        return remainingPayment;
    }

    public static void printPaymentCalender(int principal, float monthlyInterest, int period, int numberOfPayments) {

        // Print the payment title to the console
        System.out.println("PAYMENT CALENDER\n---------------");

        // Initialize the remaining payment variable
        double remainingPayment;

        // Prompt the remaining payment until finished
        for (int month = 1; month <= period * MONTHSINYEAR; month++) {

            // Call the remainingPaymentCalculator to calculate the remainingPayment in a given year
            remainingPayment = remainingPaymentCalculator(principal, monthlyInterest, numberOfPayments, month);

            // Format the remainingPayment into a desired money format
            String formatedRemainingPayment = NumberFormat.getCurrencyInstance().format(remainingPayment);

            // Print the formatedRemainingPayment to the console
            System.out.println(formatedRemainingPayment);
        }
    }
}
