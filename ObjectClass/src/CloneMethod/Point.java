package CloneMethod;
/*
Object cloning refers to the creation of an exact copy of an object.
It creates a new instance of the class of the current object and initializes all its fields with exactly the contents of the corresponding fields of this object.

Three methods for performing object cloning in Java:
    1.Using Assignment Operator: Simply creates a new reference to the original object. Any changes made through the new reference will reflect in the original object because both references point to the same memory location.
    2.Shallow Copy Using clone(): The clone() method from the Object class creates a new object, but if the fields are references to objects, it only copies the references, not the objects themselves (shallow copy).
    3.Deep Copy Using clone(): In a deep copy, both the object and the objects it references are cloned (i.e., completely independent).
 */
public class Point implements Cloneable {
    int x;
    int y;

    // Constructor
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    // Overriding the clone method to use the superclass's clone (Shallow copy)
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Method to display point information
    void display() {
        System.out.println("Point(" + x + ", " + y + ")");
    }

    // Main method demonstrating three methods of cloning
    public static void main(String[] args) throws CloneNotSupportedException {
        // Original object
        Point p1 = new Point(10, 15);

        // 1. Using the clone() method (Shallow copy)
        Point p2 = (Point) p1.clone();

        // 2. Using Assignment Operator (References the same object)
        Point p3 = p1;

        // Display the original and the copied objects
        System.out.println("Original Point:");
        p1.display();

        System.out.println("\nCopy using clone method (Shallow copy):");
        p2.display();

        System.out.println("\nCopy using assignment operator:");
        p3.display();

        // Modifying p1's values to show the effect on p3 (assigned reference)
        p1.x = 100;
        p1.y = 200;

        System.out.println("\nAfter modifying p1:");
        System.out.println("P1 (Updated original point):");
        p1.display();
        System.out.println("\np3 (Assignment operator - same reference):");
        p3.display();
        System.out.println("\np2 (Clone method - independent copy):");
        p2.display();
    }
}
