package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

import controller.SortierenControl;

public class SortierenView extends JFrame {
	
	public List<JButton> buttons = new LinkedList<JButton>();
	private static final long serialVersionUID = -1129452994192643505L;
	private JTextField display = new JTextField();
	public SortierenControl controller;
	protected JFrame frame;
	/**
	 * 
	 */

	{
		this.display.setEditable(false);
		this.display.setSize(200, 60);
	}

	
	{
		for (int i = 0; i < 16; i++) {
			buttons.add(new JButton("" + i));
		}
		buttons.add(new JButton("Play"));
	}


	public SortierenView() {
		super("komisches Switch-Spiel");
		JFrame meinFrame = new JFrame("Mein JFrame Beispiel");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Panel tastenpanel = new Panel();
		GridLayout gbLayout = new GridLayout(4, 4);
		gbLayout.setHgap(5);
		gbLayout.setVgap(5);
		tastenpanel.setLayout(gbLayout);

		for (JButton i : buttons) {
			tastenpanel.add(this.buttons.get(buttons.indexOf(i)));
		}
		this.add(display, BorderLayout.SOUTH);
		this.add(tastenpanel, BorderLayout.CENTER);
		this.add(buttons.get(buttons.size()-1), BorderLayout.NORTH);
		
		for(JButton b: buttons) {b.addActionListener( controller);}
		this.setSize(800, 600);
		this.setVisible(true);
	}
	
	public void update(){
		display.setText(controller.model.timedAndRight());
		for(JButton b : buttons){
			if(b == buttons.get(buttons.size()-1)){
				b.setText("Play");
			}
			else{
				b.setText(""+controller.model.get(buttons.indexOf(b)));
			}
		}
	}
	
	public void setController(SortierenControl cont){
		this.controller = cont;
		
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
}