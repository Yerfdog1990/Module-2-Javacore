/**
 * This package contains classes related to lambda expression demonstrations
 * using school and student information.
 */
package CreateLambdaExpression;

/**
 * A functional interface that defines a contract for printing names.
 */
@FunctionalInterface
public interface School {
    /**
     * Prints the name according to implementation.
     */
    void printName();
}
/**
 * A class that demonstrates the usage of School functional interface
 * with both traditional implementation and lambda expressions.
 */
class Student implements School{
    /**
     * Implements the printName method from School interface.
     */
    @Override
    public void printName() {
        System.out.println("\nImplemented School interface:");
        System.out.println("My name is Godfrey.");
    }

    /**
     * Main method to demonstrate different ways of implementing
     * the School interface.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

    // Create an instance of the Student class and call printName using the traditional implementation
    Student myName1 = new Student();
    myName1.printName();

    System.out.println("\nUsed lambda expression:");
    // Implement School interface using lambda expression - a more concise way
    School myName2 = () -> System.out.println("My name is Godfrey.");
    myName2.printName();

    System.out.println("\nUsed anonymous class:");
    // Implement School interface using anonymous class - the traditional way before lambda
    School myName3 =
        new School() {
          @Override
          public void printName() {
            System.out.println("My name is Godfrey.");
          }
        };
        myName3.printName();
    }
}


