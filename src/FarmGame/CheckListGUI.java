package FarmGame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CheckListGUI extends JPanel {

	ArrayList<Animal> animals = new ArrayList<Animal>();

	public CheckListGUI(ArrayList<Animal> animals){
		this.animals = animals;
		setLayout(new GridLayout(1,0));
		makeLayout();
	}

	public void makeLayout(){
		setLayout(new GridLayout(1,0));
		JPanel listOfAnimals = animals();
		add(listOfAnimals);
	}

	private JPanel animals(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7,1));
		panel.setBorder(new TitledBorder(new EtchedBorder(), ""));

		Font font = new Font("Comic Sans MS", Font.PLAIN, 25);
		JLabel field = new JLabel("Animals to Find:");
		field.setFont(font);

		field.setPreferredSize( new Dimension(200,100) );
		
		field.setHorizontalAlignment(JLabel.CENTER);
	    field.setVerticalAlignment(JLabel.CENTER);
		
		panel.add(field);

		for (Animal a : animals){
			panel.add( animal( a ) );
		}

		return panel;
	}
	
	private JLabel animal( Animal animal ) {
		
		JLabel number = new JLabel( Integer.toString(animal.getDecimalValue()) );
		
		Font font = new Font("Comic Sans MS", Font.PLAIN, 50);
		
		if( animal.getFound() ) {
			Map attributes = font.getAttributes();
			attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
			font = new Font(attributes);
		}
		
		number.setFont(font);
	    
	    number.setHorizontalAlignment(JLabel.CENTER);
	    number.setVerticalAlignment(JLabel.CENTER);
		
		return number;
	}
	
	
}
