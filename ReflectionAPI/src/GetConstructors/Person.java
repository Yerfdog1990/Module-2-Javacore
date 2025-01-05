package GetConstructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Person {
    private String name;
    private int age;
    public String career;

    //Public constructor
    public Person(int age, String name, String career) {
        this.age = age;
        this.name = name;
        this.career = career;
    }
    //Private constructor
    private Person(String career) {
        this.career = career;
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
                "\nAge: " +age+
                "\nCareer: " +career);
    }
    //Main method
    public static void main(String[] args) {
        Class<?> personClass = Person.class;
        //Get constructors
        System.out.println("Get constructors:");
        Constructor<?>[] constructors = personClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

        //Get constructors
        System.out.println("\nGet declared constructors:");
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(System.out::println);

    }
}
