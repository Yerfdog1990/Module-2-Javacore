package GetParameterType;

import java.lang.reflect.TypeVariable;

public class Person<T, U> {
    private final T name;
    private final U age;

    //Constructor
    public Person(U age, T name) {
        this.age = age;
        this.name = name;
    }
    public T getName() {
        return name;
    }
    public U getAge() {
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
        TypeVariable<?>[] typeParameters = personInstance.getTypeParameters();
        System.out.println("Get a parameter type():");
        for (TypeVariable<?> type : typeParameters) {
            System.out.printf("Name: %s%n", type.getName());
            System.out.printf("Bounds: %s%n", type.getBounds()[0]);
        }
        System.out.println("\nGeneric parameter type():");
        for (TypeVariable<?> type : typeParameters) {
            System.out.printf("%s%n", type);
        }
    }
}
