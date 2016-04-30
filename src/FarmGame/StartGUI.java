package FarmGame;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartGUI extends JPanel implements MouseListener {

	private static final String[] files = {"/OpenerImages/StormyFarm.png","/OpenerImages/RadioWarning.png","/OpenerImages/Tornado.png"};
	private int currentImage = 0;
	private BufferedImage backgroundImage;
	private MainGUI maingui;

	public StartGUI( MainGUI maingui ) {

		this.maingui = maingui;
		
		drawImage();

		addMouseListener(this);

	}
	
	public void drawImage() {
		try {
			backgroundImage = ImageIO.read( getClass().getResource(files[currentImage]) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
	}

	public void mouseClicked(MouseEvent e) {
		currentImage++;
		
		if( currentImage == files.length) {
			removeMouseListener(this);
			maingui.startGame();
			return;
		}
		
		drawImage();
		repaint();
	
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}


}
