package com.skilldistillery.foodtrucks;

public class FoodTruck {
	
	// fields
	
	private int id;
	private String name;
	private String foodType;
	private int rating;

	private static int idCounter = 0;
	
	// constructor

	public FoodTruck(String truckName, String truckFoodType, int truckRating) {
		this.name = truckName;
		this.foodType = truckFoodType;
		this.rating = truckRating;
		this.id = idCounter;
		idCounter++;
	}
	
	// methods

	public void displayTruck() {
		System.out.println("Truck: " + name);
		System.out.println("Food type: " + foodType);
		System.out.println("Rating: " + rating);
	}

	public void displayTruckWithID() {
		System.out.println("Truck: " + name);
		System.out.println("Food type: " + foodType);
		System.out.println("Rating: " + rating);
		System.out.println("Id: " + id);
	}

	public int getRating() {
		return rating;
	}

	public String getName() {
		return name;
	}

}
