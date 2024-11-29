package StreamChallenges.CarHire.AnimalClub;

import java.util.*;

//Using traditional loops and collections to filter and sort the ginger cats by age.
public class Main1 {
    public static void main(String[] args) {
        Selector.collectData();  // Initialize the data

        List<String> findNames = new ArrayList<>();
        List<Cat> findCats = new ArrayList<>();

        // Loop through each owner list and their pets to find ginger cats
        for (Owner owner : Selector.getOwnerList()) {
            for (Animal pet : owner.getPets()) {
                // Check if the pet is a Cat and has FOXY color
                if (Cat.class.equals(pet.getClass()) && Color.FOXY == pet.getColor()) {
                    findCats.add((Cat) pet);  // Add the ginger cat to the list
                }
            }
        }

        // Sort the cats by age in descending order
        Comparator<Cat> catComparator = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o2.getAge() - o1.getAge();
            }
        };
        Collections.sort(findCats, catComparator);

        // Extract the names of the cats
        for (Cat cat : findCats) {
            findNames.add(cat.getName());
        }

        // Print the names of ginger cats
        findNames.forEach(System.out::println);
    }
}
