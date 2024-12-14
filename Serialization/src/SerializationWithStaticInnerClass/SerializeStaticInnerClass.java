package SerializationWithStaticInnerClass;

import java.io.*;

/**
 * This class demonstrates the serialization and deserialization of an object of a static
 * inner class that implements the Serializable interface. The program defines a static
 * inner class `Student` inside another class `Person`, with relevant fields and methods.
 *
 * Main functionality includes:
 * - Creation of a `Person` object and a corresponding `Student` object.
 * - Serialization of the `Student` object into a file.
 * - Deserialization of the `Student` object from the file.
 * - Displaying the details of the deserialized `Student` object.
 *
 * The static inner class `Student` has a reference to the outer class `Person`, making it
 * part of the serialized data.
 */
public class SerializeStaticInnerClass {
    public static void main(String[] args) {
        Person person = new Person("John", 25);
        Person.Student student = new Person.Student(person, "Computer Science");
        student.printDetails();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            outputStream.writeObject(student);
            System.out.println("Object was successfully serialized.");
        }catch (Exception e){
            System.out.println("Object was not serialized.");
        }
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.ser"))){
            student = (Person.Student) objectInputStream.readObject();
            System.out.println("Object was successfully deserialized.");
        }catch (Exception e){
            System.out.println("Object was not deserialized.");
        }
    }
}
class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    static class Student implements Serializable {
        private final String major;
        Person person;

        public Student(Person person, String major) {
            this.person = person;
            this.major = major;
        }
        public String getMajor() {
            return major;
        }
        public void printDetails(){
            System.out.println("Student Details:");
            System.out.println("\tName: " +person.name);
            System.out.println("\tAge: " +person.getAge());
            System.out.println("\tMajor: " +getMajor());
        }
    }
}
