package com.bl.cabinvoicegenerator;
/*
 * @author : Sadanand pandey
 * purpose: In this code we will generate total bill of a cab in the end of month
 */

public class CabInvoiceGenerator {
    static int costPerMinute = 1;
    static int costPerKm = 20;
    static int minFare = 5;

    public static void main(String[] args) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        System.out.println(cabInvoiceGenerator.calculateTotalFare(20, 5));

    }

    /*Calculating total fare for a single ride by cab
    taking input distance and time*/
    public double calculateTotalFare(int distance, int time) {
        double totalFare = (costPerKm * distance) + (costPerMinute * time);
        if (totalFare < minFare) {
            return minFare;
        }
        return totalFare;
    }
}
