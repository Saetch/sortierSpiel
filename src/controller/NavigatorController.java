package controller;

import model.SortierenModel;
import view.SortierenView;

public class NavigatorController {
	
	

	private static SortierenModel model;
	private static SortierenView view ;
	private static SortierenControl controller;
	
	public static void main(String [] args){
		model = new SortierenModel(4, 4);
		view = new SortierenView();
		controller = new SortierenControl(view, model);
		
	}

}
