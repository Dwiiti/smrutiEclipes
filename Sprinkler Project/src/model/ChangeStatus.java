package model;

import java.util.ArrayList;

import view.SprinklerView;

public class ChangeStatus {

	private Sprinkler sprinkler;
	
	public ArrayList<Sprinkler> getSprinklerList()
	{
		return sprinkler.getSprinklerList();
		
	}
	
	// Modify ArrayList
	/**
	 * 
	 * @param a
	 * @return
	 */
	public boolean changeStatus(int a)
	{
		if(sprinkler.sprinklerList.get(a).isActive())
		{
			 sprinkler.sprinklerList.get(a).setActive(false);
			 return false;
		}
		else
			sprinkler.sprinklerList.get(a).setActive(true);
			return true;
	}
	
	
	
	
}
