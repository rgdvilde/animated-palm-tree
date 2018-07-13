package com.howtographql.hackernews;
import java.sql.SQLException;

import com.coxautodev.graphql.tools.GraphQLRootResolver;


public class Mutation implements GraphQLRootResolver {
    
//	type Mutation {
//		  createDate(day: Int!, month: Int!, year: Int!, weatherHigh: Int,weatherLow: Int): Date
//		  createLocation(name: String!,	price: Int,	nameOwner: String,	telephoneNumberOwner: String,	Adress: String,	Distance: Int): Location
//		  rentLocation(loc: Location!, dat: Date!): Int
//		}
    private final DateRepository dateR;
    private final LocationRepository locationR;

    public Mutation(DateRepository dateR, LocationRepository locationR) {
        this.dateR = dateR;
        this.locationR = locationR;
    }
    
    public Date createDate(int day, int month, int year, int temp) {
    	return new Date(day,month,year,temp);
    }
    //ation.createLocation(~name, ~price, ~nameOwner, ~telephoneNumberOwner, ~Adress, ~Distance [, g
    public Location createLocation(String name, int price, String nameOwner, String telephoneNumberOwner, String Adress, int Distance) throws java.sql.SQLException{
    	locationR.saveLocation(new Location(name));
    	return new Location(name);
    	
    }
    
    public int rentLocation(String locationname, int day, int month, int year) {
    	return locationR.locationRent(new Location(locationname), new Date(day,month,year));
    	
    }
    
    
}
