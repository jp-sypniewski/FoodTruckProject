## Food Truck Project

### Week 3 Homework - Skill Distillery

#### Overview

Users input and rate a list of (up to 5) food trucks, then view the average rating and the highest-rated truck.

#### Concepts

- Creating objects and manipulating the data retrieved from objects
- Getter methods for private fields within an object
- For loop with break for limited user input
- Infinite while loop with break when user quits program

#### Technologies Used

- Java

#### Lessons Learned

- Readability of code - everything for this project can be kept inside a main, but refactoring into methods provides drastically increased readability.
- Array sizing issues - since the user can input 5 or less trucks, the initial array is created to hold the maximum number of FoodTruck objects.  When calling methods to iterate over the array, the loop iterates until the count of objects actually entered rather than the entire array.
- Object instatiation from user input - the FoodTruck object requires three pieces of input from the user.  This program holds the user input in local variables until all input for an object in collected, then the object is instatiated.  Alternatively, the object could be instatiated prior to user input with an empty constructor.  This would require setters as the fields within FoodTruck are set to private.

#### Potential Updates

- Open project to more food establishment types than food trucks through utilization of superclasses.
- Defined interface for FoodTruckApp class would allow for development of other establishment-rating classes.
