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
	BufferedImage backgroundImage = null;
	
	public LocationGUI(String fileName, ArrayList<Animal> animals) {
		this.animals = animals;
		animalLocations = new ArrayList<Point>();
		populate();
		try {
			backgroundImage = ImageIO.read( getClass().getResource(fileName) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
		for(int i=0; i<animals.size(); i++){
			animals.get(i).draw(g, (int)animalLocations.get(i).getX(), (int)animalLocations.get(i).getY());
			System.out.println("hi");
		}
	}

	//Gives set locations for animals
	public void populate(){
		//Left 100 is sidebar
		//And i'm just making up these points
		animalLocations.add(new Point(50, 250));
		animalLocations.add(new Point(50, 400));
		animalLocations.add(new Point(300, 250));
		animalLocations.add(new Point(300, 400));
		animalLocations.add(new Point(175, 250));
		animalLocations.add(new Point(175, 400));
	}
}
