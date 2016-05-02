package FarmGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LocationGUI extends JPanel implements MouseListener {

	private ArrayList<Animal> animals;
	private ArrayList<Point> animalLocations; 
	BufferedImage backgroundImage = null;
	BufferedImage backArrow = null;
	MainGUI maingui;
	
	public LocationGUI(LocationType currentLocation, ArrayList<Animal> animals, MainGUI main) {
		this.animals = animals;
		maingui = main;
		
		animalLocations = new ArrayList<Point>();
		populate();
		try {
			backgroundImage = ImageIO.read( getClass().getResource(currentLocation.getfileName() ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			backArrow = ImageIO.read( getClass().getResource("/BackgroundImages/BackArrow.png") );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
		g.drawImage(backArrow, 5, 5, null);
		for(int i=0; i<animals.size(); i++){
			animals.get(i).draw(g, (int)animalLocations.get(i).getX(), (int)animalLocations.get(i).getY());
			
		}
	}

	//Gives set locations for animals
	public void populate(){
		//And i'm just making up these points
		animalLocations.add(new Point(50, 250));
		animalLocations.add(new Point(50, 400));
		animalLocations.add(new Point(300, 250));
		animalLocations.add(new Point(300, 400));
		animalLocations.add(new Point(175, 250));
		animalLocations.add(new Point(175, 400));
	}

	//checks to see if animal that was just clicked on is in the checklist
	//Not sure what we want to do if it is not in the checklist. We discussed a punishment of some sort but not sure if we're still doing that
	public boolean checkAnimalToChecklist(Animal a) {
		if (a.found(maingui.getTheGame().getCurrentLevelLEVEL().getChecklist().getChecklist())) {
			//If in checklist do something
			a.setFound(true);
			maingui.updateChecklistGUI();
			return true;
		}
		//else punishment. Or nothing. Whichever
		return false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX() < 60 && e.getY() < 60 ){ // This makes the gui go back to the map if you click in the top left corner.
			//Also goes back to the map if you click on an animal, after checking to see if animal is in the checklist.
			maingui.returnToMap();	
			removeMouseListener(this);
		}
//		if (e.getX() > 50 && e.getX() < 100 && e.getY() > 250 && e.getY() < 335) {
//			checkAnimalToChecklist(animals.get(0));
//			backToMap();	
//			removeMouseListener(this);
//		}
//		if (e.getX() > 50 && e.getX() < 100 && e.getY() > 400 && e.getY() < 485) {
//			checkAnimalToChecklist(animals.get(1));
//			backToMap();	
//			removeMouseListener(this);
//		}
//		if (e.getX() > 175 && e.getX() < 225 && e.getY() > 250 && e.getY() < 335) {
//			checkAnimalToChecklist(animals.get(2));
//			backToMap();	
//			removeMouseListener(this);
//		}
//		if (e.getX() > 175 && e.getX() < 225 && e.getY() > 400 && e.getY() < 485) {
//			checkAnimalToChecklist(animals.get(3));
//			backToMap();	
//			removeMouseListener(this);
//		}
//		if (e.getX() > 300 && e.getX() < 350 && e.getY() > 250 && e.getY() < 335) {
//			checkAnimalToChecklist(animals.get(4));
//			backToMap();	
//			removeMouseListener(this);
//		}
//		if (e.getX() > 300 && e.getX() < 350 && e.getY() > 400 && e.getY() < 485) {
//			checkAnimalToChecklist(animals.get(5));
//			backToMap();	
//			removeMouseListener(this);
//		}
		
		//just since we might want to change the location of the animals, or add more
		for(Animal a : animals){
			if (a.getRectangle().contains(e.getX(),e.getY())) {
				if(checkAnimalToChecklist(a))
					JOptionPane.showMessageDialog(this, "Good Job! You found one of your animals!");
				else
					JOptionPane.showMessageDialog(this, "Oops! That wasn't one of your animals!");
				removeMouseListener(this);
				maingui.returnToMap();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}


}
