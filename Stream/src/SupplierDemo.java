import java.util.ArrayList;
import java.util.function.Supplier;

/*
Supplier is a functional interface provided in the java.util.function package.
It represents a function that supplies a value without taking any input.
It has one abstract method, get(), which returns a result of a specified type.

Key Characteristics:
    1.No Input: The Supplier interface does not take any arguments.
    2.Return Value: It returns a value (of a generic type T).
    3.Functional Interface: As a functional interface, it can be implemented with lambda expressions, method references, or traditional anonymous classes.
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<ArrayList<String>> listSupplier = ArrayList::new;
        ArrayList<String> list = listSupplier.get();
        list.add("Hello");
        System.out.println(list);  // Output: [Hello]

        Person person = new Person();
        // Using Supplier to reference the getName method of a particular object
        Supplier<String> nameSupplier = person::getName;
        System.out.println(nameSupplier.get());
    }
}
class Person{
    private String name = "John";

    public String getName() {
        return name;
    }
}
