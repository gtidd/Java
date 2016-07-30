package animalfilereader;
/**
 *
 * @author Greg Tidd
 * 9/10/15
 * Individual week 3 project 
 * Instructor Paul Stay
 * Covering I/O and file management.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
 
public class AnimalFileReader {
 
    public static void main(String[] args) throws IOException {

        // Creates new Object of BufferedReader for the file animals.csv
       
	 BufferedReader reader = new BufferedReader(new FileReader(
                "animals.csv"));
 
        // reads file in sections
 
       String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Animal> aniList = new ArrayList<>();
 	// While lines are not null this runs if compiler detects no data program ends outputs results
        while ((line = reader.readLine()) != null) {
            Animal ani = new Animal();
            scanner = new Scanner(line);
	    // searches for Delimiter comma to separate forms of data
            scanner.useDelimiter(",");
            //assigns values to different indexes
	    while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    ani.setId(data);
                else if (index == 1)
                    ani.setName(data);
                else if (index == 2)
                    ani.setType(data);
                else if (index == 3)
                    ani.setAge(data);
                else
                    System.out.println("invalid data " + data);
                index++;
            }
            index = 0;
            aniList.add(ani);
        }
	    //Iterator use
	
        System.out.println("Iterator start");
        System.out.println("");
	 System.out.print("Animal file: ");
      Iterator itr = aniList.iterator();
      while(itr.hasNext()) {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();
	
         
        //close reader
        reader.close();
        System.out.println("Iterator end");
        System.out.println("");
        //non iterator
        System.out.println("Non iterator");
        System.out.println(aniList);
         
    }
 
}