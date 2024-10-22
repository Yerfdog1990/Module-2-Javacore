/*
In Java, objects are created in multiple steps:
1.Memory Allocation: When you create an object using new, memory is allocated for the object's instance variables (also known as member variables). This memory is used to store the state of the object.
2.Base Class Initialization: If the class has a parent class (superclass), the constructor of the parent class is called to initialize the parent part of the object. This ensures that the base class is correctly initialized before initializing the subclass.
3.Variable Initialization: Instance variables in the class are initialized. If any values are provided for the variables, they are assigned at this stage.
4.Constructor Call: The constructor of the current class is called. This constructor can either initialize values or perform other tasks necessary for object creation.
 */
public class Pet {
    int x = 5;       // Initialized to 5
    int y = 5;       // Initialized to 5
    int weight = 10; // Initialized to 10

    // Constructor of the Pet class
    Pet(int x, int y) {
        System.out.println("Pet constructor called");
        this.x = x; // Assigning new value to x
        this.y = y; // Assigning new value to y
        System.out.println("Pet variables: x = " + this.x + ", y = " + this.y);
    }
}

class Cat extends Pet {
    int tailLength = 8; // Initialized to 8
    int age;            // Uninitialized, default to 0

    // Constructor of the Cat class
    Cat(int x, int y, int age) {
        super(x, y); // Calls the parent class constructor (Pet)
        System.out.println("Cat constructor called");
        this.age = age; // Assigning value to age
        System.out.println("Cat variables: age = " + this.age + ", tailLength = " + this.tailLength);
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Creating a Cat object...");
        Cat cat = new Cat(3, 4, 2); // Create a Cat object
    }
}

