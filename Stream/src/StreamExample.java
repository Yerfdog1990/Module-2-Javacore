import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/*
The Stream interface in Java is part of the Java Collections Framework and was introduced in Java 8 as a way to process sequences of elements (collections, arrays, etc.) in a functional style.
It allows for more concise and readable code for processing data.
 */

public class StreamExample {
    public static void main(String[] args) {
        // Creating an ArrayList and adding elements
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "Hello", "From", "Java", "Programming");

        // Getting a stream from the ArrayList
        Stream<String> collectionStream = getStreamFromArrayList(stringArrayList);
        System.out.println("Stream from collection:");
        collectionStream.forEach(System.out::println);

        // Creating an Array and adding elements
        String[] stringArray = {"Hello", "From", "Java", "Programming"};

        // Getting a stream from the Array
        Stream<String> arrayStream = getStreamFromArrays(stringArray);
        System.out.println("\nStream from Array");
        arrayStream.forEach(System.out::println);

    }
    //Method to get stream from collections
    public static Stream<String> getStreamFromArrayList(ArrayList<String> stringArrayList){
        return stringArrayList.stream();
    }
    //Method to get stream from arrays
    public static Stream<String> getStreamFromArrays(String[] stringsArray){
        return Arrays.stream(stringsArray);
    }
}
