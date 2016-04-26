package FarmGame;

import java.awt.Graphics;
import java.util.ArrayList;

public class Animal {

	private AnimalType animalType;
	private int digits;
	private int decimalValue;
	private String binaryValue;
	private boolean found = false;
	private String drawFile;
	
	public Animal(AnimalType animalType, String drawFile, int decimalValue, int digits) {
		
		this.animalType = animalType;
		this.drawFile = drawFile;
		this.digits = digits;
		this.decimalValue = decimalValue;
		binaryValue = convertToBinary(decimalValue);
		
	}

	public boolean found(ArrayList<Animal> checklist){
		if(checklist.contains(this)){
			found = true;
			return false;
		}
		return false;
	}
	
	public void draw(Graphics g){
		
	}
	
	//Helper function to convert decimal to binary
	public String convertToBinary(int decNumber){
		int binaryDigitValue = (int) Math.pow(2, digits-1);
		String binaryNumber = "";
		for(int i=0; i < digits; i++){
			if(decNumber - binaryDigitValue >= 0){
				decNumber -= binaryDigitValue;
				binaryNumber += "1";
			}
			else{
				binaryNumber+="0";
			}
			binaryDigitValue = binaryDigitValue / 2;
		}
		return binaryNumber;
		
	}
	
	//Getters
	public int getDecimalValue(){
		return decimalValue;
	}
	
	public String getBinaryValue(){
		return binaryValue;
	}
	
	public boolean getFound(){
		return found;
	}
}
