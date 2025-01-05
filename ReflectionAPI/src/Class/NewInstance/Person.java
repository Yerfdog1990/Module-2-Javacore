package Class.NewInstance;

import java.lang.reflect.Field;

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
    public static void main(String[] args) {
        try {
            Person person = Person.class.newInstance();
            System.out.println(person);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
