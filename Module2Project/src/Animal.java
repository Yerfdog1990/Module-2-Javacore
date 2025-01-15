// Importing all utility classes from the java.util package
import java.util.*;

public abstract class Animal {
    // The weight of the animal in kilograms
    protected double weight;
    // Maximum number of this type of animal allowed in a single location
    protected int maxPerLocation;
    // Maximum speed of the animal in kilometers per hour
    protected int maxSpeed;
    // Amount of food required in kilograms for the animal to survive
    protected double foodRequired;
    // Current amount of food consumed by the animal
    protected double currentFood;

    //Constructor
    // Constructor to initialize an Animal object with its attributes
    public Animal(double weight, int maxPerLocation, int maxSpeed, double foodRequired) {
        // Set the weight of the animal
        this.weight = weight;
        // Set the maximum number of this type of animal allowed in a location
        this.maxPerLocation = maxPerLocation;
        // Set the animal's maximum speed
        this.maxSpeed = maxSpeed;
        // Set the amount of food required for survival
        this.foodRequired = foodRequired;
        // Initialize the current food consumed to zero
        this.currentFood = 0;
    }

    //Abstract methods
    // Abstract method to define how the animal eats, interacting with other animals and plants
    public abstract void eat(List<Animal> animals, List<Plant> plants);
    // Abstract method to define how the animal moves between locations on the island
    public abstract Location move(Location currentLocation, Island island);
    // Abstract method to define how the animal reproduces and returns a new instance of itself
    public abstract Animal breed();
    // Abstract method to return the type of the animal as a string
    public abstract String getType();

    // Check if the animal is still hungry
    // Method to check if the animal is still hungry
    public boolean isHungry() {
        // Returns true if the current food consumed is less than half of the required amount
        return currentFood < foodRequired / 2;
    }
}

