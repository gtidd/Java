/*Seeing that this is a small project I still would like to practice like it is
*a larger file and have included it in a full project instead of individual Java
*File
*/
package helloworld;

/**
 *
 * @author Greg Tidd
 * Date July 14, 2015
 * University of Phoenix 
 * PRG 420/Henry Williams
 * Helloworld 1.0
 */

import java.util.Scanner;
//Importing the utility to make user input easy so I can have fun with this
public class Helloworld {

   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       //Telling Java to accept input in the variable named input
        
        System.out.println("Hello World");
        //Displays Text
       //Extra for fun and learning asks users name and will display below
        String name; //Labels the variable name as String for text input
        System.out.println("What is your name? "); //Displays Question
        /*Also notice I could do just print here if I wanted to keep it on
        one line*/
        name = input.next(); /*assigns user input to name using a method from 
        the Scanner utility */
        System.out.println(name + " says Hello World!!!"); 
        /*Concatenates the variable name to the phrase Hellow World for a 
        *pesonal experience and fun.
        */
        
       
        
    }
    
}
