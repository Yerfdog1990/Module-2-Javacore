package Super_Extend_List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Animal {
    public void feed(){
        System.out.println("Animal.feed()");
    }
}
class Pet extends Animal{
    @Override
    public void feed(){
        System.out.println("Pet.call()");
    }
}
class Dog extends Pet{
    @Override
    public void feed(){
        System.out.println("Dog.barks()");
    }
}
class Horse extends Pet{
    @Override
    public void feed(){
        System.out.println("Horse.neighs()");
    }
}
class MainAnimal{
    public static void main(String[] args) {
        //List of animals
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());

        //List of Pets (A subclass of animal)
        List<Pet> petList = new ArrayList<>();
        petList.add(new Pet());

        //List of Dogs (A subclass of Pet)
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());

        //List of horses (A subclass of Pet)
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse());

        // Now we can call the method with any type of list
        System.out.println("Iterating over Animals:");
        iterateAnimals(animalList);

        System.out.println("\nIterating over Pets:");
        iterateAnimals(petList);

        System.out.println("\nIterating over Dogs:");
        iterateAnimals(dogList);

        System.out.println("\nIterating over Horses:");
        iterateAnimals(horseList);
    }
    // Method that can accept a collection of Animal or its subclasses
    public static void iterateAnimals(Collection<? extends Animal> animalCollection){
        for(Animal animal : animalCollection){
            System.out.println("Another step in the cycle completed!");
            animal.feed();
        }
    }
}
