package setAccessible;

import java.lang.reflect.Field;

public class Person {
    private final String name;
    private final int age;
    private final String career;

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
        Person person = new Person(34, "Yerfdog", "Software developer");
        System.out.printf("Original details: %n%s%n", person);
        Field[] fields = Person.class.getDeclaredFields();
        System.out.println("\nNew details: ");
        for(Field field : fields){
           field.setAccessible(true);
           try {
               System.out.println(field.get(new Person(20, "Godfrey", "Programmer")));
           } catch (IllegalAccessException e) {
               e.printStackTrace();
           }
       }
    }
}
