package AbstractFactoryMethodDesignPattern;

import java.util.Scanner;

/*
Abstract Factory Design Pattern
Definition:
The Abstract Factory Design Pattern provides an interface to create families of related or dependent objects without specifying their concrete classes.
It adds an additional layer of abstraction over the Factory Pattern. Below is when to use Abstract Factory Method Design Pattern:
    1. A system should be independent of how its products are created, composed, and represented.
    2. A system should be configured with one of multiple families of products.
    3. A family of related product objects is designed to be used together, and you need to enforce this constraint.
    4. You want to provide a class library of products, and you want to reveal just their interfaces, not their implementations.

Key Characteristics:
    1. Creates multiple types of related products (families of products).
    2. Involves multiple factory methods grouped under an abstract factory interface.
    3. Useful when products created together belong to a particular theme or family (e.g., different UI themes for buttons, checkboxes).

Structure:
    1. Abstract Product Interfaces: Declares interfaces for different types of products.
    2. Concrete Products: Implement the abstract product interfaces.
    3. Abstract Factory Interface: Declares methods to create different types of products.
    4. Concrete Factories: Implement the abstract factory to produce related products.
 */
// Step 1: Define Abstract Product Interfaces
public interface Button {
    void render();
}
interface Checkbox{
    void render();
}
// Step 2: Create Concrete Products for each family
class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering a Windows-style button.");
    }
}
class MacOSButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering a MacOS-style button.");
    }
}
class WindowsCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering a Windows-style checkbox.");
    }
}
class MacOSCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering a MacOS-style checkbox.");
    }
}
// Step 3: Define Abstract Factory Interface
interface GUIFactory{
    Checkbox createCheckbox();
    Button createButton();
}
// Step 4: Create Concrete Factories
class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }
    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
// Step 5: Client Code
class Application{
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.checkbox = factory.createCheckbox();
        this.button = factory.createButton();
    }
    public void render(){
        button.render();
        checkbox.render();
    }
}
// Step 6: Factory Provider
class AbstractFactoryDemo{
    public static void main(String[] args) {
        try (Scanner osType = new Scanner(System.in)){
            GUIFactory factory = null;
            while (factory == null){
                System.out.print("Enter the OS type: ");
                String userInput = osType.nextLine();
                try {
                    if(userInput.equalsIgnoreCase("Windows")){
                        factory = new WindowsFactory();
                    } else if (userInput.equalsIgnoreCase("MacOS")) {
                        factory = new MacOSFactory();
                    }else{
                        throw new IllegalArgumentException("Unknown OSType! Try again.");
                    }
                }catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }
            factory.createButton();
            factory.createCheckbox();
            Application app = new Application(factory);
            app.render();
        }
    }
}