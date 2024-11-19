package FunctionalInterface;

import java.util.Scanner;
import java.util.function.BiPredicate;

/*
DoublePredicate
Function: Variants of Predicate<T> that accept a primitive double as input.
Methods: boolean test(double value)
 */
public class DoublePredicateDemo {
    //Static method to check if the sum of two doubles is even
    public static boolean sumIsEven(double num1, double num2){

        return (num1 + num2) % 2 == 0.0;
    }
}
//Driving class
class DoubleSum{
    //Main method
    public static void main(String[] args) {
        try(Scanner userInput = new Scanner(System.in)){
            System.out.print("Enter first double value: ");
            double firstDouble = userInput.nextDouble();
            System.out.print("Enter second double value: ");
            double secondDouble = userInput.nextDouble();

            //Check if sum of double values is even using anonymous class
            BiPredicate<Double, Double> checkIfEven1 = new BiPredicate<>() {
                @Override
                public boolean test(Double num1, Double num2) {
                    return DoublePredicateDemo.sumIsEven(num1, num2);
                }
            };
            boolean result = checkIfEven1.test(firstDouble, secondDouble);
            System.out.printf("Using anonymous class: The sum of %.2f and %.2f is even: %b\n", firstDouble, secondDouble, result);
        }
    }
}
