package Functional_Interface;

/*
A functional interface in Java is an interface that has only one abstract method.
Functional interfaces can be implemented using:
    1.lambda expressions,
    2.method references, or
    3.anonymous classes.
 */
public interface MyFunctionalInterface {
    void execute(String message); // Only one abstract method
}
