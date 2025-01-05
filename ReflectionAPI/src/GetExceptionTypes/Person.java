package GetExceptionTypes;

import javax.annotation.processing.Processor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

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
    public static void main(String[] args) throws Exception, IllegalAccessException, InstantiationException, NoSuchMethodException{
        Method[] methods = Person.class.getDeclaredMethods();
        for (Method method : methods) {
            Type[] exceptionTypes = method.getGenericExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.printf("Method name: %s%nException: %s%n",
                        method.getName(), Arrays.toString(exceptionTypes));
            }
        }
    }
}
