/**
 * * @author Greg Tidd
 * 7/27/2015
 * Java 1 
 * Instructor Henry Williams
 * annualCommision.java 1.0
 */
package annualcommission; // Program associated with

    public class SalaryCalc { // creates blueprint of SalaryCalc
    
    final private double salary = 85000.00; //constant variable used only in this class
    private double commissionRate = .15;// constant variable used only in this class
    private double commission; // Sets variable names and data types
    private double sales;
    private double tempTotalSalary;
    private double tempTotalSalary1;
    private double totalSalary;
  
    private String name;
    private double salesTemp;
    private double salesMax;
    
    
        public void setSales(double sales){ //method for commission calculation
          
           this.sales = sales; //takes the value from user entered and sets it to private sales
           if (sales < 120000) // these statement check to see if sales goals were met and send result to main
             {
                  System.out.println("You did not meet sales goals. No incentive is given this pay period");
                  //advises they did not reach quota
                  tempTotalSalary1 = salary;
                  totalSalary = tempTotalSalary1; // returns only the base salary
             }
           if(sales >= 170000 && sales < 190000) // runs user input for acceleration of .02 for each level of 20k up to .06 
                       {
                           commissionRate += .02;
                           this.commission = sales * this.commissionRate;
                           this.tempTotalSalary1 = salary + this.commission; 
                           this.totalSalary = this.tempTotalSalary1;
                           }else if(sales >= 190000 && salesTemp < 210000)
                           {
                               commissionRate += .04;
                           this.commission = sales * this.commissionRate;
                           this.tempTotalSalary1 = salary + this.commission; 
                           this.totalSalary = this.tempTotalSalary1;
                           }else if(sales >= 210000)
                           {
                               commissionRate += .06;
                           this.commission = sales * this.commissionRate;
                           this.tempTotalSalary1 = salary + this.commission; 
                           this.totalSalary = this.tempTotalSalary1;
                           }
                           else if(sales >= 120000 && sales <= 169999)
                           {
                           this.commission = sales * this.commissionRate;
                           this.tempTotalSalary1 = salary + this.commission; 
                          this.totalSalary = this.tempTotalSalary1;
                           } else if(sales < 120000)
                           {
                            this.totalSalary = this.tempTotalSalary1;
                           }
         salesMax = sales + (sales * .5); //sets table end point at 50%
         
         commissionRate = .15;// resets commission rate after first set of if statements
         
         System.out.println("Total Sales \t\t\t\t\t Total Compensation");// table header
         
         for (salesTemp = sales; salesTemp <= salesMax; salesTemp +=20000)// runs the table until it hits 50% of sales
               {
                       if(salesTemp >= 170000 && salesTemp < 190000)
                       {
                           commissionRate += .02;
                           this.commission = salesTemp * this.commissionRate;
                           this.tempTotalSalary = salary + this.commission; 
                           System.out.println(salesTemp + "\t\t\t\t\t" + tempTotalSalary + "\t\t 17% Commission");
                       }else if(salesTemp >= 190000 && salesTemp < 210000)
                           {
                           commissionRate += .04;
                           this.commission = salesTemp * this.commissionRate;
                           this.tempTotalSalary = salary + this.commission; 
                           System.out.println(salesTemp + "\t\t\t\t\t" + tempTotalSalary + "\t\t 19% Commission");
                           }else if(salesTemp >= 210000)
                           {
                           commissionRate += .06;
                           this.commission = salesTemp * this.commissionRate;
                           this.tempTotalSalary = salary + this.commission; 
                           System.out.println(salesTemp + "\t\t\t\t\t" + tempTotalSalary + "\t\t 21% Commission");
                           }
                           else if(salesTemp >= 120000 && salesTemp <= 169999)
                           {
                           this.commission = salesTemp * this.commissionRate;
                           this.tempTotalSalary = salary + this.commission; 
                           System.out.println(salesTemp + "\t\t\t\t\t" + tempTotalSalary + "\t\t 15% Commission");
                           }else if(salesTemp <= 120000)
                       {
                           System.out.println(salesTemp + "\t\t\t\t\t" + salary + "\t\t 0% Commission");
                       }
                    
               }
         
        }
        public double getSales(){ //the method used to return value calculated above
              return totalSalary; //Calculated value return to AnnualCommision.java
        }
    
        public void setName(String name){ //accepts name from user and assigns to String variable name
            this.name = name;
        }
        public String getName(){
            return name;  //returns name to AnnualCommission.java
        }
    }

