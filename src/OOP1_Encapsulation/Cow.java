package OOP1_Encapsulation;
/*
Polymorphism in OOP
    -Polymorphism allows objects of different classes to be treated as objects of a common parent class.
    -This concept supports dynamic method resolution at runtime, where the method to be invoked is determined based on the actual object type, not the reference type.

Method Overriding in OOP
    -Method overriding occurs when a subclass provides a specific implementation of a method already defined in its superclass.
    -The method in the subclass must have the same name, return type, and parameters as the method in the superclass.

Features of Polymorphism
    1.Method Overriding: A subclass can provide a specific implementation for a method that is already defined in its parent class.
    2.Late Binding (Dynamic Dispatch): The method that gets called is determined at runtime based on the actual object type, not the reference type.
    3.Type Casting: Allows converting an object reference from one type to another, either by widening (upcasting) or narrowing (downcasting).
    4.Superclass Method Invocation: Using super.method() to invoke the superclass method in the subclass’s overriding method.
    5.Inheritance: A subclass inherits methods and fields from its superclass, which forms the basis for polymorphism.
 */
// Base class Cow
class Cow {
    public void printColor() {
        System.out.println("I'm white");
    }
    public void printName() {
        System.out.println("I'm a cow");
    }
    public void printAll() {
        printColor();
        printName();
    }
}
// Derived class Whale overrides Cow methods
class Whale extends Cow {
    // Overriding method
    @Override
    public void printName() {
        System.out.println("I'm a whale");
    }
    // Using superclass method
    @Override
    public void printAll() {
        super.printName(); // Calls the Cow's printName method
        System.out.println("Then I swim because I'm a whale");
    }
}
class mainClass {
    public static void main(String[] args) {
        // 1. Method Overriding
        Cow cow = new Cow();
        cow.printAll(); // I'm white, I'm a cow

        Whale whale = new Whale();
        whale.printAll(); // I'm a cow, Then I swim because I'm a whale

        // 2. Late Binding (Dynamic Dispatch)
        Cow cowRef = new Whale();
        cowRef.printName(); // I'm a whale (Whale's method is called)

        // 3. Type Casting
        if (cowRef instanceof Whale) {
            Whale whaleRef = (Whale) cowRef;
            whaleRef.printAll(); // I'm a cow, Then I swim because I'm a whale
        }
        // 4. Superclass Method Invocation
        whale.printAll(); // I'm a cow, Then I swim because I'm a whale
    }
}

