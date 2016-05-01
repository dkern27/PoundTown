package FarmGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Animal {

	private AnimalType animalType;
	private int digits;
	private int decimalValue;
	private String binaryValue;
	private boolean found = false;
	private String drawFile;
	private Rectangle rect;
	
	public Animal(AnimalType animalType, int decimalValue, int digits) {
		
		this.animalType = animalType;
		this.drawFile = animalType.getFileName();
		this.digits = digits;
		this.decimalValue = decimalValue;
		binaryValue = convertToBinary(decimalValue);
		
	}

	public boolean found(ArrayList<Animal> checklist){
		if(checklist.contains(this)){
			found = true;
		}
		return found;
	}
	
	public void draw(Graphics g, int x, int y){
		BufferedImage animalImage = null;
		try {
			animalImage = ImageIO.read( getClass().getResource(drawFile) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(animalImage, x, y, null);
		rect = new Rectangle(x,y,75,95); //the area that the image takes up which you can click on
		g.drawString(Integer.toString(decimalValue), x+30, y-10);
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
	
	public void setFound(boolean f){
		found = f;
	}

	public Rectangle getRectangle() {
		return rect;
	}
}
