package com.bl.cabinvoicegenerator;

/*
 * @author : Sadanand Pandey
 * purpose: Here calculating total fare and average fare per ride
 *          on basis of selected ride type (Normal and Premium).
 */

import java.util.Scanner;

public class CabInvoiceGenerator {

    public static double totalFare = 0;
    public static double avgFare = 0;
    public static int numOfRide = 0;
    static int userId;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id :");
        userId = scanner.nextInt();
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        System.out.println("Select your ride type \n1. Normal ride \n2. Premium ride ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter number of ride : ");
                numOfRide = scanner.nextInt();
                for (int i = 1; i <= numOfRide; i++) {
                    System.out.println("Enter total distance of " + i + " ride :");
                    double distance = scanner.nextDouble();

                    System.out.println("Enter total time of " + i + " ride :");
                    int time = scanner.nextInt();
                    cabInvoiceGenerator.normalTotalFare(distance, time);
                }
                cabInvoiceGenerator.displayInvoice();
                break;
            case 2:
                System.out.println("Enter number of ride : ");
                numOfRide = scanner.nextInt();
                for (int i = 1; i <= numOfRide; i++) {
                    System.out.println("Enter total distance of " + i + " ride :");
                    double distance = scanner.nextDouble();

                    System.out.println("Enter total time of " + i + " ride :");
                    int time = scanner.nextInt();

                    cabInvoiceGenerator.premiumTotalFare(distance, time);
                }
                cabInvoiceGenerator.displayInvoice();
                break;
        }
    }

    public void displayInvoice() {
        System.out.println("Your invoice bill : ");
        System.out.println("-----------------------");
        System.out.println("Total number of ride  : " + numOfRide);
        System.out.println("Total fare of rides   : " + totalFare);
        System.out.println("Average fare per ride : " + avgFare);

    }

    /*Calculating total fare for a single ride by cab
    taking input distance and time
    calculating total fare and average fare for normal ride
    */
    public double normalTotalFare(double distance, int time) {
        int costPerMinute = 1;
        int costPerKm = 10;
        int minFare = 5;
        double fare = (costPerKm * distance) + (costPerMinute * time);
        totalFare = totalFare + Math.max(fare, minFare);
        avgFare = (totalFare / numOfRide);
        return totalFare;
    }

    //calculating total fare and average fare for premium ride
    public double premiumTotalFare(double distance, int time) {
        int costPerMinute = 2;
        int costPerKm = 15;
        int minFare = 20;
        double fare = (costPerKm * distance) + (costPerMinute * time);
        totalFare = totalFare + Math.max(fare, minFare);
        avgFare = (totalFare / numOfRide);
        return totalFare;
    }
}
