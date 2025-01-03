package GetClassName;

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
        try {
            // 1. Using Class.forName()
            Class<?> classForName = Class.forName("GetClassName.Person");
            System.out.println("Using Class.forName(): " +classForName.getName());

            // 2. Using .class
            Class<?> classDotClass = Person.class;
            System.out.println("Using .class: " +classDotClass.getName());

            // 3. Using .getClass()
            Person personinstance = new Person(34, "yerfdog");
            Class<?> classGetClass = personinstance.getClass();
            System.out.println("Using .getClass: " +classGetClass.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
