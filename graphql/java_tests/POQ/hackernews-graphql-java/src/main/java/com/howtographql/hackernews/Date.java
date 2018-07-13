package com.howtographql.hackernews;

public class Date {
//	day: Int!
//    month: Int!
//    year: Int!
//    weatherHigh: Int
//    weatherLow: Int
	private int day;
	private int month;
	private int year;
	private int temperature;
	
	public Date(int day, int month, int year) {
		this(day,month,year,0);
	}
	
	public Date(int day, int month, int year, int temperature) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.temperature = temperature;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	
	
	
	
	
}
