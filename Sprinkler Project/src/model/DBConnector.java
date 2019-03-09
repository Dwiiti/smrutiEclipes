package model;

import java.sql.*;

// in Sprinkler Project

public class DBConnector {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/sprinklersystem";
	static final String USER = "root";
	static final String PASS = "Qwer1234";
	
	public DBConnector()
	{
		Connection conn = null;
		Statement stmt = null;
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
	
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sprinklerSQL;
		      
		      sprinklerSQL = "Select * from sprinkler";
		      
		      ResultSet rs1 = stmt.executeQuery(sprinklerSQL);
		      while (rs1.next())
		      {
		    	  Sprinkler sp = new Sprinkler();
		    	 	sp.setId(rs1.getInt("SprinklerId"));
		    	 	sp.setGroup(rs1.getString("GroupID"));
		    	 	sp.setStatus(rs1.getBoolean("SprinklerStatus"));
		    	 	sp.setActive(rs1.getBoolean("SprinklerActive"));
		    	 	sp.setStartTime(rs1.getLong("StartTime"));
		    	 	sp.setEndTime(rs1.getLong("EndTime"));
		    	 	sp.setFlowRate(rs1.getDouble("FlowRate"));
		    	 	sp.setTemperature(rs1.getInt("tempurature"));
		    	 	
		    	 	sp.sprinklerList.add(sp);
		    	 
		       }
		     
		     
		      		      
		}catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }
		 System.out.println("Goodbye!");
	
	}

}
