package com.FizzBuzz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        // Initialize a scanner
        Scanner scanner = new Scanner(System.in);

        // Ask user for input number
        System.out.print("Number: ");
        float inputNumber = scanner.nextInt();

        // Check whether the input number can be divided by 3 and/or 5
        if (inputNumber % 5 == 0 && inputNumber % 3 == 0) {
            System.out.println("FizzBuzz");
        }
        else if (inputNumber % 5 == 0) {
            System.out.println("Fizz");
        }
        else if (inputNumber % 3 == 0) {
            System.out.println("Buzz");
        }
        else {
            System.out.println((int) inputNumber);
        }

    }
}