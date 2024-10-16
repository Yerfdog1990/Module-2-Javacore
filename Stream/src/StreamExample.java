import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // Creating an ArrayList and adding elements
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, "Hello", "From", "Java", "Programming");

        // Getting a stream from the ArrayList
        Stream<String> collectionStream = stringArrayList.stream();
        System.out.println("Stream from collection:");
        collectionStream.forEach(System.out::println);

        // Creating an Array and adding elements
        String[] stringArray = {"Hello", "From", "Java", "Programming"};

        // Getting a stream from the Array
        Stream<String> arrayStream = Arrays.stream(stringArray);
        System.out.println("\nStream from Array");
        arrayStream.forEach(System.out::println);

    }
}
