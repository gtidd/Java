/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataentry;

/**
 *
 * @author Greg
 */
import java.util.ArrayList;

public class Zoo
{	
	String name;
	int id = 0; 
	ArrayList<Animal> animal = new ArrayList<Animal>();
	
	public Zoo(String name)
	{
	this.name = name;
	
	}
	public void addZooAnimal(Animal addAnimal)
	{
	animal.add(addAnimal);
	id++;
	}
	public void removeZooAnimal(Animal removeAnimal)
	{
	animal.remove(removeAnimal);
	}
	
	
}