package SingletonMethodDesignPattern;
/*
Singleton Design Pattern
Definition
The Singleton Design Pattern ensures that a class has only one instance and provides a global access point to that instance.
This pattern is useful when exactly one object is needed to coordinate actions across a system.

Key Characteristics
    1.Single Instance: Ensures that only one instance of the class exists in the system.
    2.Global Access Point: Provides a way to access the single instance globally.
    3.Lazy Initialization: The instance is created only when it is needed (on-demand).
    4.Thread Safety: (Optional) Ensures that the singleton works correctly in a multi-threaded environment.
    4.Private Constructor: Restricts instantiation from outside the class.
    5.Static Method: A public static method provides access to the single instance.

Structure
    1.Private Static Instance: Holds the single instance of the class.
    2.Private Constructor: Prevents instantiation of the class from outside.
    3.Public Static Method: Provides controlled access to the single instance.
    4.Subclassing Support (Optional): Allows extending the singleton class if needed.
 */
public class Singleton {
    // 1.Private Static Instance: Holds the single instance of the class.
    private static Singleton INSTANCE;
    //2.Private Constructor: Prevents instantiation of the class from outside.
    protected Singleton() {
        System.out.println("Singleton instance created.");
    }
    //3.Public Static Method: Provides controlled access to the single instance.
    public static Singleton getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
    void printMessage(){
        System.out.println("Hello from singleton");
    }
}
//4.Subclassing Support (Optional): Allows extending the singleton class if needed.
class ExtendedSingleton extends Singleton{
    private static ExtendedSingleton INSTANCE;
    private ExtendedSingleton() {
        System.out.println("Extended singleton instance created.");
    }
    public static ExtendedSingleton getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new ExtendedSingleton();
        }
        return INSTANCE;
    }
    @Override
    void printMessage() {
        System.out.println("Hello from extended singleton");
    }
}
class SingletonPatterDemo{
    //Main method
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getINSTANCE();
        singleton1.printMessage();
        Singleton singleton2 = ExtendedSingleton.getINSTANCE();
        singleton2.printMessage();

        //Check if singleton1 and singleton2 point the same reference.
        System.out.println("Singleton 1 reference: " +singleton1);
        System.out.println("Singleton 2 reference: " +singleton2);
        // Checking if both instances are the same
        System.out.println("Are both instances the same? " + (singleton1 == singleton2));
    }
}

