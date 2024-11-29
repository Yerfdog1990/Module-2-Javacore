package General;

import java.util.Optional;

/*
The Optional Class in Java
The Optional<T> class in Java was introduced in Java 8 to address the problem of handling null values.
It acts as a container object which may or may not contain a non-null value.
This helps avoid NullPointerExceptions and allows for more elegant handling of the absence of a value.

Key Features of Optional:
    1.Null-Safe Code: The main purpose of Optional is to prevent null references and minimize NullPointerException issues.
    2.Better Code Readability: Optional makes your code cleaner and more readable by explicitly defining the possibility of absence of a value.
    3.Immutability: Once an Optional object is created, the value it holds cannot be changed.
    4.Methods for Conditional Actions: Provides methods to work with the value if present, or take alternative actions if absent.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        // 1. Create an Optional with a non-null value using of()
        Optional<String> nonEmptyOptional = Optional.of("Hello, Java!");

        // 2. Create an Optional that may hold a null value using ofNullable()
        Optional<String> nullableOptional = Optional.ofNullable(null);

        // 3. Check if value is present using isPresent()
        if (nonEmptyOptional.isPresent()) {
            System.out.println("Value is present: " + nonEmptyOptional.get());
        }

        // 4. Handle the absence of value with orElse()
        System.out.println("Nullable Optional value: " + nullableOptional.orElse("Default value"));

        // 5. Use orElseThrow() to throw an exception if no value is present
        try {
            System.out.println("Nullable Optional (orElseThrow): " + nullableOptional.orElseThrow());
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e);
        }

        // 6. Use ifPresent() to perform an action if the value is present
        nonEmptyOptional.ifPresent(value -> System.out.println("Using ifPresent: " + value));

        // 7. Using map() to transform the value if present
        Optional<Integer> lengthOptional = nonEmptyOptional.map(String::length);
        lengthOptional.ifPresent(length -> System.out.println("Length of the string: " + length));
    }
}
