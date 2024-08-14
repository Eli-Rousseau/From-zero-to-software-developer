package com.mortgage_calculator;

import java.util.Scanner;

// Initialize class to read input numbers for the mortgage calculation
public class Console {

    // Initialize method to read the input numbers provided in the console by the user
    public static double readNumber(String queryMessage, int lowerLimit, int upperLimit) {

        // Initialize a scanner
        Scanner scanner = new Scanner(System.in);

        // Initialize the user input value
        double userValue;

        // Prompt user for a number until valid
        while (true) {

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
}
