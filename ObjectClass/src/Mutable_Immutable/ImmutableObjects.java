package Mutable_Immutable;

import java.time.LocalDate;

/*
In Java, immutability refers to inability to modify an object’s state once it has been initialized.
Key features:
    1.Fixed State: Their state is fixed after initialization, making them inherently thread-safe.
    2.No Setters: These classes generally don’t have setter methods.
    3.Final Fields and Class: Fields and class are often marked final to prevent modification and inheritance.
    4.Improved Security and Stability: Immutable objects are preferred for sensitive data as they prevent accidental changes.

Common immutable object types in Java include:
    1.String: Once created, a String object cannot be changed.
    2.Wrapper Classes (Integer, Long, etc.): These are immutable versions of primitive data types.
    3.java.time.LocalDate: Represents a date, but does not allow modification.
    4.Custom immutable classes: Classes with final fields and no setters.
 */
public class ImmutableObjects {
    public static void main(String[] args) {
        // Immutable String
        String message = "Hello";
        System.out.println("\nOriginal String: " + message);
        message = message.concat(" World"); // Creates a new String object
        System.out.println("New String: " + message);

        // Immutable Integer (Wrapper class)
        Integer number = 10;
        System.out.println("\nOriginal Integer: " + number);
        number = number + 5; // Creates a new Integer object, does not modify the original
        System.out.println("New Integer: " + number);
        // Immutable LocalDate
        LocalDate date = LocalDate.of(2023, 10, 25);
        System.out.println("\nOriginal Date: " + date);
        LocalDate newDate = date.plusDays(5); // Creates a new LocalDate object
        System.out.println("New Date: " + newDate);

        // Custom Immutable Class
        ImmutablePoint point = new ImmutablePoint(10, 20);
        System.out.println("\nImmutablePoint x value: " + point.getX()+ " ,y value:" +point.getY());

        //point.setX(5); // This would be a compile error, as there's no setter
        //point.setY(15); // This would be a compile error, as there's no setter
        System.out.println("ImmutablePoint x value: " + point.getX()+ " ,y value:" +point.getY());

    }
}

final class ImmutablePoint {
    private final int x;
    private final int y;

    public ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

}
