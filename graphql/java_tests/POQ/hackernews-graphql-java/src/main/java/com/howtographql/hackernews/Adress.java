package com.howtographql.hackernews;

public class Adress {
//	type Adress{
//		country: String!
//		city: String!
//		street: String!
//	}
	
	private String country;
	private String city;
	private String street;
	
	public Adress(String country, String city, String street) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}
	
	
	
	
}
