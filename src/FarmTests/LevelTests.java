package FarmTests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import FarmGame.GameEngine;
import FarmGame.Level;
import FarmGame.Location;

public class LevelTests {
	
		private static Level level;
		private static GameEngine gEngine;
		private static Location location;
		
		
		//We will probably need to modify the BeforeClass once we start to write the methods
		@BeforeClass
		public static void setUp() {
			level = new Level();
			gEngine = new GameEngine();
			location = new Location();
		}
	
		//I am assuming we will have two methods to test in regards to converting binary numbers. Converting 
		//decimal to binary and converting binary to decimal
		@Test
		public void testBinary() {
			assertEquals(level.binaryToDecimal(0),0000);
			assertEquals(level.binaryToDecimal(1),0001);
			assertEquals(level.binaryToDecimal(3),0011);
			assertEquals(level.binaryToDecimal(6),0110);
			assertEquals(level.binaryToDecimal(15),1111);
			//Tests the binary to decimal method
			
			assertEquals(level.decimalToBinary(0000),0);
			assertEquals(level.decimalToBinary(0001),1);
			assertEquals(level.decimalToBinary(0011),3);
			assertEquals(level.decimalToBinary(0110),6);
			assertEquals(level.decimalToBinary(1111),15);
			//Tests the decimal to binary method
		}
		
		@Test
		public void levelOrderTest() {
			assertEquals(gEngine.getCurrentLevel(),1);
			gEngine.nextLevel();
			assertEquals(gEngine.getCurrentLevel(),2);
			gEngine.nextLevel();
			assertEquals(gEngine.getCurrentLevel(),3);
			//Tests if levels are increased in a sequential order
		}
		
		@Test
		public void animalLocation() {
			assertEquals(location.getAnimals().size(),4);
			//Tests that there are 4 animals per location
			int animalCounter = 0;
			for (Location l : level.getLocations()) {
				animalCounter += l.getAnimals().size();
			}
			assertEquals(animalCounter,16);
			//This goes through every location in levels and adds the amount of animals in each location
			//(I am assuming 4 locations) and tests to see if there is the correct amount of animals in the level
		}
		
		public void locationCorrectAnswer() {
			
		}

}