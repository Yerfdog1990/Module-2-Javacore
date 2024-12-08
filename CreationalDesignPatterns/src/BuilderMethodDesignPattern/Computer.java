package BuilderMethodDesignPattern;
/*
Builder Method Design Pattern
Definition
Builder Design Pattern is used to separate the construction of a complex object from its representation so that the same construction process can create different representations.
This pattern is particularly useful when the object has numerous optional parameters or configurations.
It helps in constructing a complex object step by step and the final step will return the object. Use It when:
    1.The algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.
    2.The construction process must allow different representations for the object that's constructed.

Key Features
    1.Separation of Construction and Representation: The process of building the object is separated from the object itself.
    2.Step-by-Step Construction: The object is constructed incrementally.
    3.Fluent Interface: The builder often provides a chainable interface to improve readability.
    4.Multiple Representations: Allows the same construction process to create different types of objects.

Structure of the Builder Pattern
    1.Product: The complex object being built.
    2.Builder Interface: Defines the steps to build the product.
    3.Concrete Builder: Implements the steps defined by the builder interface.
    4.Director: Manages the construction process.
    5.Client: Uses the director and builder to create the object.
 */

// Product class: Represents the complex object
public class Computer {
    private String CPU;
    private String GPU;
    private String storage;
    private String RAM;

    // Private constructor to enforce the use of the builder
    private Computer(ComputerBuilder builder) {
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.CPU = builder.CPU;
    }

    @Override
    public String toString() {
        return "Computer[RAM = " + RAM + ", Storage = " + storage + ", GPU = " + GPU + ", CPU = " + CPU + "]";
    }

    // Builder Class
    static class ComputerBuilder {
        private String CPU;
        private String GPU;
        private String storage;
        private String RAM;

        // Step-by-step methods to set attributes
        public ComputerBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        // Final method to construct the object
        public Computer build() {
            return new Computer(this);
        }
    }
}
// Director class: Manages the construction process
class ComputerDirector {
    public Computer buildGamingPC() {
        return new Computer.ComputerBuilder()
                .setCPU("Intel Core i9")
                .setRAM("32GB")
                .setGPU("NVIDIA RTX 4080")
                .setStorage("1TB SSD")
                .build();
    }
    public Computer buildOfficePC() {
        return new Computer.ComputerBuilder()
                .setCPU("Intel Core i5")
                .setRAM("16GB")
                .setGPU("Integrated Graphics")
                .setStorage("512GB SSD")
                .build();
    }
}
// Client Code
class BuilderPatternDemo{
    //Main method
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        Computer gamingPC = director.buildGamingPC();
        System.out.println("Gaming PC configuration: " +gamingPC);
        Computer officePC = director.buildOfficePC();
        System.out.println("Office PC configuration: " +officePC);
    }
}