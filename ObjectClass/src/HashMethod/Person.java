package HashMethod;
/*
The hashCode() method in Java provides a numeric representation of an object, which is used for performance in hash-based collections like HashMap and HashSet.
When overriding the equals() method, it is important to also override the hashCode() method to ensure that the contract between equals() and hashCode() is maintained.

General Contract of hashCode():
1.Consistency: During the execution of the application, if hashCode() is invoked multiple times on the same object, it must consistently return the same integer value, provided that no information used in equals(Object) comparisons has changed.
2.Equal objects must have equal hash codes: If two objects are considered equal according to the equals(Object) method, then calling hashCode() on both objects must return the same integer value.
3.Unequal objects may have the same hash code, but it's better if they don't: If two objects are unequal, according to the equals(Object) method, it is not required that the hashCode() values be distinct. However, using distinct hash codes for unequal objects can improve the performance of hash-based collections.
 */
import java.util.Objects;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding equals() method
    @Override
    public boolean equals(Object obj) {
        // Reflexive: If obj is the same object, return true
        if (this == obj) {
            return true;
        }

        // Null check: If obj is null, return false
        if (obj == null) {
            return false;
        }

        // Check if obj is an instance of Person
        if (obj instanceof Person) {
            Person other = (Person) obj;
            // Check if name and age are equal for both objects
            return this.name.equals(other.name) && this.age == other.age;
        }

        // If the object is not of type Person, return false
        return false;
    }

    // Overriding hashCode() method
    @Override
    public int hashCode() {
        // Generate hashCode based on name and age
        return Objects.hash(name, age);
    }

    // To demonstrate comparison result in a readable format
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        // Create some Person objects
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);
        Person p3 = new Person("Bob", 30);
        Person p4 = new Person("Charlie", 35);

        // Check equals and hashCode consistency
        System.out.println("p1 equals p2: " + p1.equals(p2)); // true
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode())); // true

        // Unequal objects with different hash codes
        System.out.println("p1 equals p3: " + p1.equals(p3)); // false
        System.out.println("p1.hashCode() == p3.hashCode(): " + (p1.hashCode() == p3.hashCode())); // false or true

        // Consistent hash code for the same object
        System.out.println("p1.hashCode() (first call): " + p1.hashCode());
        System.out.println("p1.hashCode() (second call): " + p1.hashCode());

        // Equal objects should have the same hash code
        System.out.println("p1.hashCode() == p2.hashCode(): " + (p1.hashCode() == p2.hashCode())); // true

        // Checking the hash code of unequal objects
        System.out.println("p3.hashCode(): " + p3.hashCode());
        System.out.println("p4.hashCode(): " + p4.hashCode());
    }
}

