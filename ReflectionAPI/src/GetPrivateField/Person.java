package GetPrivateField;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.printf("Field name: %s%nFiled modifier: %s%n", field.getName(), Modifier.toString(field.getModifiers()));
        }
    }
}
