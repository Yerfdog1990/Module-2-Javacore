package ReflectionOfClass;
/*
Java Reflection
In Java, reflection allows us to inspect and manipulate classes, interfaces, constructors, methods, and fields at run time.
There is a class in Java named Class that keeps all the information about objects and classes at runtime.
The object of Class can be used to perform reflection.

Reflection of Java Classes
In order to reflect a Java class, we first need to create an object of Class.
And, using the object we can call various methods to get information about methods, fields, and constructors present in a class.
There exists three ways to create objects of Class:
    1.Using forName() method
    2.Using getClass() method
    3.Using .class extension
 */
public class Dog {
    public static void main(String[] args) {

        Dog dog = new Dog(); // create object of Class
        try {
            Class c1 = Class.forName("ReflectionOfClass.Dog");// Use forName() method to reflect the Dog class
            System.out.println("Class reflection using forName() method: " +c1);
            Class c2 = dog.getClass(); //Using getClass() method to reflect the Dog class.
            System.out.println("Class reflection using getClass() method: " +c2);
            Class c3 = Dog.class; //Using .class extension to reflect the Dog class.
            System.out.println("Class reflection using .class extension: " +c3);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
