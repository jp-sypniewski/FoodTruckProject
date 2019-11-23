package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {
	
	// fields
	
	private int maxTrucks = 5;
	private String truckNameHolder;
	private String truckFoodTypeHolder;
	private int truckRatingHolder;
	private FoodTruck[] foodTruckArray = new FoodTruck[maxTrucks];

	// constructor
	
	public FoodTruckApp() {

	}
	
	// methods

	public void printMenu() {
		System.out.println("Select an option and enter your integer choice: ");
		System.out.println("1: List all food trucks");
		System.out.println("2: Average rating of food trucks");
		System.out.println("3: Display highest-rated food truck");
		System.out.println("4: Quit");
	}

	public void printAllTrucks(FoodTruck[] foodTruckArray, int truckCount) {
		for (int i = 0; i < truckCount; i++) {
			System.out.println("---------------");
			foodTruckArray[i].displayTruck();
			System.out.println("---------------");
		}
	}

	public double getTruckAverageRating(FoodTruck[] foodTruckArray, int truckCount) {
		double rating = 0;
		for (int i = 0; i < truckCount; i++) {
			rating += foodTruckArray[i].getRating();
		}
		rating = rating / truckCount;

		return rating;
	}

	public FoodTruck getHighestRatedTruck(FoodTruck[] foodTruckArray, int truckCount) {
		FoodTruck highestRated = foodTruckArray[0];
		for (int i = 0; i < truckCount; i++) {
			if (foodTruckArray[i].getRating() > highestRated.getRating()) {
				highestRated = foodTruckArray[i];
			}
		}
		return highestRated;
	}
	
	// main

	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.run();

	}
	
	// run

	public void run() {
		Scanner kb = new Scanner(System.in);

		int choice = 0;
		int truckCounter = 0;
		System.out.println(
				"Welcome to the FoodTruckApp!\nYou will be asked to enter information on up to (5) food trucks.");

		for (int i = 0; i < maxTrucks; i++) {
			System.out.println("Enter a truck name, or \"quit\" to move forward: ");
			truckNameHolder = kb.nextLine();
			
			if (truckNameHolder.equalsIgnoreCase("quit")) {
				break;
			}
			
			System.out.println("Enter " + truckNameHolder + " food type:");
			truckFoodTypeHolder = kb.nextLine();
			
			System.out.println("Enter " + truckNameHolder + " rating: ");
			truckRatingHolder = kb.nextInt();
			kb.nextLine();
			
			foodTruckArray[i] = new FoodTruck(truckNameHolder, truckFoodTypeHolder, truckRatingHolder);
			truckCounter++;
		}

		if (truckCounter == 0) {
			System.out.println("You have entered 0 food trucks, thanks for using the FoodTruckApp!");
		}

		while (truckCounter != 0) {
			printMenu();
			choice = kb.nextInt();
			
			if (choice == 1) {
				printAllTrucks(foodTruckArray, truckCounter);
				
			} else if (choice == 2) {
				double average = getTruckAverageRating(foodTruckArray, truckCounter);
				System.out.println("---------------");
				System.out.println("The average rating is: " + average);
				System.out.println("---------------");
				
			} else if (choice == 3) {
				FoodTruck highestRated = getHighestRatedTruck(foodTruckArray, truckCounter);
				System.out.println("---------------");
				System.out.println("The highest rated truck is: ");
				highestRated.displayTruck();
				System.out.println("---------------");

			} else if (choice == 4) {
				System.out.println("Thanks for using the FoodTruckApp!");
				break;
				
			} else {
				System.out.println("Please select an option 1-4!");
				
			}
		}

		kb.close();
	}
}
