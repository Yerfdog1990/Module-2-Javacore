package GetFieldName;

import java.lang.reflect.Field;

public class Person {
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
        try {
            // Create class object
            Class<?> personClass = Class.forName("GetFieldName.Person");

            // Using getDeclaredField():
            System.out.println("Using getDeclaredField():");
            Field[] declaredFields = personClass.getDeclaredFields();
            for(Field field : declaredFields){
                System.out.println(field.getName());
            }
            // Using getFields
            System.out.println("Using getFields():");
            Field[] fields = personClass.getFields();
            for(Field field : fields){
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
