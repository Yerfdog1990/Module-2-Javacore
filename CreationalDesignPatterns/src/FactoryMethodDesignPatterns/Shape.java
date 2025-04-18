package FactoryMethodDesignPatterns;

import java.util.Scanner;
/*
Factory Design Pattern
Definition:
The Factory Design Pattern provides a way to create objects without specifying the exact class of the object that will be created.
Below is when to use Factory Method Design Pattern:
    1. A class can't anticipate the class of objects it must create.
    2. A class wants its subclass to specify the objects it creates.
    3. Classes delegate responsibility to one of several helper subclasses, and you want to localize the knowledge of which helper subclass is the delegate.

Key Characteristics:
    1. Creates a single type of product (e.g., different types of shapes).
    2. Provides a single factory method for creating an object.
    3. Clients are decoupled from the specific classes they use.

Structure:
    1. Product Interface: Declares the type of object the factory will create.
    2. Concrete Products: Implement the product interface.
    3. Factory Class: Contains the logic to create objects based on input conditions.
 */
//Shape (Product Interface): Defines the common interface for all objects the factory can create.
public interface Shape {
    // Step 1: Define the Product interface
    void drawShape();
}
// Step 2: Create Concrete Products
//Circle, Rectangle, Triangle, Kite (Concrete Products): Implement the Shape interface.
class Circle implements Shape{
    @Override
    public void drawShape() {
        System.out.println("Drawing circle.");
    }
}
class Rectangle implements Shape {
    @Override
    public void drawShape() {
        System.out.println("Drawing rectangle.");
    }
}
class Triangle implements Shape {
    @Override
    public void drawShape() {
        System.out.println("Drawing triangle.");
    }
}
class Kite implements Shape {
    @Override
    public void drawShape() {
        System.out.println("Drawing kite.");
    }
}
// Step 3: Define the Creator Abstract Class
//ShapeFactory (Abstract Creator): Declares the factory method createShape().
abstract class ShapeFactory{
    //Factory method
    public abstract Shape createShape();
    // Method to render shapes
    public void renderShape(){
        Shape shape = createShape();
        shape.drawShape();
    }
}
// Step 4: Create Concrete Creators
//CircleFactory, RectangleFactory, TriangleFactory, KiteFactory (Concrete Creators): Implement the factory method to return specific shape objects.
class circleFactory extends ShapeFactory{
    @Override
    public Shape createShape() {
        return new Circle();
    }
}
class rectangleFactory extends ShapeFactory{
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
class triangleFactory extends ShapeFactory{
    @Override
    public Shape createShape() {
        return new Triangle();
    }
}
class kiteFactory extends ShapeFactory{
    @Override
    public Shape createShape() {
        return new Kite();
    }
}
// Step 5: Client Code
//Client (FactoryMethodDemo): Decides which factory to use and delegates the object creation.
class FactoryMethodDemo1{
    public static void main(String[] args) {
        // Dynamically determine which factory to use
        ShapeFactory shapeFactory;
        try (Scanner userShape = new Scanner(System.in)){
            System.out.print("Enter the shape you want to create: ");
            String userInput = userShape.nextLine();
            switch (userInput.toLowerCase()){
                case "circle":
                    shapeFactory = new circleFactory();
                    break;
                case "rectangle":
                    shapeFactory = new rectangleFactory();
                    break;
                case "triangle":
                    shapeFactory = new triangleFactory();
                    break;
                case "kite":
                    shapeFactory = new kiteFactory();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid type of shape");
            }
            //Use the factory to create and render shapes
            shapeFactory.renderShape();
        }
    }
}
