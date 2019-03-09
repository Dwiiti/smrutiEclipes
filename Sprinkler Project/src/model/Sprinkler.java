package model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Sprinkler {
	
		private int id;			
		private String group;
		private long startTime; 	
		private long endTime;		
		private long timeActive;
		private double flowRate;	
		private boolean status;		
		private boolean active;	
		private int temperature;
		
		public int getTemperature() {
			return temperature;
		}

		public void setTemperature(int temperature) {
			this.temperature = temperature;
		}

		public static ArrayList <Sprinkler> sprinklerList = new ArrayList<Sprinkler>();

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getGroup() {
			return group;
		}

		public void setGroup(String group) {
			this.group = group;
		}

		public long getStartTime() {
			return startTime;
		}

		public void setStartTime(long startTime) {
			this.startTime = startTime;
		}

		public long getEndTime() {
			return endTime;
		}

		public void setEndTime(long endTime) {
			this.endTime = endTime;
		}

		public long getTimeActive() {
			return timeActive;
		}

		public void setTimeActive(long timeActive) {
			this.timeActive = timeActive;
		}

		public double getFlowRate() {
			return flowRate;
		}

		public void setFlowRate(double flowRate) {
			this.flowRate = flowRate;
		}

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public static ArrayList<Sprinkler> getSprinklerList() {
			return sprinklerList;
		}

		public static void setSprinklerList(ArrayList<Sprinkler> sprinklerList) {
			Sprinkler.sprinklerList = sprinklerList;
		}
			


}
