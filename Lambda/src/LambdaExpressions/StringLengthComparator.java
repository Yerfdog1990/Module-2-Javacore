package LambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StringLengthComparator {
    public static void main(String[] args) {
        // Create an ArrayList of strings
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "Hello", "World", "Welcome", "Java", "Programming");

        // Use a lambda expression to create the Comparator
        Comparator<String> stringComparator = (string1, string2) -> string2.length() - string1.length();

        // Sort the list using the lambda comparator
        Collections.sort(stringArrayList, stringComparator);

        // Print the sorted list
        System.out.println("Sorted by length:");
        for(String str: stringArrayList){
            System.out.println(str);
        }
    }
}
