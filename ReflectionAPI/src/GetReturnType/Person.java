package GetReturnType;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
        Class<?> personInstance = Person.class;
        Method[] methods = personInstance.getDeclaredMethods();
        for (Method method : methods) {
            System.out.printf("%s%n", method.getReturnType());
        }
    }
}
