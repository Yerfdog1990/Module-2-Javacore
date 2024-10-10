package Super_Extend_List;

// Zoo class is generic and only accepts types that extend the Cat class
public class Zoo <T extends Cat> {
    // A field to hold a reference to a Cat (or any subclass of Cat)
    T cat;

    // Getter method for the cat object
    public T getCat() {
        return cat;
    }

    // Setter method to set the cat object
    public void setCat(T cat) {
        this.cat = cat;
    }

    // Method to return the name of the cat
    String getCatName() {
        // Retrieves the name of the cat by calling its getName method
        return this.cat.getName();
    }
}

// Cat class representing a simple object with a name property
class Cat {
    // The name of the cat, initialized with a default value
    private String name;

    // Constructor to set the name of the cat
    public Cat(String name) {
        this.name = name;
    }

    // Getter method for the name property
    public String getName() {
        return name;
    }

    // Setter method for the name property
    public void setName(String name) {
        this.name = name;
    }
}

// Main class to test the Zoo and Cat classes
class MainZoo {
    public static void main(String[] args) {
        // Creating a Zoo object that can hold Cat objects
        Zoo<Cat> zoo = new Zoo<Cat>();

        // Setting a new Cat object in the Zoo with the name "Tom"
        zoo.setCat(new Cat("Tom"));

        // Printing the name of the cat in the Zoo
        System.out.println(zoo.getCatName());
    }
}
