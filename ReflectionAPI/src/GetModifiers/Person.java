package GetModifiers;

import java.lang.reflect.Modifier;
import java.lang.reflect.Method;

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
        int classModifiers = personInstance.getModifiers();
        System.out.println(classModifiers);

        boolean isPublic = Modifier.isPublic(classModifiers);
        boolean isStatic = Modifier.isStatic(classModifiers);
        boolean isFinal = Modifier.isFinal(classModifiers);
        boolean isAbstract = Modifier.isAbstract(classModifiers);
        boolean isInterface = Modifier.isInterface(classModifiers);

        System.out.printf("Class modifiers: %d%n", classModifiers);
        System.out.printf("Is public: %b%n", isPublic);
        System.out.printf("Is static: %b%n", isStatic);
        System.out.printf("Is final: %b%n", isFinal);
        System.out.printf("Is abstract: %b%n", isAbstract);
        System.out.printf("Is interface: %b%n", isInterface);

    }
}
