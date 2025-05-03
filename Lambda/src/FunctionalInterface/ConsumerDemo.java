package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
Consumer<T>
Function: Represents an operation that accepts a single input argument and returns no result (performs an action).
Method: void accept(T t)
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("John", "Victor", "Mary", "Johannes", "Juliet");

        //Using anonymous class to print name of each child
        Consumer<String> consumerClass1 = name -> System.out.println("Hello " + name);
        // Iterating over the list with forEach and Consumer
        System.out.println("\nList of student:");
        stringList.forEach(consumerClass1);

        // Using a Consumer to calculate and display the length of each name
        Consumer<String> consumerClass2 = name -> System.out.println(name+ " has " +name.length()+ " characters.");
        System.out.println("\nName of children and character length:");
        stringList.forEach(consumerClass2);

        // Combining consumers with andThen
        Consumer<String> combinedConsumer1 = name -> consumerClass1.andThen(consumerClass2).accept(name);
        // Iterating over the list with combined Consumer
        System.out.println("\nGreeting names and displaying lengths:");
        stringList.forEach(combinedConsumer1);
    }
}
