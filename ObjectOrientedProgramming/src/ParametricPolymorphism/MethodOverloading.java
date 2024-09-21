package ParametricPolymorphism;
/*
Method Overloading
Definition: Method overloading occurs when multiple methods in the same class share the same name but differ in parameters (type, number, or both).
This allows methods to be called with different argument lists, enhancing the flexibility and readability of the code.

Key Features of Method Overloading:
1.Same Method Name: All overloaded methods must have the same name.
2.Different Parameter Lists: Overloaded methods must differ in the number of parameters, types of parameters, or both.
3.Return Type: The return type of overloaded methods can be different, but it alone cannot be used to distinguish overloaded methods.
4.Compile-time Polymorphism: Method overloading is resolved at compile time, which is known as compile-time polymorphism.
5.Enhances Readability: It improves code readability and usability by allowing methods that perform similar tasks to share a name.
 */
public class MethodOverloading {

    // Method with no parameters
    public void print() {
        System.out.println("Print method with no parameters");
    }

    // Method with one integer parameter
    public void print(int n) {
        System.out.println("Print method with one integer: " + n);
    }

    // Method with two integer parameters
    public void print(int n, int n2) {
        System.out.println("Print method with two integers: " + n + " and " + n2);
    }

    // Method with an int and a long parameter
    public int print(int a, long b) {
        System.out.println("Print method with an int and a long: " + a + " and " + b);
        return a + (int) b; // Return type differs
    }

    // Method with a long and an int parameter (different order)
    public long print(long b, int a) {
        System.out.println("Print method with a long and an int: " + b + " and " + a);
        return b + a; // Return type differs
    }

    public static void main(String[] args) {
        MethodOverloading example = new MethodOverloading();

        example.print();               // Calls print()
        example.print(10);             // Calls print(int n)
        example.print(10, 20);         // Calls print(int n, int n2)
        example.print(5, 10L);         // Calls print(int a, long b)
        example.print(10L, 5);         // Calls print(long b, int a)
    }
}

