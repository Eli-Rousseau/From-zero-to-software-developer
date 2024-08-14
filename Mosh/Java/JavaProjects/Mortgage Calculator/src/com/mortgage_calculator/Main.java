package com.mortgage_calculator;

public class Main {

    public static void main(String[] args) {

        // Call the readNumber method to collect the values for the input user variables
        int principal = (int) Console.readNumber("Principal (€1k - €1M): ", 1_000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 0, 30);
        int period = (int) Console.readNumber("Period (Years): ", 1, 30);

        // Create a mortgage report instance
        var mortgageReportInstance = new MortgageReport(principal, annualInterest, period);

        // Call the printMortgage method to print the mortgage on the console
        mortgageReportInstance.printMortgage();

        // Call the printPaymentCalendar method to print the  payment calendar to the console
        mortgageReportInstance.printPaymentCalender();
    }

}
