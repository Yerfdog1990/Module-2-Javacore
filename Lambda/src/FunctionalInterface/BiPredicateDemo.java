package FunctionalInterface;

import java.util.Scanner;
import java.util.function.BiPredicate;

/*
DoublePredicate
Function: Variants of Predicate<T> that accept a primitive double as input.
Methods: boolean test(double value)
 */
public class BiPredicateDemo {
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
                    return BiPredicateDemo.sumIsEven(num1, num2);
                }
            };
            boolean result1 = checkIfEven1.test(firstDouble, secondDouble);
            System.out.printf("Using anonymous class: The sum of %.2f and %.2f is even: %b\n", firstDouble, secondDouble, result1);

            //Check if sum of double values is even using lambda expression
            BiPredicate<Double, Double> chekIfEven2 = (num1, num2) ->BiPredicateDemo.sumIsEven(firstDouble, secondDouble);
            boolean result2 = chekIfEven2.test(firstDouble, secondDouble);
            System.out.printf("Using lambda expression: The sum of %.2f and %.2f is even: %b\n", firstDouble, secondDouble, result2);

            //Check if sum of double values is even using method referencing
            BiPredicate<Double, Double> chekIfEven3 = BiPredicateDemo::sumIsEven;
            boolean result3 = chekIfEven3.test(firstDouble, secondDouble);
            System.out.printf("Using method referencing: The sum of %.2f and %.2f is even: %b\n", firstDouble, secondDouble, result3);
        }
    }
}
