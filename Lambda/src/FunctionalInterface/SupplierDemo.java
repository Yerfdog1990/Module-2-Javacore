package FunctionalInterface;

import java.util.function.Supplier;

/*
Supplier<T>
Function: Represents a supplier of results (no input, only produces a value).
Method: T get()
 */
public class SupplierDemo {
    public static void main(String[] args) {
        double num1=3.3, num2=6.7;
        System.out.println((num1+num2)%2);
        Supplier<Double> supplier = () -> (num1+num2)%2;
        System.out.println(supplier.get());
    }
}
