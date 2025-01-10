import java.util.*;


public class Location {
    private List<Animal> animalList;
    private List<Plant> plantList;

    public Location() {
        this.animalList = new ArrayList<>();
        this.plantList = new ArrayList<>();
    }

    public synchronized void addAnimal(Animal animal){
        animalList.add(animal);
    }
    public synchronized void removeAnimal(Animal animal){
        animalList.remove(animal);
    }
    public synchronized void addPlant(Plant plant){
        plantList.add(plant);
    }
    public synchronized void removePlant(Plant plant){
        plantList.remove(plant);
    }
    public synchronized List<Animal> getAnimalList() {
        return animalList;
    }
    public synchronized List<Plant> getPlantList() {
        return plantList;
    }
    // Include methods for animal interactions like feeding, breeding, etc.
}
