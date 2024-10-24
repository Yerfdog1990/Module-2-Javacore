package ReflectionOfMethods;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
Reflecting Fields, Methods, and Constructors
The package java.lang.reflect provides classes that can be used for manipulating class members. For example,
    1.Method class - provides information about methods in a class
    2.Field class - provides information about fields in a class
    3.Constructor class - provides information about constructors in a class

1. Reflection of Java Methods
The Method class provides various methods that can be used to get information about the methods present in a class. See example below.
 */
public class Dog {
    // methods of the class
    public void display() {
        System.out.println("I am a dog.");
    }

    private void makeSound() {
        System.out.println("Bark Bark");
    }
}

class Main {
    public static void main(String[] args) {
        try {

            // create an object of Dog
            Dog d1 = new Dog();

            // create an object of Class
            // using getClass()
            Class obj = d1.getClass();

            // using object of Class to
            // get all the declared methods of Dog
            Method[] methods = obj.getDeclaredMethods();

            // create an object of the Method class
            for (Method m : methods) {

                // get names of methods
                System.out.println("Method Name: " + m.getName());

                // get the access modifier of methods
                int modifier = m.getModifiers();
                System.out.println("Modifier: " + Modifier.toString(modifier));

                // get the return types of method
                System.out.println("Return Types: " + m.getReturnType());
                System.out.println(" ");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
