/**
 * This package contains classes related to lambda expression demonstrations
 * using basic calculator operations.
 */
package CreateLambdaExpression;
/**
 * A functional interface that defines a contract for performing
 * arithmetic calculations between two numbers.
 */
@FunctionalInterface
public interface Calculator {
    double calculate(double num1, double num2);
}
/**
 * Application class that demonstrates the usage of lambda expressions
 * for basic arithmetic operations using the Calculator interface.
 */
class CalculatorApp{
    /**
     * Main method to demonstrate different arithmetic operations using lambda expressions.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Lambda expression for addition operation
        Calculator addition = (num1, num2) -> num1 + num2;
        // Lambda expression for subtraction operation
        Calculator subtraction = (num1, num2) -> num1 - num2;
        // Lambda expression for division operation
        Calculator division = (num1, num2) -> num1 / num2;
        // Lambda expression for multiplication operation
        Calculator multiply = (num1, num2) -> num1 * num2;

        try {
            // Perform and display addition calculation
            System.out.println("Addition: " +addition.calculate(2.3, 5.6));
            // Perform and display subtraction calculation
            System.out.println("Subtraction: " +subtraction.calculate(2.3, 5.6));
            // Perform and display division calculation
            System.out.println("Division: " +division.calculate(2.4, 1.2));
            // Perform and display multiplication calculation
            System.out.println("Multiplication: " +multiply.calculate(2.3, 5.6));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}