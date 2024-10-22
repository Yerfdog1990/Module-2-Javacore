package EqualMethod;
/*
The equals() method in Java is used to compare two objects for equality.
By default, the equals() method in the Object class checks if two object references point to the same memory location (i.e., if they are the same object).
However, we can override the equals() method to compare the content or state of objects for equality.

Conditions for Two Objects to Be Equal:
    1.Reflexive: For any non-null reference value a, a.equals(a) should return true. An object must be equal to itself.
    2.Symmetric: For any reference values a and b, if a.equals(b) returns true, then b.equals(a) must also return true. If one object is equal to another, the reverse must be true as well.
    3.Transitive: For any reference values a, b, and c, if a.equals(b) returns true and b.equals(c) returns true, then a.equals(c) must also return true. Equality must be transitive across multiple objects.
    4.Consistent: For any reference values a and b, multiple invocations of a.equals(b) must consistently return true or false, provided no information used in the comparison is modified.
    5.Null check: For any non-null reference value a, a.equals(null) must return false. An object should never be equal to null.
 */
class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding equals() method to demonstrate its principles
    @Override
    public boolean equals(Object obj) {
        // Reflexive: If obj is the same object, return true
        if (this == obj) {
            return true;
        }

        // Check if obj is an instance of Person
        if (obj instanceof Person) {
            Person other = (Person) obj;

            // Consistent, Symmetric, and Transitive check:
            // Check if name and age are equal for both objects
            return this.name.equals(other.name) && this.age == other.age;
        }

        // If the object is not of type Person or is null, return false
        return false;
    }

    // To demonstrate comparison result in a readable format
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        // Create Person objects
        Person p1 = new Person("John", 25);
        Person p2 = new Person("John", 25);
        Person p3 = new Person("John", 25);
        Person p4 = new Person("Jane", 30);

        // Reflexive: p1.equals(p1) should return true
        System.out.println("Reflexive: p1.equals(p1) = " + p1.equals(p1));

        // Symmetric: p1.equals(p2) and p2.equals(p1) should both return true
        System.out.println("Symmetric: p1.equals(p2) = " + p1.equals(p2));
        System.out.println("Symmetric: p2.equals(p1) = " + p2.equals(p1));

        // Transitive: p1.equals(p2), p2.equals(p3), and p1.equals(p3) should all return true
        System.out.println("Transitive: p1.equals(p2) = " + p1.equals(p2));
        System.out.println("Transitive: p2.equals(p3) = " + p2.equals(p3));
        System.out.println("Transitive: p1.equals(p3) = " + p1.equals(p3));

        // Consistent: p1.equals(p2) should always return true if no modification is made
        System.out.println("Consistent (first call): p1.equals(p2) = " + p1.equals(p2));
        System.out.println("Consistent (second call): p1.equals(p2) = " + p1.equals(p2));

        // Comparison with a different person object (p1.equals(p4) should return false)
        System.out.println("Comparison with different object: p1.equals(p4) = " + p1.equals(p4));

        // Handling null: p1.equals(null) should return false
        System.out.println("p1.equals(null) = " + p1.equals(null));
    }
}
