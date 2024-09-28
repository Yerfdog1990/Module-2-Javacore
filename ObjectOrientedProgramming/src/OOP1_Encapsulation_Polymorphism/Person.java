package OOP1_Encapsulation_Polymorphism;

import java.util.Scanner;

/*
Definition of Encapsulation:
Encapsulation is a principle of Object-Oriented Programming (OOP) that involves bundling the data (variables) and the methods (functions) that operate on the data into a single unit, known as a class.
It also restricts direct access to some of the object’s components, which helps in maintaining the object’s integrity and hiding its internal complexity from other objects.

Advantages of Encapsulation:
1.Valid Internal State: Ensures that the internal state of an object cannot be altered unpredictably by external objects.
2.Parameter Checking: Allows checking and validation of parameters passed to methods, preventing invalid states.
3.Fewer Bugs When Changing Code: Internal methods or variables can be changed without affecting external code.
4.Controlled Interaction: Allows controlling how other objects interact with the object, enforcing rules or restrictions.
 */
public class Person {
    // Private fields to ensure valid internal state (Advantage 1: Valid Internal State)
    private String name;
    private int age;

    // Constructor to initialize the person object
    public Person(String name, int age) {
        setName(name); // Encapsulated field through method
        setAge(age);   // Encapsulated field through method
    }

    // Public getter to allow read-only access (Controlled Interaction - Advantage 4)
    public String getName() {

        return name;
    }

    // Public getter to access age
    public int getAge() {

        return age;
    }

    // Public setter with validation (Advantage 2: Parameter Checking)
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name!");
        }
    }

    // Public setter with validation (Advantage 2: Parameter Checking)
    public void setAge(int age) {
        if (age > 0 && age <= 150) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }

    // Private method that can be changed without affecting other code (Advantage 3: Fewer Bugs When Changing Code)
    private boolean isAdult() {

        return age >= 18;
    }

    // Public method controlling how others interact with the object (Advantage 4: Controlled Interaction)
    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Adult: " + (isAdult() ? "Yes" : "No")); // Calls private method
    }
}
class MainClass {
    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)){
            System.out.print("Enter name: ");
            String name = userInput.nextLine();
            System.out.print("Enter age: ");
            int age = userInput.nextInt();
            // Creating a Person object and using encapsulated methods
            Person person = new Person(name, age);

            // Demonstrating the advantages of encapsulation
            person.displayPersonInfo(); // Displays valid state and uses internal method

            // Attempting to set an invalid value
            person.setAge(200); // Demonstrates parameter checking

            // Demonstrates controlled interaction through encapsulation
            System.out.println("Person's Name (read-only): " + person.getName());
        }
    }
}


