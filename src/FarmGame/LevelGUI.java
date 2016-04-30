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
		g.drawImage(backgroundImage, 0, 0, null);
		BufferedImage toFind = null;
		try {
			toFind = ImageIO.read( getClass().getResource(fileName) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(toFind,0,0,null);
	}
	
	public void mouseClicked(MouseEvent e) {
		for (MapClickBox c : GameEngine.clickBoxes){
			if(c.contains(e.getX(), e.getY())){
				{ 
				maingui.goToLocation(c.getLocationType()); //This tells the MainGUI which location to draw
				removeMouseListener(this);
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

}
