package GetSuperClass;

class Man{

}
public class Person extends Man{
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
        Class<Person> personInstance = Person.class;
        Class<? super Person> superClass = personInstance.getSuperclass();
        System.out.println(superClass);
    }
}
