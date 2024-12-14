package SerializationWithAggregation;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

/**
 * The HASARelationship class demonstrates the HAS-A (composition) relationship in object-oriented programming.
 * It represents a relationship where a class contains a reference to another class.
 *
 * In this example:
 * - The Person class models a person with attributes such as name and age.
 * - The Student class contains a reference to a Person object, representing the HAS-A relationship.
 *
 * Features:
 * - Demonstrates how a Student object "has a" Person.
 * - The Student object also has a major field representing the student's major subject.
 * - Illustrates the concept of serialization and deserialization of objects.
 * - Prints the details of the Student object, including the associated Person details.
 */
public class HASARelationship {
    public static void main(String[] args) {
        Person person = new Person("John", 25);
        Student student = new Student(person, "Computer Science");
        student.printDetails();

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.ser"))){
            objectOutputStream.writeObject(student);
            System.out.println("Object was successfully serialized.");
        }catch (Exception e){
            System.out.println("Object was not serialized.");
        }
    }
}
class Person implements Serializable{
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
}
class Student implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    Person person; //Creating a reference to the Person class.
    String major;
    public Student(Person person, String major) {
        this.person = person;
        this.major = major;
    }
    public Person getPerson() {
        return person;
    }
    public String getMajor() {
        return major;
    }
    public void printDetails(){
        System.out.println("Student Details:");
        System.out.println("\tName: " +getPerson().getName());
        System.out.println("\tAge: " +getPerson().getAge());
        System.out.println("\tMajor: " +getMajor());
    }
}