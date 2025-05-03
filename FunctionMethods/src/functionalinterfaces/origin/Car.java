package functionalinterfaces.origin;

import java.util.Map;

/*
A functional interface in Java is an interface that contains only one abstract method.
Functional interfaces can have multiple default, or static methods, but only one public abstract method.

Note:
No, interfaces in Java cannot have constructors. This is a fundamental rule of the Java language. Here's why:
1. Interfaces cannot be instantiated on their own, so they don't need constructors.
2. Interfaces are meant to define a contract (what methods must be implemented) rather than provide implementation details.
3. All data members in interfaces are implicitly `public static final` (constants), and all methods are implicitly `public abstract` (except for default, static, or private methods since Java 8)

Functional Interface is additionally recognized as Single Abstract Method Interfaces. In short, they are also known as SAM interfaces.
Functional interfaces in Java are a new feature that provides users with the approach of fundamental programming.
Note:
A functional interface can also extend another functional interface.
When a functional interface extends another functional interface, it can still remain a functional interface as long as it doesn't declare any new abstract methods.
This is because the abstract method from the parent interface is considered the single abstract method for the child interface.


@FunctionalInterface Annotation
@FunctionalInterface annotation is used to ensure that the functional interface cannot have more than one abstract method.
In case more than one abstract methods are present, the compiler flags an “Unexpected @FunctionalInterface annotation” message.
However, it is not mandatory to use this annotation.
Note: @FunctionalInterface annotation is optional but it is a good practice to use.
It helps catching the error in early stage by making sure that the interface has only one abstract method.
 */
// Functional interface with only one abstract method
@FunctionalInterface
public interface Car {
  // Public and abstract method - count toward the rule of "exactly one."
  void printSpec();
}

// Functional interface with an abstract method, a default method, and a static method.
@FunctionalInterface
interface Animal{
  // public and abstract method - count toward the rule of "exactly one."
  String printSound(String sound);
  // Default method
  default String printName(String name){
    return name;
  }
  // Static method
  static String printColor(String color){
    return color;
  }
}
// Functional interface extends another functional interface
// but cannot declare another abstract method to maintain the "one abstract method rule"
@FunctionalInterface
interface CarYard extends Car{
  // Inherited abstract class
  @Override
  void printSpec();
  // Default method
  default Map<String, Integer> recordCars(String model, int carCount){
    Map<String, Integer> carRecord = Map.of(model, carCount);
    return carRecord;
  }
}

// Class implementing Car interface
class Benz implements Car{
  private String model;
  private double engineSize;
  private int horsePower;
  private String fuelType;
  private int year;

  public Benz(String model, double engineSize, int horsePower, String fuelType, int year) {
    this.model = model;
    this.engineSize = engineSize;
    this.horsePower = horsePower;
    this.fuelType = fuelType;
    this.year = year;
  }

  @Override
  public void printSpec() {
    System.out.println("Model: " + model);
    System.out.println("Engine Size: " + engineSize + "L");
    System.out.println("Horse Power: " + horsePower + "hp");
    System.out.println("Fuel Type: " + fuelType);
    System.out.println("Year: " + year);
  }
  public static void main(String[] args) {
    Benz benz = new Benz("C300", 160.0, 100, "Petrol", 2018);
    benz.printSpec();
  }
}


// Class implementing Animal interface
class Zebra implements Animal{
  @Override
  public String printSound(String sound) {
    return sound;
  }
  public static void main(String[] args) {
    Animal zebra = new Zebra();
    System.out.println("Animal's sound: " +zebra.printSound("hee-haw"));
    System.out.println("Animal's name: " +zebra.printName("Zebra"));
    System.out.println("Animal's color: " +Animal.printColor("white-stripped"));
  }
}

// Class implementing CarYard interface
class CarRecord implements CarYard{
  @Override
  public void printSpec() {
    System.out.println("Car Record");
  }
  public static void main(String[] args) {
    CarRecord carRecord = new CarRecord();
    carRecord.printSpec();
    System.out.println(carRecord.recordCars("Benz", 2));
  }
}
