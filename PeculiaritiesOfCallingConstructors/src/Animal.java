/*
Key Takeaways:
The super() call ensures that the base class's constructor is executed before the subclass constructor.
Default values for variables are assigned before the constructor's custom logic runs.
The order of initialization ensures that parent class variables are set before any subclass-specific logic is executed.
 */
class Animal extends Object {
    int x;
    int y;
    int weight;

    // Constructor of the Animal class
    Animal(int x, int y) {
        // Call to the base class constructor (Object)
        super();
        // Initialize instance variables
        this.x = 5;    // Default value for x
        this.y = 5;    // Default value for y
        this.weight = 10; // Default value for weight
        // Now execute the constructor's specific code
        this.x = x;    // Overwrite x with the provided value
        this.y = y;    // Overwrite y with the provided value
    }
}

class Dog extends Animal {
    int tailLength;
    int age;

    // Constructor of the Dog class
    Dog(int x, int y, int age) {
        // Call to the base class constructor (Animal)
        super(x, y);
        // Initialize instance variables of Dog
        this.tailLength = 8; // Default value for tailLength
        // Now execute the constructor's specific code
        this.age = age;      // Set age to the provided value
    }
    //Main method
    public static void main(String[] args) {
            System.out.println("Creating a Dog object...");
            Dog dog = new Dog(3, 4, 2); // Create a Dog object

    }
}
