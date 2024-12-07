package PrototypeMethodDesignPattern;

import java.util.HashMap;
import java.util.Map;

/*
Definition
The Prototype Design Pattern is a creational design pattern used to create new objects by copying (or cloning) existing objects.
This approach hides the complexity of creating instances and allows clients to create new objects without knowing the details of how those objects are created.
Instead of instantiating a class directly, a client copies an existing object, which may involve expensive or complex initialization.

Key Features
1.Cloning Instead of Instantiation: New objects are created by copying prototypes rather than creating new instances through constructors.
2.Decouples Object Creation: Clients are independent of the concrete classes and their instantiation logic.
3.Reduces Subclassing: Instead of having a hierarchy of factory classes for creating objects, the Prototype pattern uses cloning, reducing the need for complex factory hierarchies.
4.Dynamic Object Creation: New objects can be created dynamically at runtime by copying existing instances.
5.Simplifies Complex Object Initialization: If the creation of an object involves costly or time-consuming operations, the Prototype pattern can simplify and speed up the process by cloning pre-initialized objects.
6.Preserves Object State: Cloning ensures that the new object has the same state as the prototype, which can be beneficial when the state initialization is non-trivial.

Structure
The Prototype Design Pattern consists of the following components:
1.Prototype Interface:
    -Declares a clone() method that returns a copy of the object.
    -Typically extends Cloneable (in Java) to indicate that the object supports cloning.
2.Concrete Prototype Classes:
    -Implement the Prototype interface and the clone() method.
    -Define specific fields and behavior for the object type.
3.Prototype Registry (Optional):
    -Manages a collection of prototype instances.
    -Allows clients to retrieve and clone prototypes dynamically.
4.Client:
    -Uses the prototype interface to create new objects by cloning existing prototypes.
 */
// Step 1: Define the Prototype interface
public interface Shape extends Cloneable{
    Shape clone(); // Clone method to be implemented by concrete classes
    void draw();
}
// Step 2: Concrete class -
class Circle implements Shape{
    private String type = "Circle";
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
        System.out.printf("Circle of radius %dcm has been created.\n", radius);
    }
    @Override
    public Shape clone() {
        try{
            return (Shape) super.clone();
        }catch (CloneNotSupportedException e){
            throw new RuntimeException("Cloning failed", e);
        }
    }
    @Override
    public void draw() {
        System.out.printf("Drawing a circle of radius %dcm.\n", radius);
    }
}
class Rectangle implements Shape{
    private String type = "Rectangle";
    private int length;
    private int width;

    // Step 3: Concrete class - Rectangle
    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
        System.out.printf("A rectangle of width %dcm and length %dcm has been created.\n", width, length);
    }
    @Override
    public Shape clone() {
        try{
            return (Shape) super.clone();
        }catch(CloneNotSupportedException e){
            throw new RuntimeException("Cloning failed.", e);
        }
    }
    @Override
    public void draw() {
        System.out.printf("Drawing a rectangle of width %dcm and length %dcm.\n", width, length);
    }
}
// Step 4: PrototypeRegistry to manage prototypes
class ShapeRegistry{
    Map<String, Shape> shapeMap = new HashMap<>();
    public void registerShape(String key, Shape shape){
        shapeMap.put(key, shape);
    }
    public Shape getShape(String shape){
        Shape shape1 = shapeMap.get(shape);
        return shape1 != null? shape1.clone(): null;
    }
}
// Step 5: Client code
class prototypepatternDemo{
    //Main method
    public static void main(String[] args) {
        ShapeRegistry shapeRegistry = new ShapeRegistry();
        //Register shapes
        shapeRegistry.registerShape("First circle", new Circle(5));
        shapeRegistry.registerShape("First rectangle", new Rectangle(4, 12));

        // Clone shapes from the registry
        System.out.println("\nCloning shapes from the registry:");
        Shape clonedCircle = shapeRegistry.getShape("First circle");
        clonedCircle.draw();
        Shape clonedRectangle = shapeRegistry.getShape("First rectangle");
        clonedRectangle.draw();

        // Verify that clones are independent
        System.out.println("\nCloning shapes again to verify independence:");
        Shape anotherClonedCircle = shapeRegistry.getShape("First circle");
        anotherClonedCircle.draw();
    }
}