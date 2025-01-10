import java.util.HashMap;
import java.util.Map;

public class Herbivores {
    static class Boar extends Animal{
        private final Map<String, Double> preyProbability = new HashMap<>();
        public Boar() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;

            // Initialize prey and probabilities
            preyProbability.put("Herbivores.Mouse", 0.25);
            preyProbability.put("Plants", 0.4);
            preyProbability.put("Herbivores.Caterpillar", 0.1);
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Buffalo extends Animal{
        public Buffalo() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Caterpillar extends Animal{
        private final Map<String, Double> preyProbability = new HashMap<>();
        public Caterpillar() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;

            // Initialize prey and probabilities
            preyProbability.put("Plants", 0.25);
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Deer extends Animal{
        public Deer() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Duck extends Animal{
        private final Map<String, Double> preyProbability = new HashMap<>();
        public Duck() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;

            // Initialize prey and probabilities
            preyProbability.put("Herbivores.Caterpillar", 0.25);
            preyProbability.put("Plants", 0.4);
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Goat extends Animal{
        public Goat() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Horse extends Animal{
        public Horse() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Mouse extends Animal{
        public Mouse() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Rabbit extends Animal{
        public Rabbit() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Sheep extends Animal{
        public Sheep() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;
        }

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }
}
