/*
 * Jason D. Mickelson
 * August 17th, 2015
 * University of Phoenix
 * PRG 420
 * Henry Williams
 */
package annualcompensation4;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class AnnualCompensation4 {

    public static void main(String[] args) {

        // The DecimalFormat below ensures the output is formatted in two decimal places
        DecimalFormat dollar = new DecimalFormat ("#,###.00");

        double sales;
        double target=150000;
        int numPeople;
        SalaryCalc salesPerson;
       
        // Instantiate SalesPerson ArrayList
        ArrayList<SalaryCalc> salesPersons = new ArrayList<SalaryCalc>();
        
        Scanner input=new Scanner(System.in);
        System.out.print("Please enter total number of Salespeople: ");//  ask the user to enter annual sales
        
        numPeople=input.nextInt();
        double difference = 0;
        for (int i = 0; i < numPeople; i++) {
            // Using getName to retrieve SalesPerson name
            String name = getName(i);
            // Using getSales to get annual sales
            sales = getSales(name);
            salesPerson = new SalaryCalc(name);
            salesPerson.setSales(sales);
            // Using .add to add salesPerson to List
            salesPersons.add(salesPerson);
            // first part to finding the highest earner
            if (salesPerson.getSales() > difference) {
                difference = salesPerson.getSales();
            }
            System.out.println();
            // Calculate annual pay for each sales person
//            double totalCompensation = salesPerson.calculateTotalCompensation(sales);
//            salesPerson.setTotalAnnualCompensation(totalCompensation);
        }
        // Calculate the difference between the highest earner and everyone else
        for (int i = 0; i < numPeople; i++) {
            salesPerson = salesPersons.get(i);
            if (salesPerson.getSales() < difference){
                System.out.println(salesPerson.getName() + " needs to make at least $ " + dollar.format((difference-salesPerson.getSales())) + " more in sales to equal or surpass the highest earner.");
            }
            else System.out.println(salesPerson.getName() + " is the highest earner with $ " + dollar.format(salesPerson.getSales()) + " in Total Annual Sales.");
        }
        System.out.println();
    }

    // Method used to get the name of the sales person
    private static String getName(int i) {
        String name;
        Scanner scanner;
        System.out.print("\nEnter the name of Sales Person " + (i + 1) + ": ");
        scanner = new Scanner(System.in);
        name = scanner.nextLine();
        return name;
    }

    // Method used to get the Total Annual Sales from the user
    private static double getSales(String name) {
        Scanner input;
        input = new Scanner(System.in);
        double sales = 0;
        boolean isValidSales = false;

        while (!isValidSales) {
            try {
                System.out.print("Please Enter the Total Annual Sales of " + name + " : ");
                // Getting the sales and parsing the value
                sales = Double.parseDouble(input.nextLine());
                // Checking if the sales entered is positive
                if (sales >= 0.0) {
                    isValidSales = true;
                //If the value entered is invalid
                } else {
                    System.out.println("Please Enter a Valid Number value.");
                }
                //If the value entered is not a number
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a Valid Number value.");
            }
        }
        return sales;
    }
}