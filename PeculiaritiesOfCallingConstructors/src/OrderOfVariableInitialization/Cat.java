package OrderOfVariableInitialization;
/*
In Java, when a class is loaded and an object is created, variables are initialized in a specific order. This includes:
    1.Default Initialization: All member variables are first set to their default values (e.g., 0 for integers).
    2.Explicit Initialization: Any initializations that you specify in the class, such as setting int a = 5;, are then applied in the order they appear in the class.
    3.Constructor Initialization: After default and explicit initialization, the constructor is called, which can modify the values further.
The order matters because a variable should only reference another variable that has already been initialized. Let’s see this in action.
 */
class Cat {
    // Explicit Initialization
    public int a = 5;          // a is initialized first (explicit)
    public int b = a + 1;      // b is initialized after a (explicit)
    public int c = a * b;      // c is initialized after a and b (explicit)

    // Initialization using a method
    public int d = getSum();            // d initialized using getSum()
    public int e = getSum() - d;        // e initialized using getSum() - d
    public int f = getSum() - d - e;    // f initialized using getSum() - d - e

    public Cat() {
        // The constructor is called after explicit initialization
        System.out.println("Inside constructor...");
    }

    // Method to calculate sum of a, b, and c
    public int getSum() {
        return a + b + c;
    }

    // Method to print values
    public void printValues() {
        System.out.println("a = " + a);  // 5
        System.out.println("b = " + b);  // 6 (a + 1)
        System.out.println("c = " + c);  // 30 (a * b)
        System.out.println("d = " + d);  // 41 (getSum() = a + b + c = 5 + 6 + 30)
        System.out.println("e = " + e);  // 0 (getSum() - d = 41 - 41 = 0)
        System.out.println("f = " + f);  // 0 (getSum() - d - e = 41 - 41 - 0 = 0)
    }

    public static void main(String[] args) {
        Cat cat = new Cat();  // Create Cat object, triggering variable initialization
        cat.printValues();    // Print initialized values
    }
}
