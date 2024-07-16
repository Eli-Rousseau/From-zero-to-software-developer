package com.mortgage_calculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ask user for the parameters
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        long principal = scanner.nextLong();
        System.out.print("Annual Interest Rate: ");
        float rate = scanner.nextFloat();
        rate /= 12;
        System.out.print("Period (Years): ");
        int period = scanner.nextInt();
        period *= 12;

        // Calculate the mortgage
        double mortgage = principal * ((rate * Math.pow(1 + rate, period))
                / (Math.pow(1 + rate, period) - 1));

        // Format the mortgage into a desired money format
        String mortgageCurrency = NumberFormat.getCurrencyInstance().format(mortgage);

        // Return the mortgage value
        System.out.println("Mortgage: " + mortgageCurrency);
    }
}
