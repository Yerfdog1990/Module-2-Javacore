import java.util.*;


// Herbivores class represents animals that mainly feed on plants and extends the Animal class.
public class Herbivores extends Animal {

    // Constructor to initialize Herbivores with specific properties like weight, maxPerLocation, maxSpeed, and foodRequired.
    public Herbivores(double weight, int maxPerLocation, int maxSpeed, double foodRequired) {
        super(weight, maxPerLocation, maxSpeed, foodRequired);
    }

    // Overridden move method: Determines a random direction and moves the Herbivore to a neighboring Location on the Island.
    @Override
    public Location move(Location currentLocation, Island island) {
        Random random = new Random(); // Random object to generate random numbers.
        int randomDirection = random.nextInt(4); // Generate a random direction (0 to 3).
        return currentLocation.getNeighbor(randomDirection, island); // Move to the neighbor in the random direction.
    }

    // Overridden breed method: Generates a new Herbivores offspring with a 50% probability.
    @Override
    public Animal breed() {
        if (Math.random() < 0.5) { // 50% chance to breed.
            return new Herbivores(weight, maxPerLocation, maxSpeed, foodRequired); // Create a new Herbivore offspring.
        }
        return null; // No offspring produced.
    }

    // Overridden getType method: Returns the type of the animal as "Herbivore".
    @Override
    public String getType() {
        return "Herbivore"; // Return type
    }

    // Overridden eat method: Animal eats plants from the available list and increases its food level.
    @Override
    public void eat(List<Animal> animals, List<Plant> plants) {
        for (Plant plant : plants) { // Iterate through the list of plants.
            plants.remove(plant); // Remove the eaten plant.
            currentFood += 1; // Increase food level by 1kg.
            break; // Stop after eating one plant.
        }
    }

    // Boar class: Represents a Hog-like herbivore with specific properties.
    static class Boar extends Herbivores {
        public Boar() {
            super(15, 30, 1, 3); // Weight: 15kg, Max per location: 30, Speed: 1, Food required: 3kg.
        }
    }

    // Buffalo class: Represents a large herbivore with specific weight and needs.
    static class Buffalo extends Herbivores {
        public Buffalo() {
            super(700, 10, 3, 100); // Weight: 700kg, Max per location: 10, Speed: 3, Food required: 100kg.
        }
    }

    // Caterpillar class: Represents a small crawling herbivore.
    static class Caterpillar extends Herbivores {
        public Caterpillar() {
            super(0.01, 1000, 0, 0); // Weight: 0.01kg, Max per location: 1000, Speed: 0, Food required: 0kg.
        }
    }

    // Deer class: Represents a common medium-sized herbivore.
    static class Deer extends Herbivores {
        public Deer() {
            super(300, 20, 4, 50); // Weight: 300kg, Max per location: 20, Speed: 4, Food required: 50kg.
        }
    }

    // Duck class: Represents a small, fast-moving herbivore.
    static class Duck extends Herbivores {
        public Duck() {
            super(1, 200, 4, 0.15); // Weight: 1kg, Max per location: 200, Speed: 4, Food required: 0.15kg.
        }
    }

    // Goat class: Represents a medium-sized herbivore often found in herds.
    static class Goat extends Herbivores {
        public Goat() {
            super(60, 140, 3, 10); // Weight: 60kg, Max per location: 140, Speed: 3, Food required: 10kg.
        }
    }

    // Horse class: Represents a large and fast-moving herbivore.
    static class Horse extends Herbivores {
        public Horse() {
            super(400, 20, 4, 60); // Weight: 400kg, Max per location: 20, Speed: 4, Food required: 60kg.
        }
    }

    // Mouse class: Represents a small and fast-moving herbivore often found in large numbers.
    static class Mouse extends Herbivores {
        public Mouse() {
            super(0.05, 500, 1, 0.01); // Weight: 0.05kg, Max per location: 500, Speed: 1, Food required: 0.01kg.
        }
    }

    // Rabbit class: Represents a small herbivore known for its speed and reproduction rate.
    static class Rabbit extends Herbivores {
        public Rabbit() {
            super(2, 150, 2, 0.45); // Weight: 2kg, Max per location: 150, Speed: 2, Food required: 0.45kg.
        }
    }

    // Sheep class: Represents a medium-sized herbivore commonly grazing in groups.
    static class Sheep extends Herbivores {
        public Sheep() {
            super(70, 140, 3, 15); // Weight: 70kg, Max per location: 140, Speed: 3, Food required: 15kg.
        }
    }
}
