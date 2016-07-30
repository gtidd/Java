/**
 *
 * @author Greg Tidd
 * 7/27/2015
 * Java 1 
 * Instructor Henry Williams
 * annualCommision.java 1.0
 * I am aware of the typo in the name of the program
 */
package annualcommission; //all project files for classes
import java.util.Scanner; //allows input from user

public class AnnualCommission { //creating the class

    public static void main(String[] args) { //main class
        Scanner input = new Scanner(System.in); //Initializing the input variable
        
        SalaryCalc employee = new SalaryCalc(); //creating a new object of the class SalaryCalc
        
   
       int i = 0; //initializes array counter
       String highName = "";// initailizes the highName and highest to calculate the highest amount entered
       double highest = 0;
       int empAmount;//Establishing employee array
       System.out.println("How many employees will you be calculating commission on?");
       empAmount = Integer.parseInt(input.nextLine());
       String[] multiName = new String[empAmount];//Initializes multiName Array
  
       double[] empSales = new double[empAmount]; //Initializes empSales Array for commission calculation
        
         for(int j = 0; j < multiName.length;j++)//Array loop for name and Sales
         {
        System.out.print("Enter Employee Name:"); //Asks for user entry of employee name then 
        multiName[j] = input.nextLine();        //sends it to the SalaryCalc for and saves it as empName
        employee.setName(multiName[j]);
        System.out.println(); //Adds space for easier reading
    
      
        boolean isNumber; //Initializes isNumber for do while loop
        
        
        if(i <= multiName.length) //sets sales Array for i counter inside for array
        {
        do {
            System.out.print("Enter Number of Sales in Dollar amount:"); //Runs initial statement and will rerun if isNumber 
                                                                         //returns false
            if(input.hasNextDouble()) { //ensures input is a double     
        
        empSales[i] = input.nextDouble(); //if the input is a double we run it against SalaryCalc methods
        employee.setSales(empSales[i]);//assigns empSales to setSales argument
        
        System.out.println(); // For readablility
        
        
        isNumber = true; // ends do while loop 
            } else{ //runs only if a non positve number or character is entered
                System.out.println("Your entry is invalid. Please make sure you enter only positive numbers.");
                isNumber = false; //causes loop to rerun for valid entry
                input.next(); // clears input variable to avoid infinite loop
            }
            } while(!(isNumber)); //will check the boolean variable if false loop reruns
        System.out.println("Employee "+ employee.getName() +" has made $" +
                     String.format( "%.2f", employee.getSales())+" this year!" ); // outputs employee name and commission in
          if (j <= multiName.length -2)//will ask for the next name at the completion of each cycle until the last name is entered
              {
                System.out.println("Next name"); 
                input.nextLine(); //clears current input so it doesn't skip user " name entry" 
              }
         }
            if(empSales[i] > highest)// calculates the highest sale amount
            {
            highName = multiName[j];//assigns current iteration to array
            highest = empSales[i];  
            } 
            if(empSales[i] >= 0 || empSales[i] != highest) //compares lower amounts to find the difference between current
            {                                              // and highest
            double difference;
            difference = highest - empSales[i];
            System.out.println(multiName[j]+ " will need to sell $"+ difference + " more");    
            }
            i++; //increases i counter to change array memory address for sales
        }                
          
     System.out.println();
     System.out.println("The highest sale amount was "+ highest + " by "+ highName); //list highest sales amount and name
        }
    }

    
        
  
