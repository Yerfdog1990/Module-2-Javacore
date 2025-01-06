package Constructor.newInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Person {
    private String name;
    private int age;
    private String career;

    {
        name = "Yerfdog";
        age = 34;
        career = "Software Developer";
    }

    //Default constructor
    public Person() {
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
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> personConstructor = Person.class.getConstructor();
        System.out.println(personConstructor);

        Person newInstance = (Person) personConstructor.newInstance();
        System.out.println(newInstance);
    }
}
