package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Sprinkler;
import model.ChangeStatus;
import view.SprinklerView;


public class SprinklerController {
	
	private SprinklerView sprinklerview;
	private ChangeStatus tm;
	private int hourS, hourE , minS, minE;
	
	ArrayList<Sprinkler> slist = new ArrayList<Sprinkler>();

	
	public SprinklerController( SprinklerView sprinklerview , ChangeStatus tm )
	{
		this.sprinklerview = sprinklerview;
		this.tm = tm;
		
		this.sprinklerview.tglbtn0Listener(new tglbtn0());
		this.sprinklerview.tglbtn1Listener(new tglbtn1());
		this.sprinklerview.tglbtn2Listener(new tglbtn2());
		this.sprinklerview.tglbtn3Listener(new tglbtn3());
		this.sprinklerview.tglbtn4Listener(new tglbtn4());
		this.sprinklerview.tglbtn5Listener(new tglbtn5());
		this.sprinklerview.tglbtn6Listener(new tglbtn6());
		this.sprinklerview.tglbtn7Listener(new tglbtn7());
		this.sprinklerview.tglbtn8Listener(new tglbtn8());
		this.sprinklerview.tglbtn9Listener(new tglbtn9());
		
		
		// Group toggle Button:
		this.sprinklerview.northtglbtnListener(new northTglBtn());
		this.sprinklerview.southtglbtnListener(new southTglBtn());
		this.sprinklerview.easttglbtnListener(new eastTglBtn());
		this.sprinklerview.westtglbtnListener(new westTglBtn());
		
		// Sprinkler System Toggle button
		this.sprinklerview.tglbtnSprinklerListener(new SprinklerSystem());
		sprinklerview.startTime();
		displayMap();
		
	}
	
	public void updateList()
	{
		// sprinkler 0 set Status in ArrayList
		
		Sprinkler.sprinklerList.get(0).setActive(sprinklerview.getLabel0());
		//sprinkler 1 set Status in ArrayList
		Sprinkler.sprinklerList.get(1).setActive(sprinklerview.getLabel1());
		//sprinkler 2 set Status in ArrayList
		Sprinkler.sprinklerList.get(2).setActive(sprinklerview.getLabel2());
		//sprinkler 3 set Status in ArrayList
		Sprinkler.sprinklerList.get(3).setActive(sprinklerview.getLabel3());
		// sprinkler 4 set Status in ArrayList
		
		Sprinkler.sprinklerList.get(4).setActive(sprinklerview.getLabel4());
		//sprinkler 5 set Status in ArrayList
		Sprinkler.sprinklerList.get(5).setActive(sprinklerview.getLabel5());
		//sprinkler 6 set Status in ArrayList
		Sprinkler.sprinklerList.get(6).setActive(sprinklerview.getLabel6());
		//sprinkler 7 set Status in ArrayList
		Sprinkler.sprinklerList.get(7).setActive(sprinklerview.getLabel7());
		//sprinkler 8 set Status in ArrayList
		Sprinkler.sprinklerList.get(8).setActive(sprinklerview.getLabel8());
		//sprinkler 9 set Status in ArrayList
		Sprinkler.sprinklerList.get(9).setActive(sprinklerview.getLabel9());
				
		
		System.out.println(Sprinkler.sprinklerList.get(0).isActive()+" "
				+ Sprinkler.sprinklerList.get(1).isActive()+ " "
				+  Sprinkler.sprinklerList.get(2).isActive()+ " "
				+ Sprinkler.sprinklerList.get(3).isActive()+ " "
				+ Sprinkler.sprinklerList.get(4).isActive()+ " "
				+ Sprinkler.sprinklerList.get(5).isActive()+ " "
				+ Sprinkler.sprinklerList.get(6).isActive()+ " "
				+ Sprinkler.sprinklerList.get(7).isActive()+ " "
				+ Sprinkler.sprinklerList.get(8).isActive()+ " "
				+ Sprinkler.sprinklerList.get(9).isActive()+ " ");
		
	}
	
	// Action performed when toggle button 0 is clicked.
	class tglbtn0 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SprinklerView.flag0 = 1;
			sprinklerview.setLabel0(tm.changeStatus(0),Sprinkler.getSprinklerList().get(0).isStatus());
			
			updateList();
			
			if(Sprinkler.getSprinklerList().get(0).isActive() && Sprinkler.getSprinklerList().get(4).isActive() 
					&& Sprinkler.getSprinklerList().get(8).isActive())
			{
				sprinklerview.setNorthStatusButton("ON");
			}
			else if(!Sprinkler.getSprinklerList().get(0).isActive() && !Sprinkler.getSprinklerList().get(4).isActive() 
					&& !Sprinkler.getSprinklerList().get(8).isActive())
			{
				sprinklerview.setNorthStatusButton("OFF");
			}
		}
		
	}
	// Action performed when toggle button 1 is clicked.
	class tglbtn1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SprinklerView.flag1=1;
			sprinklerview.setLabel1(tm.changeStatus(1));
			updateList();
			
			if(Sprinkler.getSprinklerList().get(1).isActive() && Sprinkler.getSprinklerList().get(5).isActive() 
					&& Sprinkler.getSprinklerList().get(9).isActive())
			{
				sprinklerview.setSouthStatusButton("ON");
			}
			else if(!Sprinkler.getSprinklerList().get(1).isActive() && !Sprinkler.getSprinklerList().get(5).isActive() 
					&& !Sprinkler.getSprinklerList().get(9).isActive())
			{
				sprinklerview.setSouthStatusButton("OFF");
			}
			
		}
		
	}
	// Action performed when toggle button 2 is clicked.
	class tglbtn2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			SprinklerView.flag2=1;
			// TODO Auto-generated method stub
			
			sprinklerview.setLabel2(tm.changeStatus(2));
			updateList();
			
			if(Sprinkler.getSprinklerList().get(2).isActive() && Sprinkler.getSprinklerList().get(6).isActive() 
					)
			{
				sprinklerview.setEastStatusButton("ON");
			}
			else if(!Sprinkler.getSprinklerList().get(2).isActive() && !Sprinkler.getSprinklerList().get(6).isActive() 
					)
			{
				sprinklerview.setEastStatusButton("OFF");
			}
			
		}
		
	}
	// Action performed when toggle button 3 is clicked.
	class tglbtn3 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SprinklerView.flag3=1;
			sprinklerview.setLabel3(tm.changeStatus(3));
			updateList();
			
			if(Sprinkler.getSprinklerList().get(3).isActive() && Sprinkler.getSprinklerList().get(7).isActive() 
					)
			{
				sprinklerview.setWestStatusButton("ON");
			}
			else if(!Sprinkler.getSprinklerList().get(3).isActive() && !Sprinkler.getSprinklerList().get(7).isActive() 
					)
			{
				sprinklerview.setWestStatusButton("OFF");
			}
			
		}
		
	}
	
	// Action performed when toggle button 4 is clicked.
		class tglbtn4 implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SprinklerView.flag4 = 1;
				sprinklerview.setLabel4(tm.changeStatus(4));
				updateList();
				if(Sprinkler.getSprinklerList().get(0).isActive() && Sprinkler.getSprinklerList().get(4).isActive() 
						&& Sprinkler.getSprinklerList().get(8).isActive())
				{
					sprinklerview.setNorthStatusButton("ON");
				}
				else if(!Sprinkler.getSprinklerList().get(0).isActive() && !Sprinkler.getSprinklerList().get(4).isActive() 
						&& !Sprinkler.getSprinklerList().get(8).isActive())
				{
					sprinklerview.setNorthStatusButton("OFF");
				}
			}
			
		}
		
		// Action performed when toggle button 5 is clicked.
		class tglbtn5 implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SprinklerView.flag5=1;
				sprinklerview.setLabel5(tm.changeStatus(5));
				updateList();
				
				if(Sprinkler.getSprinklerList().get(1).isActive() && Sprinkler.getSprinklerList().get(5).isActive() 
						&& Sprinkler.getSprinklerList().get(9).isActive())
				{
					sprinklerview.setSouthStatusButton("ON");
				}
				else if(!Sprinkler.getSprinklerList().get(1).isActive() && !Sprinkler.getSprinklerList().get(5).isActive() 
						&& !Sprinkler.getSprinklerList().get(9).isActive())
				{
					sprinklerview.setSouthStatusButton("OFF");
				}
				
				
			}
			
		}
		// Action performed when toggle button 6 is clicked.
		class tglbtn6 implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SprinklerView.flag6=1;
				sprinklerview.setLabel6(tm.changeStatus(6));
				updateList();
				
				if(Sprinkler.getSprinklerList().get(2).isActive() && Sprinkler.getSprinklerList().get(6).isActive() 
						)
				{
					sprinklerview.setEastStatusButton("ON");
				}
				else if(!Sprinkler.getSprinklerList().get(2).isActive() && !Sprinkler.getSprinklerList().get(6).isActive() 
						)
				{
					sprinklerview.setEastStatusButton("OFF");
				}
				
			}
			
		}
		// Action performed when toggle button 7 is clicked.
		class tglbtn7 implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SprinklerView.flag7=1;
				sprinklerview.setLabel7(tm.changeStatus(7));
				updateList();
				if(Sprinkler.getSprinklerList().get(3).isActive() && Sprinkler.getSprinklerList().get(7).isActive() 
						)
				{
					sprinklerview.setWestStatusButton("ON");
				}
				else if(!Sprinkler.getSprinklerList().get(3).isActive() && !Sprinkler.getSprinklerList().get(7).isActive() 
						)
				{
					sprinklerview.setWestStatusButton("OFF");
				}
				
			}
			
		}
		// Action performed when toggle button 8 is clicked.
		class tglbtn8 implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SprinklerView.flag8 = 1;
				sprinklerview.setLabel8(tm.changeStatus(8));
				updateList();
				if(Sprinkler.getSprinklerList().get(0).isActive() && Sprinkler.getSprinklerList().get(4).isActive() 
						&& Sprinkler.getSprinklerList().get(8).isActive())
				{
					sprinklerview.setNorthStatusButton("ON");
				}
				else if(!Sprinkler.getSprinklerList().get(0).isActive() && !Sprinkler.getSprinklerList().get(4).isActive() 
						&& !Sprinkler.getSprinklerList().get(8).isActive())
				{
					sprinklerview.setNorthStatusButton("OFF");
				}
			}
			
		}
		// Action performed when toggle button 9 is clicked.
		class tglbtn9 implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SprinklerView.flag9=1;
				sprinklerview.setLabel9(tm.changeStatus(9));
				updateList();
				
				if(Sprinkler.getSprinklerList().get(1).isActive() && Sprinkler.getSprinklerList().get(5).isActive() 
						&& Sprinkler.getSprinklerList().get(9).isActive())
				{
					sprinklerview.setSouthStatusButton("ON");
				}
				else if(!Sprinkler.getSprinklerList().get(1).isActive() && !Sprinkler.getSprinklerList().get(5).isActive() 
						&& !Sprinkler.getSprinklerList().get(9).isActive())
				{
					sprinklerview.setSouthStatusButton("OFF");
				}
				
			}
			
		}
	
	// Action Performed when North group toggle button is pressed
	class northTglBtn implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SprinklerView.flagNorth = 1;
			sprinklerview.getNorthStatus();
			if(sprinklerview.getNorthStatus()== "ON")
			{
				sprinklerview.setNorthStatusButton("OFF");
			}
			else
				{sprinklerview.setNorthStatusButton("ON");}
			updateList();
		
		}
		
	}
	
	// Action Performed when South group toggle button is pressed
		class southTglBtn implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SprinklerView.flagSouth = 1;
				sprinklerview.getSouthStatus();
				if(sprinklerview.getSouthStatus()== "ON")
				{
					sprinklerview.setSouthStatusButton("OFF");
				}
				else
					{sprinklerview.setSouthStatusButton("ON");}
				
				updateList();
			}
			
		}
		
	// Action Performed when East group toggle button is pressed
		class eastTglBtn implements ActionListener
		{
				@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					SprinklerView.flagEast=1;
				sprinklerview.getEastStatus();
				if(sprinklerview.getEastStatus()== "ON")
				{
					sprinklerview.setEastStatusButton("OFF");
				}
				else
				{	sprinklerview.setEastStatusButton("ON");
				
				}
				updateList();
			}
					
		}
		
	// Action Performed when West group toggle button is pressed
		class westTglBtn implements ActionListener
		{
				@Override
			public void actionPerformed(ActionEvent e) 
				{
				// TODO Auto-generated method stub
					SprinklerView.flagWest=1;
				sprinklerview.getWestStatus();
				if(sprinklerview.getWestStatus()== "ON")
				{
					sprinklerview.setWestStatusButton("OFF");
					
				}
				else
				{
					sprinklerview.setWestStatusButton("ON");
					
				}
				updateList();
				}
							
		}
		
 // Action Performed when Sprinkler system toggle button is pressed
		class SprinklerSystem implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(sprinklerview.getSprinklerSysStatus())
				{
					
					sprinklerview.setSprinklerSysStatus(false);
					sprinklerview.setEastStatusButton("OFF");
					sprinklerview.setWestStatusButton("OFF");
					sprinklerview.setNorthStatusButton("OFF");
					sprinklerview.setSouthStatusButton("OFF");
					sprinklerview.setButton(false);
				}
				else
				{sprinklerview.setSprinklerSysStatus(true);
				sprinklerview.setButton(true);
				}
				
				}
			}
			
		
	
	public void displayMap()
	{
		// get whole Sprinkler List
		slist = tm.getSprinklerList();
		// 
		sprinklerview.setLabel0(Sprinkler.getSprinklerList().get(0).isActive(),Sprinkler.getSprinklerList().get(0).isStatus() );
		sprinklerview.setLabel1(Sprinkler.getSprinklerList().get(1).isActive());
		sprinklerview.setLabel2(Sprinkler.getSprinklerList().get(2).isActive());
		sprinklerview.setLabel3(Sprinkler.getSprinklerList().get(3).isActive());
		sprinklerview.setLabel4(Sprinkler.getSprinklerList().get(4).isActive());
		sprinklerview.setLabel5(Sprinkler.getSprinklerList().get(5).isActive());
		sprinklerview.setLabel6(Sprinkler.getSprinklerList().get(6).isActive());
		sprinklerview.setLabel7(Sprinkler.getSprinklerList().get(7).isActive());
		sprinklerview.setLabel8(Sprinkler.getSprinklerList().get(8).isActive());
		sprinklerview.setLabel9(Sprinkler.getSprinklerList().get(9).isActive());
		
		sprinklerview.setNorthFR(Sprinkler.getSprinklerList().get(0).getFlowRate());
		sprinklerview.setSouthFR(Sprinkler.getSprinklerList().get(1).getFlowRate());
		sprinklerview.setEastFR(Sprinkler.getSprinklerList().get(2).getFlowRate());
		sprinklerview.setWestFR(Sprinkler.getSprinklerList().get(3).getFlowRate());
		
		
		//North Group
		hourS=(int) (Sprinkler.getSprinklerList().get(0).getStartTime() / 60);
		minS = (int)(Sprinkler.getSprinklerList().get(0).getStartTime() % 60);
		hourE=(int) (Sprinkler.getSprinklerList().get(0).getEndTime() / 60);
		minE = (int)(Sprinkler.getSprinklerList().get(0).getEndTime() % 60);
		sprinklerview.northTime(hourS,minS,hourE,minE);
		
		//South Group
		hourS=(int) (Sprinkler.getSprinklerList().get(1).getStartTime() / 60);
		minS = (int)(Sprinkler.getSprinklerList().get(1).getStartTime() % 60);
		hourE=(int) (Sprinkler.getSprinklerList().get(1).getEndTime() / 60);
		minE = (int)(Sprinkler.getSprinklerList().get(1).getEndTime() % 60);
		sprinklerview.southTime(hourS,minS,hourE,minE);
		
		//East Group
		hourS=(int) (Sprinkler.getSprinklerList().get(2).getStartTime() / 60);
		minS = (int)(Sprinkler.getSprinklerList().get(2).getStartTime() % 60);
		hourE=(int) (Sprinkler.getSprinklerList().get(2).getEndTime() / 60);
		minE = (int)(Sprinkler.getSprinklerList().get(2).getEndTime() % 60);
		sprinklerview.eastTime(hourS,minS,hourE,minE);
		
		//West Group
		hourS=(int) (Sprinkler.getSprinklerList().get(3).getStartTime() / 60);
		minS = (int)(Sprinkler.getSprinklerList().get(3).getStartTime() % 60);
		hourE=(int) (Sprinkler.getSprinklerList().get(3).getEndTime() / 60);
		minE = (int)(Sprinkler.getSprinklerList().get(3).getEndTime() % 60);
		sprinklerview.westTime(hourS,minS,hourE,minE);
		
	}
	
	
}
