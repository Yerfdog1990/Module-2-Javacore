import java.util.*;

public abstract class Animal {
    protected double weight;
    protected int maxPerLocation;
    protected int maxSpeed;
    protected double foodRequired;
    protected double foodEaten = 0.0;

    //Constructor
    public Animal(double weight, int maxPerLocation, int maxSpeed, double foodRequired, double foodEaten) {
        this.weight = weight;
        this.maxPerLocation = maxPerLocation;
        this.maxSpeed = maxSpeed;
        this.foodRequired = foodRequired;
        this.foodEaten = foodEaten;
    }

    //Abstract methods
    public abstract void eat(List<Animal> animals, List<Plant> plants);
    public abstract void move(Location currentLocation, Island island);
    public abstract void breed();

    // Common method to check if the animal is starving
    public boolean isStarving() {
        return foodEaten < foodRequired / 2;
    }
}

