package toStringMethod;
/*
Definition of toString()
The toString() method in Java is defined in the Object class and is used to provide a string representation of an object.
By default, it returns a string that consists of the class name followed by the "@" symbol and the object's hash code in hexadecimal form (e.g., ClassName@6d06d69c).

Features of toString()
    1.Defined in the Object class: Since all Java classes inherit from Object, every class has a toString() method.
    2.Default behavior: If not overridden, the toString() method provides a generic string that represents the object's class name and hash code.
    3.Customizable: You can override the toString() method in your class to provide a meaningful and readable string representation of the object, such as its fields' values.
    4.Commonly used: It is often used implicitly, for example, when printing an object with System.out.println(), or when concatenating an object with a string.
    5.Enhances debugging: Overriding toString() is useful for debugging, as it can provide more useful information about the object's state.
 */
public class ToStringDemo {
    public static void main(String[] args) {
        // Object without overriding toString
        PersonWithoutToString person1 = new PersonWithoutToString("John", 30);
        System.out.println("Default toString output:");
        System.out.println(person1); // Prints default toString output

        // Object with overriding toString
        PersonWithToString person2 = new PersonWithToString("Alice", 25);
        System.out.println("\nCustom toString output:");
        System.out.println(person2); // Prints customized toString output
    }
}

// Class without toString override (default behavior)
class PersonWithoutToString {
    String name;
    int age;

    public PersonWithoutToString(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// Class with toString override
class PersonWithToString {
    String name;
    int age;

    public PersonWithToString(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding the toString method to provide a meaningful representation
    @Override
    public String toString() {
        return "Person {name = '" + name + "', age = " + age + "}";
    }

}

