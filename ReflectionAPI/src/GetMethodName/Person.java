package GetMethodName;

import java.lang.reflect.Method;
import java.util.List;

public class Person {
    private final String name;
    private final int age;

    //Constructor
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return ("Name: " +name+
                "\nAge: " +age);
    }
    //Main method
    public static void main(String[] args) {
        try {
            // Get the Class object
            Class<?> personClass = Class.forName("GetMethodName.Person");
            // 1. Using getDeclaredMethods()
            System.out.println("Using getDeclaredMethods():");
            Method[] declaredMethods = personClass.getDeclaredMethods();
            for(Method method : declaredMethods){
                System.out.println(method.getName());
            }
            // 2. Using getMethods()
            System.out.println("\nUsing getMethods():");
            Method[] methods = personClass.getMethods();
            for(Method method : methods){
                System.out.println(method.getName());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
