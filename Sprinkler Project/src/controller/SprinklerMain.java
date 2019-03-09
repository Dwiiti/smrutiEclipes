package controller;

import view.SprinklerView;

import model.DBConnector;
import model.Sprinkler;
import model.ChangeStatus;



public class SprinklerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnector dbconnector = new DBConnector();
		
		SprinklerView view = new SprinklerView();
		ChangeStatus tm = new ChangeStatus();
		
		SprinklerController sprinklerController = new SprinklerController(view, tm);
		
	}

}
