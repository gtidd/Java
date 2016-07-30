/*
 * Jason D. Mickelson
 * August 17th, 2015
 * University of Phoenix
 * PRG 420
 * Henry Williams
 */
package annualcompensation4; // Program associated with

import java.text.DecimalFormat;


    public class SalaryCalc { // creates blueprint of SalaryCalc
    DecimalFormat dollar = new DecimalFormat ("#,###.00");
    DecimalFormat percent = new DecimalFormat ("#");
    
    final private double salary = 85000.00; //constant variable used only in this class
    private double commissionRate = .15;// constant variable used only in this class
    private double commission; // Sets variable names and data types
    private double sales;
    private double tempTotalSalary; // used for projected earnings
    private double tempTotalSalary1;
    private double totalSalary;
    private double incentive;
  
    private String name;
    private double salesTemp;
    private double salesMax;
    
    
        public void setSales(double sales){ //method for commission calculation
          
            this.sales = sales; //takes the value from user entered and sets it to private sales
            if (sales < 120000) // these statement check to see if sales goals were met and send result to main
            {
                  System.out.println("You did not meet the sales goals. No incentive is given for this pay period");
                  //advises they did not reach quota
                  tempTotalSalary1 = salary;
                  totalSalary = tempTotalSalary1; // returns only the base salary
            }
            incentive=Math.floor(sales/150000)*0.02;
            if(sales >= 120000) // runs user input for acceleration of .02 for each level of 20k up to .06 
                        {
                            this.commission = sales * (this.commissionRate + incentive);
                            this.tempTotalSalary1 = salary + this.commission; 
                            this.totalSalary = this.tempTotalSalary1;
                        }
                            else if(sales < 120000)
                           {
                            this.totalSalary = this.tempTotalSalary1;
                           }
         salesMax = sales * 1.5; //sets table end point at 50%
         
         System.out.println();
         System.out.println("Total Sales \t\t\t\t\t Total Compensation");// table header
         
         for (salesTemp = sales; salesTemp <= salesMax; salesTemp +=20000)// runs the table until it hits 50% of sales
               {
                incentive=Math.floor(salesTemp/150000)*0.02;
                        if(salesTemp >= 120000)
                        {
                           this.commission = salesTemp * (this.commissionRate + incentive);
                           this.tempTotalSalary = salary + this.commission; 
                           System.out.println("$" + dollar.format(salesTemp) + "\t\t\t\t\t $" + dollar.format(tempTotalSalary) + "\t\t " + percent.format((this.commissionRate + incentive)*100) + "% Commission");
                        }
                        else if(salesTemp < 120000)
                       {
                           System.out.println("$" + dollar.format(salesTemp) + "\t\t\t\t\t $" + dollar.format(salary) + "\t\t 0% Commission");
                       }
                    
               }
         
        }
        public SalaryCalc(String name) {
            this.name = name;
        }
        public double getSales(){ //the method used to return value calculated above
              return sales; //Calculated value return to AnnualCommision.java
        }
        public void setName(String name){ //accepts name from user and assigns to String variable name
            this.name = name;
        }
        public String getName(){
            return name;  //returns name to AnnualCommission.java
        }
}
