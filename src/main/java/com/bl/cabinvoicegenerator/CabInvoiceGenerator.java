package com.bl.cabinvoicegenerator;
/*
 * @author : Sadanand Pandey
 * purpose: Here calculating multiple ride fare and average fare per ride
 */

import java.util.Scanner;

public class CabInvoiceGenerator {
    private static int costPerMinute = 1;
    private static int costPerKm = 20;
    private static int minFare = 5;
    public static double totalFare = 0;
    public static double avgFare = 0;
    public static int numOfRide = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        System.out.println("Enter number of ride : ");
        numOfRide = scanner.nextInt();

        for (int i = 1; i <= numOfRide; i++) {
            System.out.println("Enter total distance of " + i + " ride :");
            double distance = scanner.nextDouble();
            System.out.println("Enter total time of " + i + " ride :");
            int time = scanner.nextInt();
            cabInvoiceGenerator.calculateTotalFare(distance, time);
        }
        System.out.println("Total number of ride  : " + numOfRide);
        System.out.println("Total fare of rides   : " + totalFare);
        System.out.println("Average fare per ride : " + avgFare);
    }

    /*Calculating total fare for a single ride by cab
    taking input distance and time*/
    public double calculateTotalFare(double distance, int time) {
        double fare = (costPerKm * distance) + (costPerMinute * time);
        totalFare = totalFare + Math.max(fare, minFare);
        avgFare = (totalFare / numOfRide);
        return totalFare;
    }
}
