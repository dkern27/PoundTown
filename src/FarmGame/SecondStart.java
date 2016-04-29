package FarmGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class SecondStart extends JDialog{

	public SecondStart( ) {
		setTitle("Welcome to #Town!");
		setSize(500, 270);
		setLocation(250,200);
		setLayout(new FlowLayout());
		
		JPanel main = new JPanel();
		JPanel button = new JPanel();
		
//		JLabel message = new JLabel("Welcome to #Town! This is a great place, where nothing exciting ever happens. All your farm animals will be very happy here! They'll like.....", JLabel.CENTER);
//		main.add(message);
		
		Font font = new Font("Comic Sans MS", Font.PLAIN, 20);
		
		JTextArea message = new JTextArea("OH GOD A TORNADO JUST HIT AND TOOK YOUR ANIMALS!! You must explore the island and find them. "
				+ "Luckily, you kept a list of all your animals. Find an animal by matching the Decimal value in your checklist to the Binary value on each animal.");
		message.setBackground(Color.CYAN);
		message.setFont(font);
		message.setSize(new Dimension(450,150));
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		main.add(message);
		
		
		JButton nextWindow = new JButton("OK!");
		nextWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				
			}
		});

		
		button.add(nextWindow);
		
		add(main);
		add(button);
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
}

