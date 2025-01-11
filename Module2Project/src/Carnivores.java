import java.util.*;

public class Carnivores extends Animal{
    public Carnivores(double weight, int maxPerLocation, int maxSpeed, double foodRequired) {
        super(weight, maxPerLocation, maxSpeed, foodRequired);
    }

    @Override
    public void eat(List<Animal> animals, List<Plant> plants) {
        for(Animal prey : animals){
            if(prey instanceof Herbivores && isHungry() && Math.random() < getHuntingprobability(prey)){
                animals.remove(prey);
                currentFood += prey.weight;
            }
        }
    }

    @Override
    public Location move(Location currentLocation, Island island) {
        Random random = new Random();
        int randomDirection = random.nextInt(4);
        return currentLocation.getNeighbor(randomDirection, island);
    }

    @Override
    public Animal breed() {
        if(Math.random() < 0.5){ // 50% chance of breeding
            return new Carnivores(weight, maxPerLocation, maxSpeed, foodRequired);
        }
        return null;
    }

    @Override
    public String getType() {
        return "Carnivore";
    }

    // Private method to determine hunting success for prey
    private double getHuntingprobability(Animal prey) {
        if (this instanceof Wolf && prey instanceof Fox) {
            return 0.8;
        }
        if (this instanceof Bear && prey instanceof Fox) {
            return 0.7;
        }
        if (this instanceof Eagle && prey instanceof Fox) {
            return 0.6;
        }
        if (this instanceof Wolf && prey instanceof Boa) {
            return 0.5;
        }
        return 0.2; // Default low chance
    }

    static class Wolf extends Carnivores{
        public Wolf() {
            super(50, 30, 3, 3);
        }
    }

    static class Boa extends Carnivores{
        public Boa() {
            super(15, 30, 1, 3);
        }
    }

    static class Fox extends Carnivores{
        public Fox() {
            super(8, 30, 2, 2);
        }
    }

    static class Bear extends Carnivores{
        public Bear() {
            super(500, 5, 2, 80);
        }
    }

    static class Eagle extends Carnivores{
        public Eagle() {
            super(6, 20, 3, 1);
        }
    }
}
