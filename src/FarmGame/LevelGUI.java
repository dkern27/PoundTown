package FarmGame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LevelGUI extends JPanel implements MouseListener {
	
	Map <LocationType,Location> locations;
	String fileName;
	BufferedImage backgroundImage;
	
	MainGUI maingui;
	
	public LevelGUI( String fileName, Map <LocationType, Location> l, MainGUI maingui ) {
		
		locations = l;
		this.maingui = maingui;
		
		this.fileName=fileName;
		
		//BufferedImage backgroundImage = null;
		try {
			backgroundImage = ImageIO.read( getClass().getResource("/BackgroundImages/GeneralMap.jpg") );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		addMouseListener(this);
		
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//draw background
		g.drawImage(backgroundImage, 0, 0, null);
		
		//make toFind image
		BufferedImage toFind = null;
		try {
			toFind = ImageIO.read( getClass().getResource(fileName) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//draw toFind image
		g.drawImage(toFind,0,0,null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for (MapClickBox c : GameEngine.clickBoxes){
			if(c.contains(e.getX(), e.getY())){
				
				GameEngine.currentLocation = c.getLocationType();
				LocationGUI loc = new LocationGUI( GameEngine.currentLocation,
						maingui.theGame.getCurrentLocation().getAnimals(),
						maingui );
				maingui.displayPanel(loc);
				
				removeMouseListener(this);
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
