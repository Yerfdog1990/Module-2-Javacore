// Importing all utility classes from the java.util package
import java.util.*;

public class Location {
    // List to store all animals in this location
    private List<Animal> animalList;
    // List to store all plants in this location
    private List<Plant> plantList;

    // Constructor to initialize empty lists for animals and plants
    public Location() {
        this.animalList = new ArrayList<>();
        this.plantList = new ArrayList<>();
    }

    // Synchronized method to retrieve a copy of the list of animals
    public synchronized List<Animal> getAnimal(){
        return new ArrayList<>(animalList); // Return a copy to prevent concurrency issues
    }

    // Synchronized method to retrieve a copy of the list of plants
    public synchronized List<Plant> getPlant(){
        return new ArrayList<>(plantList); // Return a copy to prevent concurrency issues
    }

    // Synchronized method to add an animal to the list if it does not exceed the allowed maximum
    public synchronized void addAnimal(Animal animal){
        if(animalList.size() < animal.maxPerLocation){
            animalList.add(animal); // Add animal if the size limit isn't reached
        }
    }

    // Synchronized method to remove an animal from the list
    public synchronized void removeAnimal(Animal animal){
        animalList.remove(animal); // Remove the specified animal
    }

    // Synchronized method to add a plant to the list if the maximum number is not exceeded
    public synchronized void addPlant(Plant plant){
        if(plantList.size() < Plant.MAX_PLANTS){ // MAX_PLANTS is a predefined constant
            plantList.add(plant); // Add plant if the size limit isn't reached
        }
    }

    // Method to get a neighboring location, based on direction and island object
    public Location getNeighbor(int direction, Island island){
        return island.getNeighbor(this, direction); // Get the neighboring location from the island
    }

    // Getter method to retrieve the actual list of animals (not synchronized and should be used carefully)
    public List<Animal> getAnimalList() {
        return animalList;
    }

    // Getter method to retrieve the actual list of plants (not synchronized and should be used carefully)
    public List<Plant> getPlantList() {
        return plantList;
    }
}
