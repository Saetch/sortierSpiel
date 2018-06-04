package controller;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import model.SortierenModel;
import view.SortierenView;

public class SortierenControl implements ActionListener {

	public SortierenView view;
	public SortierenModel model;
	private Timer updateTimer;
	public SortierenControl(SortierenView view, SortierenModel model) {
		this.view= view;
		this.model=model;
		model.setController(this);
		view.setController(this);
		updateTimer = new Timer();
		updateTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				view.update();
			}
		}, 10, 10);
		for(JButton b : view.buttons){
			b.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == view.buttons.get(view.buttons.size()-1)){
			model.start();
		}
		else{
		model.newOrder(view.buttons.indexOf(ev.getSource()));
		}
	}

}
