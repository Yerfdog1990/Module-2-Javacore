import java.util.*;

public class Carnivores {
    static class Wolf extends Animal{
        private final Map<String, Double> preyProbability = new HashMap<>();
        public Wolf() {
            this.weight = 50;
            this.maxPerLocation = 30;
            this.maxSpeed = 3;
            this.foodRequired = 8;

            // Initialize prey and probabilities
            preyProbability.put("Herbivores.Rabbit", 0.25);
            preyProbability.put("Herbivores.Mouse", 0.4);
            preyProbability.put("Herbivores.Duck", 0.1);
            preyProbability.put("Herbivores.Caterpillar", 0.1);
        }

        @Override
        public void eat() {
            Random random = new Random();
            for (Map.Entry<String, Double> entry : preyProbability.entrySet()) {
                String prey = entry.getKey();
                Double probability = entry.getValue();
                if (random.nextDouble() < probability) {
                    System.out.println("Wolf successfully ate a " + prey);
                    break;
                }
            }
        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Boa extends Animal{
        private final Map<String, Double> preyProbability = new HashMap<>();
        public Boa() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;

            // Initialize prey and probabilities
            preyProbability.put("Carnivores.Fox", 0.25);
            preyProbability.put("Herbivores.Rabbit", 0.4);
            preyProbability.put("Herbivores.Mouse", 0.1);
            preyProbability.put("Herbivores.Duck", 0.1);
        }
        @Override
        public void eat() {
            Random random = new Random();
            for (Map.Entry<String, Double> entry : preyProbability.entrySet()) {
                String prey = entry.getKey();
                Double probability = entry.getValue();
                if (random.nextDouble() < probability) {
                    System.out.println("Carnivores.Boa successfully ate a " + prey);
                    break;
                }
            }
        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Fox extends Animal{
        private final Map<String, Double> preyProbability = new HashMap<>();
        public Fox() {
            this.weight = 20;
            this.maxPerLocation = 10;
            this.maxSpeed = 1;
            this.foodRequired = 2;

            // Initialize prey and probabilities
            preyProbability.put("Herbivores.Rabbit", 0.25);
            preyProbability.put("Herbivores.Mouse", 0.4);
            preyProbability.put("Herbivores.Duck", 0.1);
            preyProbability.put("Herbivores.Caterpillar", 0.1);
        }

        @Override
        public void eat() {
            Random random = new Random();
            for (Map.Entry<String, Double> entry : preyProbability.entrySet()) {
                String prey = entry.getKey();
                Double probability = entry.getValue();
                if (random.nextDouble() < probability) {
                    System.out.println("Fox successfully ate a " + prey);
                    break;
                }
            }
        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }

    static class Bear extends Animal{
        private final Map<String, Double> preyProbability = new HashMap<>();

        public Bear() {
            this.weight = 10;
            this.maxPerLocation = 5;
            this.maxSpeed = 1;
            this.foodRequired = 1;

            // Initialize prey and probabilities
            preyProbability.put("Carnivores.Boa", 0.25);
            preyProbability.put("Herbivores.Deer", 0.4);
            preyProbability.put("Herbivores.Rabbit", 0.2);
            preyProbability.put("Herbivores.Mouse", 0.1);
            preyProbability.put("Herbivores.Goat", 0.1);
            preyProbability.put("Herbivores.Sheep", 0.1);
            preyProbability.put("Herbivores.Boar", 0.1);
            preyProbability.put("Herbivores.Buffalo", 0.1);
            preyProbability.put("Herbivores.Duck", 0.1);
        }

        @Override
        public void eat() {
            Random random = new Random();
            for (Map.Entry<String, Double> entry : preyProbability.entrySet()) {
                String prey = entry.getKey();
                Double probability = entry.getValue();
                if (random.nextDouble() < probability) {
                    System.out.println("Carnivores.Bear successfully ate a " + prey);
                    break;
                }
            }
        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {
            Random random = new Random();
            if (random.nextDouble() < 0.5 && this.maxPerLocation > 1) { // Example condition for reproduction
                System.out.println("A new Carnivores.Bear is born!");
                Bear newBear = new Bear(); // Create a new bear instance
                // Logic for adding this bear to the location population can be added here
            } else {
                System.out.println("Reproduction conditions not met.");
            }
        }
    }

    static class Eagle extends Animal{
        private final Map<String, Double> preyProbability = new HashMap<>();
        public Eagle() {
            this.weight = 100;
            this.maxPerLocation = 20;
            this.maxSpeed = 2;
            this.foodRequired = 10;

            // Initialize prey and probabilities
            preyProbability.put("Carnivores.Fox", 0.25);
            preyProbability.put("Herbivores.Rabbit", 0.4);
            preyProbability.put("Herbivores.Mouse", 0.1);
            preyProbability.put("Herbivores.Duck", 0.1);
        }

        @Override
        public void eat() {
            Random random = new Random();
            for (Map.Entry<String, Double> entry : preyProbability.entrySet()) {
                String prey = entry.getKey();
                Double probability = entry.getValue();
                if (random.nextDouble() < probability) {
                    System.out.println("Eagle successfully ate a " + prey);
                    break;
                }
            }
        }

        @Override
        public void move() {

        }

        @Override
        public void breed() {

        }
    }
}
