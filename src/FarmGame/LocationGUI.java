package FarmGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			backArrow = ImageIO.read( getClass().getResource("/BackgroundImages/BackArrow.png") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		//Left 100 is sidebar
		//And i'm just making up these points
		animalLocations.add(new Point(50, 250));
		animalLocations.add(new Point(50, 400));
		animalLocations.add(new Point(300, 250));
		animalLocations.add(new Point(300, 400));
		animalLocations.add(new Point(175, 250));
		animalLocations.add(new Point(175, 400));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getX() < 60 && e.getY() < 60 ){ // This makes the gui go back to the map if you click in the top left corner.
			//Should also go back to the map if you click on an animal
			
		GameEngine.currentLocation = null;
		LevelGUI level= new LevelGUI( maingui.theGame.getCurrentLevelLEVEL().getLookForFile(),
				maingui.theGame.getCurrentLevelLEVEL().getLocations(),
				maingui);

		maingui.displayPanel(level);
		removeMouseListener(this);
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
