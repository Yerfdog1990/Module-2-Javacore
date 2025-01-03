package GetInterfaces;


import java.io.Serializable;
import java.rmi.Remote;
import java.util.Arrays;

public class Person implements Serializable, Cloneable, Remote {
    private final String name;
    private final int age;
    public String career;

    //Constructor
    public Person(int age, String name, String career) {
        this.age = age;
        this.name = name;
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
       Class<?> personInstance = Person.class;
       final Class<?>[] interfaces = personInstance.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
    }
}
