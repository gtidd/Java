
package dataentry;

/**
 *
 * @author Greg Tidd
 * 8/31/2015
 * PRG/421
 * Paul Stay
 */
public class DataEntry
{
	public static void main(String[] args)
	{
	Zoo timone = new Zoo("Timone");
        Animal meerkat = new Animal("MeerKat","Brown","Can Swim", 5);
        timone.addZooAnimal(meerkat); 
            
        Zoo pumba = new Zoo("Pumba");
        Animal warthog = new Animal("Warthog","Tan","Cannot Swim", 3);
        pumba.addZooAnimal(warthog);
        
        for (Zoo Zoo.Animal: animal) {
     System.out.println(animal);
            }
        pumba.removeZooAnimal(warthog);
         for (Zoo Zoo.Animal: animal) {
     System.out.println(animal);
	}


}     