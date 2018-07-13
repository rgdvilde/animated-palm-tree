package com.howtographql.hackernews;

import java.util.List;

public class Location {
//	type Location{
//		name: String!
//		price: Int
//		nameOwner: String
//		telephoneNumberOwner: String
//		adress: String
//		availablity: [Date]
//		distance: Int
//	}
	
	private String name;
	private int price;
	private String nameOwner;
	private String telephoneNumberOwner;
	private Adress adress;
	private List<Date> availability;
	private int distance;
	
	public Location(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public String getTelephoneNumberOwner() {
		return telephoneNumberOwner;
	}

	public Adress getAdress() {
		return adress;
	}

	public List<Date> getAvailability() {
		return availability;
	}

	public int getDistance() {
		return distance;
	}
	
	public List<Date> availablity(){
		return availability;
	}
	
	
}
