package FunctionalInterface;
/*
Predicate<T>
Function: Represents a boolean-valued function (a condition) that tests an input.
Method: boolean test(T t)
 */
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateDemo {
    //Predefined password
    public static String password = "Fty@2024";
    //Static method to validate input password
    public static boolean validatePassword(Object userInput){
        return password.equals(userInput);
    }
    //Main method
    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.print("Enter password: ");
            String passwordTest = userInput.nextLine();

            // Password check using anonymous class
            Predicate passwordCheck1 = new Predicate() {
                @Override
                public boolean test(Object input) {
                    return validatePassword(passwordTest);
                }
            };
            System.out.println("Anonymous Class: Password is correct: " + passwordCheck1.test(passwordTest));

            //Password check using lambda expression
            Predicate passwordCheck2 = (input)->{
                return validatePassword(passwordTest);
            };
            System.out.println("Lambda expression: Password is correct: " + passwordCheck2.test(passwordTest));

            //Password check using method referencing
            Predicate passwordCheck3 = PredicateDemo::validatePassword;
            System.out.println("Method referencing: Password is correct: " + passwordCheck3.test(passwordTest));
        }
    }
}

