import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.BiFunction;
import java.util.Arrays;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // 1. Reference to an instance method of an object
        String message = "Hello, Method References!";
        // Equivalent to x -> message.toUpperCase()
        Supplier<String> instanceMethodReference = message::toUpperCase;
        System.out.println("Instance Method Reference: " + instanceMethodReference.get());

        // 2. Reference to a static method of a class
        // Equivalent to x -> Integer.parseInt(x)
        Function<String, Integer> staticMethodReference = Integer::parseInt;
        Integer number = staticMethodReference.apply("123");
        System.out.println("Static Method Reference: " + number);

        // 3. Reference to a constructor
        // Equivalent to () -> new Person("John")
        Supplier<Person> constructorReference = Person::new;
        Person person = constructorReference.get();
        System.out.println("Constructor Reference: " + person.getName());

        // Reference to a constructor with parameters using BiFunction
        BiFunction<String, Integer, Person> personConstructor = Person::new;
        Person anotherPerson = personConstructor.apply("Alice", 25);
        System.out.println("Constructor Reference with Parameters: " + anotherPerson.getName() + ", Age: " + anotherPerson.getAge());

        // 4. Reference to an array constructor
        // Equivalent to size -> new int[size]
        Function<Integer, int[]> arrayConstructor = int[]::new;
        int[] array = arrayConstructor.apply(5);
        Arrays.fill(array, 42); // Filling the array with value 42
        System.out.println("Array Constructor Reference: " + Arrays.toString(array));
    }
}

// Sample Person class with constructors
class Person {
    private String name;
    private int age;

    // No-argument constructor
    public Person() {
        this.name = "Default Name";
        this.age = 0;
    }

    // Constructor with parameters
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
