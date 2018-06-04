package model;

import java.util.LinkedList;
import java.util.List;

import controller.SortierenControl;

public class SortierenModel {
	private int[] arr;
	private boolean started;
	private long startTime;
	private int buttonOne;
	private int buttonTwo;
	public SortierenControl controller;
	
	public int get(int i){
		return arr[i];
	}
	
	public void setController(SortierenControl cont){
		this.controller = cont;
	}
	
	public SortierenModel(int h, int w) {
		arr = new int[h * w];
		this.fillArray();
		this.started = false;
	}

	public void start() {
		this.started = true;
		this.startTime = System.currentTimeMillis();
	}
	
	public void newOrder(int i){
		
	if(buttonOne==-1){
		buttonOne=i;
		return;
	}
	if(buttonTwo==-1){
		buttonTwo=i;
	}
	this.switchValuesOfIndeces(buttonOne, buttonTwo);
	buttonOne=-1;
	buttonTwo=-1;
	return;
	
		
	}

	public String timedAndRight() {
		if (started == false) {
			return "Start the game";
		} else {
			long timed = System.currentTimeMillis() - this.startTime;
			double right = this.getCorrectness() * 100;
			return "" + right + "%(" + timed / 1000.0 + " sec)";
		}
	}
	
	

	public void switchValuesOfIndeces(int a, int b) {
		int dummy = arr[a];
		this.arr[a] = arr[b];
		this.arr[b] = dummy;
	}

	public boolean isCorrect() {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				return false;
			}
		}
		return true;
	}

	public double getCorrectness() {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i + 1) {
				sum++;
			}
		}
		return sum / (double) arr.length;
	}
//this may cause exceptions, implementation just restarts if thats the case
	public void fillArray(){
		try{
			this.buttonOne=-1;
			this.buttonTwo=-1;
			List<Integer> list = new LinkedList<Integer>();
			for (int i = 1; i <= arr.length; i++) {
				list.add(i);
			}

			for (int i = 0; i < arr.length; i++) {
				do {
					arr[i] = list.get((int)( Math.random() * list.size()));
					if (i == arr.length - 1 && arr[i] == i + 1) {
						this.switchValuesOfIndeces(0, i);
					}
				} while (arr[i] == i + 1);
				list.remove(list.indexOf(arr[i]));
			}
		}catch(Exception e){
			fillArray();
		}
		
	}

	public void reset() {
		System.out.println("Reset");
	}

	
}