package com.howtographql.hackernews;

import java.io.InputStream;
import java.io.InputStreamReader;



import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;
import com.coxautodev.graphql.tools.GraphQLRootResolver;

public class Query implements GraphQLRootResolver {
    
//	type Query {
//		  getDates(weatherHigh: Int, weatherLow: Int, loc: Location): Date
//		  getLocation(dat: Date, dis: Int): Location
//		}
	
	
	private final DateRepository dateR;
    private final LocationRepository locationR;

    public Query(DateRepository dateR, LocationRepository locationR) {
        this.dateR = dateR;
        this.locationR = locationR;
    }

    public List<Date> getDates(int temp, String locationname){
    	return null;
    }
    
    public List<Location> getLocations(int day, int month, int year, int dis){
    	return null;
    }
    
    public Date getDate(int day, int month, int year) throws java.io.UnsupportedEncodingException, java.net.MalformedURLException {
    	Date d = new Date(day,month,year);
    	System.out.println("___NEWDAT:" + day + " "  + month + " "  +year);
    	return dateR.addTemperature(d);
    }
    
}