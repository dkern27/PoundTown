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
		
	}
	
	@Test
	public void testDecimalMatchingBinary(){
		int digits; //Need  to get from levels or animal or something
		for(Animal a : animals){
			int dec = a.getDecimalValue();
			String bin = Integer.toString(a.getBinaryValue());
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
	
	

}
