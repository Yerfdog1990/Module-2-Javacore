package SyntacticSugar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringLengthComparator {
    public static void main(String[] args) {
        // Create an ArrayList of strings
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "Hello", "World", "Welcome", "Java", "Programming");

        // Create an anonymous inner class to implement Comparator<String>
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String string1, String string2) {
                return string2.length() - string1.length();
            }
        };
        // Sort the list using the comparator
        Collections.sort(stringArrayList, stringComparator);

        // Print the sorted list
        System.out.println("Sorted by length:");
        for(String str: stringArrayList){
            System.out.println(str);
        }
    }
}
