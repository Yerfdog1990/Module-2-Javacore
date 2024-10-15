import java.util.function.Function;
/*
The Function<T, R> interface in Java is a functional interface from the java.util.function package. It represents a function that accepts one argument of type T and produces a result of type R.
Since it's a functional interface, it has only one abstract method, but also includes several default and static methods for composing and chaining functions.
Key Features of Function<T, R>:
    1. Functional Interface: It has one abstract method, making it eligible to be used in lambda expressions and method references.
    2. Input and Output Types: It takes an argument of type T (input) and returns a result of type R (output).
    3. Usage in Stream API: The Function interface is widely used in Java Stream API for transformations using methods like map().
Key Methods:
    1. apply(T t): Abstract method to apply the function.
    2. andThen(Function after): Chains another function to execute after the current one.
    3. compose(Function before): Chains another function to execute before the current one.
    4. identity(): Returns a function that returns its input as output.
 */
public class FunctionExample {
    public static void main(String[] args) {
        // Function to square a number
        Function<Integer, Integer> square = x -> x * x;

        // Function to double a number
        Function<Integer, Integer> doubleIt = x -> x * 2;

        // Compose function: First square, then double
        Function<Integer, Integer> squareAndThenDouble = square.andThen(doubleIt);

        System.out.println(squareAndThenDouble.apply(3)); // Output: 18
    }
}

