import java.util.*;

public abstract class Animal {
    protected double weight;
    protected int maxPerLocation;
    protected int maxSpeed;
    protected double foodRequired;
    protected double currentFood;

    //Constructor
    public Animal(double weight, int maxPerLocation, int maxSpeed, double foodRequired) {
        this.weight = weight;
        this.maxPerLocation = maxPerLocation;
        this.maxSpeed = maxSpeed;
        this.foodRequired = foodRequired;
        this.currentFood = 0;
    }

    //Abstract methods
    public abstract void eat(List<Animal> animals, List<Plant> plants);
    public abstract Location move(Location currentLocation, Island island);
    public abstract Animal breed();
    public abstract String getType();

    // Check if the animal is still hungry
    public boolean isHungry() {
        return currentFood < foodRequired / 2;
    }
}

