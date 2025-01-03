package GetPackage;

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
        Class<?> personInstance = Person.class;
        String classPackage1 = personInstance.getPackageName();
        System.out.println(classPackage1);
        final Package classPackage2= personInstance.getPackage();
        System.out.println(classPackage2);

    }
}
