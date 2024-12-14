package SerializationWithInheritance;

import java.io.*;

/*
Java Serialization with Inheritance (IS-A Relationship)
If a class implements Serializable interface then all its subclasses will also be serializable.
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
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
      FileOutputStream outputStream = new FileOutputStream("student.ser");
      outputStream.write(byteArrayOutputStream.toByteArray());
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