import java.util.*;

public class Carnivores extends Animal{
    // Constructor for the Carnivores class. It initializes the carnivore with specific weight, maximum number
    // of animals of this type per location, maximum speed, and food required for survival.
    public Carnivores(double weight, int maxPerLocation, int maxSpeed, double foodRequired) {
        super(weight, maxPerLocation, maxSpeed, foodRequired);
    }

    // This method determines how the carnivore eats prey in its location.
    @Override
    public void eat(List<Animal> animals, List<Plant> plants) {
        // Iterate over the list of animals to find potential prey.
        for(Animal prey : animals){
            // If the prey is a herbivore, the carnivore is hungry, and it successfully hunts based on probability:
            if(prey instanceof Herbivores && isHungry() && Math.random() < getHuntingprobability(prey)){
                // Remove the prey from the animals list, simulating it being eaten.
                animals.remove(prey);
                // Increase the carnivore's food intake by the weight of the prey.
                currentFood += prey.weight;
            }
        }
    }

    // This method simulates the carnivore's movement to a neighboring location.
    @Override
    public Location move(Location currentLocation, Island island) {
        // Generate a random integer from 0 to 3 to represent a random direction (e.g., North, South, East, West).
        Random random = new Random();
        int randomDirection = random.nextInt(4);
        // Return the neighboring location in the randomly chosen direction.
        return currentLocation.getNeighbor(randomDirection, island);
    }

    // This method simulates the breeding process for the carnivore.
    @Override
    public Animal breed() {
        // Check if breeding happens, with a 50% probability of success.
        if(Math.random() < 0.5){ 
            // Create and return a new carnivore with the same properties as the parent.
            return new Carnivores(weight, maxPerLocation, maxSpeed, foodRequired);
        }
        // If breeding is unsuccessful, return null.
        return null;
    }

    // Returns a string indicating the type of the animal as "Carnivore".
    @Override
    public String getType() {
        return "Carnivore";
    }

    // Private method to determine hunting success for prey
    // Calculates the probability of successfully hunting a given prey based on the types of predators and prey.
    private double getHuntingprobability(Animal prey) {
        // Wolves are highly likely to catch foxes (80% chance).
        if (this instanceof Wolf && prey instanceof Fox) {
            return 0.8;
        }
        // Bears are slightly less likely to catch foxes (70% chance).
        if (this instanceof Bear && prey instanceof Fox) {
            return 0.7;
        }
        // Eagles have a moderate chance of catching foxes (60% chance).
        if (this instanceof Eagle && prey instanceof Fox) {
            return 0.6;
        }
        // Wolves have a lower chance of catching boas (50% chance).
        if (this instanceof Wolf && prey instanceof Boa) {
            return 0.5;
        }
        // Default low chance of success for other predator-prey combinations.
        return 0.2;
    }

    // Represents a specific type of carnivore: Wolf, with predefined attributes.
    static class Wolf extends Carnivores{
        public Wolf() {
            super(50, 30, 3, 3); // Weight: 50, Max per location: 30, Speed: 3, Food required: 3.
        }
    }

    // Represents a specific type of carnivore: Boa, with predefined attributes.
    static class Boa extends Carnivores{
        public Boa() {
            super(15, 30, 1, 3); // Weight: 15, Max per location: 30, Speed: 1, Food required: 3.
        }
    }

    // Represents a specific type of carnivore: Fox, with predefined attributes.
    static class Fox extends Carnivores{
        public Fox() {
            super(8, 30, 2, 2); // Weight: 8, Max per location: 30, Speed: 2, Food required: 2.
        }
    }

    // Represents a specific type of carnivore: Bear, with predefined attributes.
    static class Bear extends Carnivores{
        public Bear() {
            super(500, 5, 2, 80); // Weight: 500, Max per location: 5, Speed: 2, Food required: 80.
        }
    }

    // Represents a specific type of carnivore: Eagle, with predefined attributes.
    static class Eagle extends Carnivores{
        public Eagle() {
            super(6, 20, 3, 1); // Weight: 6, Max per location: 20, Speed: 3, Food required: 1.
        }
    }
}
