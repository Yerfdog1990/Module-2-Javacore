package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

    // Compare two strings based on their length
    @Override
    public int compare(String obj1, String obj2) {
        return obj1.length() - obj2.length();  // Sort by string length (ascending)
    }

    // Implement the reversed() method to sort in reverse order
    @Override
    public Comparator<String> reversed() {
        return Comparator.super.reversed();
    }

    // Implement a method for alphabetical sorting
    public static Comparator<String> alphabetically() {
        return Comparator.naturalOrder();  // Sort alphabetically in ascending order
    }

    public static void main(String[] args) {
        // Create an ArrayList of strings
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "Hello", "World", "Welcome", "Java", "Programming");

        // Print the original list
        System.out.println("Original list:");
        for (String str : stringArrayList) {
            System.out.println(str);
        }

        // Sort the list by string length
        StringLengthComparator lengthComparator = new StringLengthComparator();
        Collections.sort(stringArrayList, lengthComparator);

        // Print the list sorted by string length
        System.out.println("\nSorted list by string length:");
        for (String str : stringArrayList) {
            System.out.println(str);
        }

        // Sort the list alphabetically
        Collections.sort(stringArrayList, alphabetically());

        // Print the list sorted alphabetically
        System.out.println("\nSorted list alphabetically:");
        for (String str : stringArrayList) {
            System.out.println(str);
        }

        // Sort the list by string length in reverse order
        Collections.sort(stringArrayList, lengthComparator.reversed());

        // Print the list sorted by string length in reverse order
        System.out.println("\nSorted list by string length (reversed):");
        for (String str : stringArrayList) {
            System.out.println(str);
        }
    }
}

