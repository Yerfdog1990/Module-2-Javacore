package AnimalClub;

import java.util.*;
import java.util.stream.Collectors;

//Using Java streams to filter and sort the ginger cats more concisely.
public class Main2 {
    public static void main(String[] args) {
        Selector.collectData();  // Initialize the data

        // Using streams to filter, sort, and map cat names
        final List<String> findNames = Selector.getOwnerList().stream()
                .flatMap(owner -> owner.getPets().stream())  // Flatten the list of pets
                .filter(pet -> Cat.class.equals(pet.getClass()))  // Filter only cats
                .filter(cat -> Color.FOXY == cat.getColor())  // Filter only ginger (FOXY) cats
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())  // Sort by age in descending order
                .map(Animal::getName)  // Extract names of the cats
                .collect(Collectors.toList());  // Collect the names into a list

        // Print the names of ginger cats
        findNames.forEach(System.out::println);
    }
}

