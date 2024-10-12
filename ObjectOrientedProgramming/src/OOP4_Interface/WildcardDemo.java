package OOP4_Interface;

import java.util.ArrayList;
import java.util.List;

/*
Definition:
Wildcards in Java generics are represented by the "?" symbol and are used to create flexible code that can work with multiple types.
They allow you to specify unknown types in generic code, enabling the handling of various types without compromising type safety.

Types of Wildcards
1. Unbounded Wildcard (?):
    -Represents an unknown type.
    -Used when the specific type is not important or when you don't care about the type.
    -Key feature: You can only read from the collection; you cannot add elements to it.
    -Example:
        List<?> list = new ArrayList<>();
2. Upper-bounded Wildcard (? extends T):
    -Restricts the unknown type to be a specific type (T) or any of its subtypes.
    -Key feature: You can read items of the upper-bounded type or its subtype from the collection, but you cannot add to it (except null).
    -Example:
        List<? extends Number> list = new ArrayList<>();
3. Lower-bounded Wildcard (? super T):
    -Restricts the unknown type to be a specific type (T) or any of its supertypes.
    -Key feature: You can add elements of the lower-bounded type (T) to the collection.
    -Example:
        List<? super Integer> list = new ArrayList<>();
 */
public class WildcardDemo {
    // Unbounded wildcard method: can accept List of any type
    public static void printList(List<?> list){
        for(Object elem1 : list){
            System.out.println(elem1);
        }
    }
    // Upper-bounded wildcard method: can accept List of Number or any subclass of Number
    public static void printNumbers(List<? extends Number> numbers){
        for(Number elem2: numbers){
            System.out.println("Number " +elem2);
        }
    }
    // Lower-bounded wildcard method: can accept List of Integer or any superclass of Integer
    public static void addIntegers(List<? super Integer> intList){
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        intList.add(50);
        System.out.println("Integers successfully added.");
    }
    public static void main(String[] args) {
        // Unbounded wildcard: can accept any type of List
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");
        System.out.println("Print unbounded \"Wildcard\":");
        printList(stringList);

        // Lower-bounded wildcard method: can accept List of Integer or any superclass of Integer
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        System.out.println("\nPrint upper-bounded \"Wildcard\":");
        printNumbers(integerList);

        // Lower-bounded wildcard: List of Integer or any of its supertypes
        List<Number> numberList = new ArrayList<>();
        System.out.println("\nLower-Bounded \"Wildcard:\"");
        addIntegers(numberList);// Can add Integers to this list
        printNumbers(numberList);// Now printing the list to see the added integers
    }
}
