package CloneMethod;
/*
The clone() method in Java is part of the Object class, used to create and return a copy (clone) of an object.
This method provides a "shallow copy" unless it is overridden for a "deep copy."
To use the default cloning behavior, the class must implement the Cloneable interface, which acts as a marker to indicate that the class permits cloning.
Without it, calling clone() will throw a CloneNotSupportedException.

Key Features of the clone() Method:
    1.Shallow Copy: The default clone() method creates a shallow copy, meaning it copies the object's fields by value for primitive types and references for non-primitive types.
    2.Implements Cloneable: A class must implement the Cloneable interface to indicate it allows cloning.
    3.Override Required: The clone() method must be overridden in the class if you want to customize the cloning behavior or handle exceptions.
    4.Calling super.clone(): To use the default behavior provided by Object.clone(), the method should call super.clone() in the override.
 */
public class Point implements Cloneable{
    int x;
    int y;

    //Constructor
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    // Overriding the clone method to use the superclass's clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    // Method to display point information
    void display(){
        System.out.println("Point(" +x+ ", " +y+ ")");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Point p1 = new Point(10, 15); // Original object
        Point p2 = (Point) p1.clone(); // Cloning the object

        System.out.println("\nOriginal point:");
        p1.display();
        System.out.println("\nCloned point:");
        p2.display();

    }
}
