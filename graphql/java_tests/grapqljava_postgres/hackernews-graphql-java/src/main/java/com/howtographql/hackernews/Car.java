package com.howtographql.hackernews;

public class Car {
	private final int nummer;
	private final String naam;
	
	public Car(int nummer, String naam) {
		this.nummer = nummer;
		this.naam = naam;
	}

	public int getNummer() {
		return nummer;
	}

	public String getNaam() {
		return naam;
	}
	
	
}
