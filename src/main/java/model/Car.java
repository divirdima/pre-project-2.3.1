package model;

import java.util.Random;

public class Car {
	private int year;
	private long model;
	private String country;
	private final Random rand = new Random();	
	private String[] Countries = {"USA","UKRAINE","RUSSIA","ROMANIA","AUSTRALIA","JAPAN",
							"GREECE","ITALY","MONTENEGRO","FRANCE","UK","CANADA"};
	
	public Car() {
		year = Math.abs(rand.nextInt() % 2022);
		model =  Math.abs(rand.nextLong() % 10000);
		country = Countries[Math.abs(rand.nextInt() % Countries.length)];
	}

	public int getYear() {
		return year;
	}

	public long getModel() {
		return model;
	}

	public String getCountry() {
		return country;
	}
	
}
