package FarmGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LocationGUI extends JPanel{

	private ArrayList<Animal> animals;
	private ArrayList<Point> animalLocations; 
	
	public LocationGUI(String fileName, ArrayList<Animal> animals) {
		this.animals = animals;
		BufferedImage backgroundImage = null;
		try {
			backgroundImage = ImageIO.read( getClass().getResource(fileName) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon( backgroundImage ));
		add(picLabel);
	}
	
	public void paintComponent(Graphics g){
		for(int i=0; i<animals.size(); i++){
			animals.get(i).draw(g, (int)animalLocations.get(0).getX(), (int)animalLocations.get(0).getY());
		}
	}

	public void populate(){
		//Left 200 is sidebar
		animalLocations.add(new Point(250, 10));
	}
}
