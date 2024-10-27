package Mutable_Immutable;
/*
In Java, mutability refers to an object’s ability to change its state after creation.
Key features:
    1.State Modifiable Post-Creation: Their properties or fields can change after the object is created.
    2.Thread-Safety Concerns: Mutable objects require careful handling in multi-threaded environments to avoid race conditions.
    3.Flexibility in Usage: Useful when frequent state updates are required without creating new objects.

Common mutable object types in Java include:
    1.Arrays: Their elements can be changed after creation.
    2.Collections (ArrayList, HashSet): Elements in collections can be added, removed, or modified.
    3.Custom model objects: Objects with fields that are not final and have setters.
    4.java.util.Date: The date can be updated after initialization.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MutableObjects {
    public static void main(String[] args) {
        // Mutable Array
        int[] numbers = {1, 2, 3};
        System.out.println("\nOriginal array: " + Arrays.toString(numbers));
        numbers[0] = 10; // Array element modified
        System.out.println("New array: " +Arrays.toString(numbers));

        // Mutable ArrayList (Collection)
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        System.out.println("\nOriginal array list: " +names);
        names.set(0, "Charlie"); // Modifies ArrayList element
        System.out.println("New array list: " +names);

        // Mutable Custom Class
        MutablePoint point = new MutablePoint(10, 20);
        System.out.println("\nOriginal coordinate: " +point.printPoint());

        point.setX(5); // Changing the value of x in MutablePoint
        point.setY(8); // Changing the value of y in MutablePoint
        System.out.println("New coordinate: " +point.printPoint());

        // Mutable java.util.Date
        Date date = new Date();
        System.out.println("\nCurrent date: " +date);
        date.setTime(2000000000L); // Modifies the date
        System.out.println("New date: " + date);
        }
    }

    class MutablePoint {
        private int x;
        private int y;

        public MutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x; } // Allows modification

        public void setY(int y) {
            this.y = y;
        }

        String printPoint(){
            return "("+getX()+ " ," +getY()+")";
        }
    }

