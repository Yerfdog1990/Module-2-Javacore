import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Calculator {
    int num1, num2;
    public Calculator() {
        this.num1 = 1;
        this.num2 = 2;
    }

    // Static method for a class
    public static int add(int a, int b) {
        return a + b;
    }
    // Instance method for a particular object
    public int sum(int a, int b) {
        return a + b;
    }
    // Override string
    @Override
    public String toString() {
        return "" + Math.addExact(num1, num2);
    }
    public static void main(String[] args) {
        // Reference to a static method
        BiFunction<Integer, Integer, Integer> staticRef = Calculator::add;
        System.out.println("Static reference: " + staticRef.apply(1, 2));

        // Reference to an instance of a class object
        Calculator calc = new Calculator();
        BiFunction<Integer, Integer, Integer> instanceRef = calc::sum;
        System.out.println("Instance reference: " + instanceRef.apply(1, 2));

        // Reference to an instance of an arbitrary object
        BiFunction<Integer, Integer, Integer> arbitraryRef = Math::addExact;
        System.out.println("Arbitrary reference: " + arbitraryRef.apply(1, 2));

        // Reference to a constructor
        Supplier<Calculator> constructorRef = Calculator::new;
        Calculator calc2 = constructorRef.get();
        System.out.println("Constructor reference: " + calc2);
    }
}