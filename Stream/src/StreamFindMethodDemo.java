import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
/*
The Stream class in Java provides several methods for finding elements within a stream of data.
These methods return an Optional<T> object, ensuring that they never return null, thus avoiding NullPointerException issues.
The key methods for finding elements are findFirst(), findAny(), min(), and max().
 */
public class StreamFindMethodDemo {
    public static void main(String[] args) {
        // Creating an ArrayList of strings
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Hello", "how's", "life?", "Java", "Streams");

        // Find the first element using a lambda expression
        Optional<String> firstElement = list.stream().findFirst();
        System.out.println("First Element: " + firstElement.orElse("No elements"));

        // Find any element using a lambda expression
        Optional<String> anyElement = list.stream().findAny();
        System.out.println("Any Element: " + anyElement.orElse("No elements"));

        // Find the shortest string (min) using a lambda expression
        Optional<String> shortestString = list.stream().min((s1, s2) -> s1.length() - s2.length());
        System.out.println("Shortest String: " + shortestString.orElse("No elements"));

        // Find the longest string (max) using a lambda expression
        Optional<String> longestString = list.stream().max((s1, s2) -> s1.length() - s2.length());
        System.out.println("Longest String: " + longestString.orElse("No elements"));
    }
}
