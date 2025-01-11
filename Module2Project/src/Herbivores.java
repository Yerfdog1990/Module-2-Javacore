import java.util.*;


public class Herbivores extends Animal{
    public Herbivores(double weight, int maxPerLocation, int maxSpeed, double foodRequired) {
        super(weight, maxPerLocation, maxSpeed, foodRequired);
    }
    @Override
    public Location move(Location currentLocation, Island island) {
        Random random = new Random();
        int randomDirection = random.nextInt(4);
        return currentLocation.getNeighbor(randomDirection, island);
    }

    @Override
    public Animal breed() {
        if(Math.random() < 0.5){
            return new Herbivores(weight, maxPerLocation, maxSpeed, foodRequired);
        }
        return null;
    }

    @Override
    public String getType() {
        return "Herbivore";
    }

    @Override
    public void eat(List<Animal> animals, List<Plant> plants) {
        for(Plant plant : plants){
            plants.remove(plant); // Eat food
            currentFood += 1; // Food increases by 1kg
            break;
    }
}
    static class Boar extends Herbivores {
        public Boar() {
            super(15, 30, 1, 3);
        }
    }
    static class Buffalo extends Herbivores{
        public Buffalo() {
            super(700, 10, 3, 100);
        }
    }
    static class Caterpillar extends Herbivores{
        public Caterpillar() {
            super(0.01, 1000, 0, 0);
        }
    }
    static class Deer extends Herbivores{
        public Deer() {
            super(300, 20, 4, 50);
        }
    }
    static class Duck extends Herbivores{
        public Duck() {
            super(1, 200, 4, 0.15);
        }
    }
    static class Goat extends Herbivores{
        public Goat() {
            super(60, 140, 3, 10);
        }
    }
    static class Horse extends Herbivores{
        public Horse() {
            super(400, 20, 4, 60);
        }
    }
    static class Mouse extends Herbivores{
        public Mouse() {
            super(0.05, 500, 1, 0.01);
        }
    }
    static class Rabbit extends Herbivores{
        public Rabbit() {
            super(2, 150, 2, 0.45);
        }
    }
    static class Sheep extends Herbivores {
        public Sheep() {
            super(70, 140, 3, 15);
        }
    }
}
