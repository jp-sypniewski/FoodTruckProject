package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int maxTrucks = 5;
		String truckNameHolder;
		String truckFoodTypeHolder;
		int truckRatingHolder;
		FoodTruck[] foodTruckArray = new FoodTruck[5];
		int choice = 0;
		int truckCounter = 0;

		for (int i = 0; i < maxTrucks; i++) {
			System.out.println("Enter a truck name, or 'quit' to move forward: ");
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

		while (truckCounter != 0) {
			System.out.println("Select an option and enter your integer choice: ");
			System.out.println("1: List all food trucks");
			System.out.println("2: Average rating of food trucks");
			System.out.println("3: Display highest-rated food truck");
			System.out.println("4: Quit");
			choice = kb.nextInt();
			if (choice == 1) {
				for (int i = 0; i < truckCounter; i++) {
					foodTruckArray[i].displayTruck();
				}
			} else if (choice == 2) {
				double rating = 0;
				for (int i = 0; i < truckCounter; i++) {
					rating += foodTruckArray[i].getRating();
				}
				rating = rating / truckCounter;
				System.out.println("The average rating is: " + rating);
			} else if (choice == 3) {
				FoodTruck highestRated = foodTruckArray[0];
				for (int i = 0; i < truckCounter; i++) {
					if (foodTruckArray[i].getRating() > highestRated.getRating()) {
						highestRated = foodTruckArray[i];
					}
				}
				System.out.println("The highest rated truck is: ");
				highestRated.displayTruck();

			} else if (choice == 4) {
				break;
			} else {
				System.out.println("Bad selection try again");
			}
		}

		kb.close();
	}
}
