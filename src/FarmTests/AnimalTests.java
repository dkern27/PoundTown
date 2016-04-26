package FarmTests;

import FarmGame.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AnimalTests {

	ArrayList<Animal> animals;
	
	@Before
	public void setUp(){
		Level level = new Level("2",  "AnimalImages/Sheep.png", 3, AnimalType.PIG,"AnimalImages/Pig.png");
		animals = level.getAnimalsList();
		//level.initialize(2); or something only allowing 2 digit binary numbers
		//Get animals and store
	}
	
	@Test
	public void testDecimalMatchingBinary(){
		int digits=0; //Need  to get from levels or animal or something
		for(Animal a : animals){
			int dec = a.getDecimalValue();
			String bin = a.getBinaryValue();
			int binValue=0;
			
			//Probably have a function somewhere else to do this
			//Convert binary to decimal
			for(int i=0; i<bin.length();i++){
				if(bin.charAt(i) == '1'){
					binValue += Math.pow(2, (digits-1-i)); 
				}
			}
			
			assertEquals(dec, binValue);
		}
	}
	
	@Test
	public void testAnimalValues(){
		int num0 = 0;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		for(int i=0; i<50;i++){
			//String name, String backgroundFile, int numDigits, AnimalType animalType, String animalDrawFile 
			Level l = new Level("2",  "AnimalImages/Sheep.png", 3, AnimalType.PIG,"AnimalImages/Pig.png");
			for(Animal a: l.getLocations().get(0).getAnimals()){
				switch(a.getDecimalValue()){
				case 0: 
					num0++;
					break;
				case 1:
					num1++;
					break;
				case 2:
					num2++;
					break;
				case 3:
					num3++;
					break;
				default:
					fail("Number out of range for number of binary digits");
				}
			}
	
		}
		assertTrue(num0>0);
		assertTrue(num1>0);
		assertTrue(num2>0);
		assertTrue(num3>0);
	}
	
	

}
