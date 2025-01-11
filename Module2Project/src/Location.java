import java.util.*;


public class Location {
    private List<Animal> animalList;
    private List<Plant> plantList;

    public Location() {
        this.animalList = new ArrayList<>();
        this.plantList = new ArrayList<>();
    }

    public synchronized List<Animal> getAnimal(){
        return new ArrayList<>(animalList); // Return a copy to prevent concurrency issues
    }
    public synchronized List<Plant> getPlant(){
        return new ArrayList<>(plantList);
    }
    public synchronized void addAnimal(Animal animal){
        if(animalList.size() < animal.maxPerLocation){
            animalList.add(animal);
        }
    }
    public synchronized void removeAnimal(Animal animal){
        animalList.remove(animal);
    }
    public synchronized void addPlant(Plant plant){
        if(plantList.size() < Plant.MAX_PLANTS){
            plantList.add(plant);
        }
    }
    public Location getNeighbor(int direction, Island island){
        return island.getNeighbor(this, direction);
    }
}
