package ShallowVsDeepCloning;

public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Shallow Cloning Example
        System.out.println("Shallow Cloning:");
        PersonShallow p1 = new PersonShallow("John", new Address("123 Main St", "New York"));
        PersonShallow p1Clone = (PersonShallow) p1.clone();

        System.out.println("Original Person: " + p1);
        System.out.println("Cloned Person: " + p1Clone);

        // Modifying the address of the cloned person
        p1Clone.address.city = "Los Angeles";

        System.out.println("After modifying the clone's address:");
        System.out.println("Original Person: " + p1);  // The original's address is also affected
        System.out.println("Cloned Person: " + p1Clone);

        // Deep Cloning Example
        System.out.println("\nDeep Cloning:");
        PersonDeep p2 = new PersonDeep("Alice", new Address("456 Oak St", "Boston"));
        PersonDeep p2Clone = (PersonDeep) p2.clone();

        System.out.println("Original Person: " + p2);
        System.out.println("Cloned Person: " + p2Clone);

        // Modifying the address of the cloned person
        p2Clone.address.city = "San Francisco";

        System.out.println("After modifying the clone's address:");
        System.out.println("Original Person: " + p2);  // The original's address is not affected
        System.out.println("Cloned Person: " + p2Clone);
    }
}

// Class for shallow cloning
class PersonShallow implements Cloneable {
    String name;
    Address address;

    public PersonShallow(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // Shallow clone (copies the reference)
    }

    @Override
    public String toString() {
        return name + " lives at " +address;
    }
}

// Class for deep cloning
class PersonDeep implements Cloneable {
    String name;
    Address address;

    public PersonDeep(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Deep clone: manually create a new Address object
        PersonDeep cloned = (PersonDeep) super.clone();
        cloned.address = new Address(this.address.street, this.address.city); // Create a new Address
        return cloned;
    }

    @Override
    public String toString() {
        return name + " lives at " + address;
    }
}

// Address class
class Address {
    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return street + ", " + city;
    }
}

