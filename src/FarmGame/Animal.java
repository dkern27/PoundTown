package FarmGame;

public class Animal {

	private AnimalType animalType;
	private int digits;
	private int decimalValue;
	private int binaryValue;
	private boolean found = false;
	private String drawFile;
	
	public Animal(AnimalType animalType, String drawFile, int decimalValue, int digits) {
		
		this.animalType = animalType;
		this.drawFile = drawFile;
		this.digits = digits;
		
	}

	public void found(){
		
	}
	
	public void draw(){
		
	}
	
	//Helper function to convert decimal to binary
	public int convertToBinary(){
		return 0;
	}
	
	//Getters
	public int getDecimalValue(){
		return 0;
	}
	
	public int getBinaryValue(){
		return 0;
	}
}
