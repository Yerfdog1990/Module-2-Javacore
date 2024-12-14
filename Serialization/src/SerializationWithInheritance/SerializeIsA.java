package SerializationWithInheritance;

import java.io.*;

/**
 * Demonstrates the Java serialization and deserialization process in the context
 * of inheritance. This class utilizes the IS-A relationship where if a class implements
 * the Serializable interface, its subclasses also become serializable.
 *
 * The main method showcases:
 * - Initialization and usage of a `Student` (subclass of `Person`) object.
 * - Printing the details of a `Student` object.
 * - Serializing the `Student` object to a file.
 * - Deserializing the `Student` object from the file and reconstructing it in memory.
 *
 * This ensures that objects of subclasses like `Student`, which extend the `Person` class
 * that implements Serializable, can also be serialized and deserialized seamlessly.
 */
public class SerializeIsA {
  /**
   * The entry point of the program demonstrating serialization and deserialization
   * with inheritance using the Student and Person classes. This method initializes
   * a Student object, prints its details, serializes it to a file, and deserializes it back.
   *
   * @param args command-line arguments passed to the program
   */
  public static void main(String[] args) {
    Student student = new Student("John", 25, "Computer Science");
    student.printDetails();
    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
      outputStream.writeObject(student);
      System.out.println("Object was successfully serialized.");
    }catch (Exception e){
      System.out.println("Object was not serialized.");
    }
    try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.ser"))){
      student = (Student) objectInputStream.readObject();
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
}
class Student extends Person{
  private final String major;
  public Student(String name, int age, String major) {
    super(name, age);
    this.major = major;
  }
  public String getMajor() {
    return major;
  }
  public void printDetails(){
    System.out.println("Student Details:");
    System.out.println("\tName: " +getName());
    System.out.println("\tAge: " +getAge());
    System.out.println("\tMajor: " +getMajor());
  }
}