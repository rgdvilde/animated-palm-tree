package com.howtographql.hackernews;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LocationRepository {
	private final Connection c;
	
	public LocationRepository(Connection c) {
		this.c = c;
	}
	
	public void saveLocation(Location l) throws SQLException{
//		Statement stmt = null;
//		 stmt = c.createStatement();
//        String sql = "INSERT INTO wagen"
//           + " VALUES ("+car.getNummer()+",'"+car.getNaam()+"');";
//        System.out.print("SQLSTRING:" + sql);
//        stmt.executeUpdate(sql);
//        stmt.close();
//        c.commit();
//        System.out.println("Records created successfully");
		
		Statement stmt = null;
		stmt = c.createStatement();
		String sql = "INSERT INTO Location"
	           + " VALUES ("
				+43+",'"
				+l.getName()+"',"
				+l.getPrice()+",'"
				+l.getNameOwner()+"','"
				+l.getTelephoneNumberOwner()+"','"
				+l.getAdress().getCountry()+"','"
				+l.getAdress().getCity() + "','"
				+l.getAdress().getStreet()
				+"');";
		
		stmt.executeUpdate(sql);
		stmt.close();
		c.commit();
	}
	
	public int locationRent(Location l, Date t) {
		// td
		return 0;
	}
}
