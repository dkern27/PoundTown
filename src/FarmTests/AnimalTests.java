package FarmTests;

import FarmGame.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AnimalTests {

	Level level;
	ArrayList<Animal> animals;
	
	@Before
	public void setUp(){
		level = new Level("2",  "/AnimalImages/Sheep.png", 3, AnimalType.PIG);
		animals = level.getAnimalsList();
	}
	
	@Test
	public void testDecimalMatchingBinary(){
		int digits=level.getDigits();
		
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
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		int num7 = 0;
		for(int i=0; i<10;i++){
			//String name, String backgroundFile, int numDigits, AnimalType animalType, String animalDrawFile 
			Level l = new Level("1",  "/AnimalImages/Sheep.png", 3, AnimalType.PIG);
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
				case 4: 
					num4++;
					break;
				case 5:
					num5++;
					break;
				case 6:
					num6++;
					break;
				case 7:
					num7++;
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
		assertTrue(num4>0);
		assertTrue(num5>0);
		assertTrue(num6>0);
		assertTrue(num7>0);
	}
	
	

}
