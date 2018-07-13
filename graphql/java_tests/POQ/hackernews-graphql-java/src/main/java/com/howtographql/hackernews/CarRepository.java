package com.howtographql.hackernews;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarRepository {
	private final Connection c;
	
	public CarRepository(Connection c) {
		this.c = c;
	}
	
	public void saveCar(Car car) throws SQLException {
		Statement stmt = null;
		 stmt = c.createStatement();
         String sql = "INSERT INTO wagen"
            + " VALUES ("+car.getNummer()+",'"+car.getNaam()+"');";
         System.out.print("SQLSTRING:" + sql);
         stmt.executeUpdate(sql);
         stmt.close();
         c.commit();
         System.out.println("Records created successfully");

	}
	
	public Car getCarWithNumber(int nummer) throws SQLException{
		System.out.println("________________________1");
		Statement stmt = null;
		System.out.println("________________________2");
		stmt = c.createStatement();
		System.out.println("________________________3");
        ResultSet rs = stmt.executeQuery( "SELECT * FROM wagen;" );
        System.out.println("________________________4:");
        Car r = null;
        while(rs.next()){
        	System.out.println(rs.getInt("nummer"));
        	System.out.println(""+nummer);
        	if(rs.getInt("nummer")==nummer) {
        		int id = rs.getInt("nummer");
                String  name = rs.getString("naam");
                System.out.println("Car met naam:"  + name + " en nummer: " + id);
                r = new Car(id,name);
                break;
        	}
        	
        }
        return r;
//		return new Car(66,"Standaard");
	}
}
