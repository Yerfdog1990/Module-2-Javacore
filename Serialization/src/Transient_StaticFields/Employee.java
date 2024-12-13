package Transient_StaticFields;

import java.io.*;

public class Employee implements Serializable {
    // Unique identifier for serialization (this is standard practice)
    private static final long serialVersionUID = 1L;
    // Transient fields are not saved during serialization
    transient int temporaryField;
    // Static fields are shared across instances and are not serialized
    static int staticField;
    // Regular instance variables
    String name;
    int age;

    public Employee(int temporaryField, String name, int age, int staticField) {
        this.temporaryField = temporaryField;
        this.name = name;
        this.age = age;
        this.staticField = staticField;
    }
}
class SerializationDemo {
    public static void printEmployeeDetails(Employee employee){
        System.out.println("\tName: " +employee.name);
        System.out.println("\tAge: " +employee.age);
        System.out.println("\tTemporary Field: " +employee.temporaryField);
        System.out.println("\tStatic Field: " +Employee.staticField);
    }
    /**
     * The main method demonstrating the serialization and deserialization process of an
     * Employee object. It writes the object's state to a file and retrieves it back, while
     * also examining behaviors of transient and static fields.
     *
     * @param args the command-line arguments passed to the program
     * while deserializing the object the values of temporaryField and staticFiled changed.
     * The reason being temporaryField was marked as transient and staticFiled was static.
     *
     * In case of transient variables:- A variable defined with transient keyword is not serialized during serialization process.This variable will be initialized with default value during deserialization. (e.g: for objects it is null, for int it is 0).
     * In case of static Variables:- A variable defined with static keyword is not serialized during serialization process.This variable will be loaded with current value defined in the class during deserialization.
     * Transient Vs Final:
     * final variables will be participated into serialization directly by their values.
     * Hence declaring a final variable as transient there is no use.
     * //the compiler assign the value to final variable
     */
    public static void main(String[] args) {
        Employee employee = new Employee(42, "Juma", 34, 1000);
        String fileName = "employee.ser";
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(employee);
            out.close();
            System.out.println("Object serialized successfully.");
            System.out.println("Data before deserialization:");
            printEmployeeDetails(employee);

            // Change the static field value to see its behavior after deserialization
            employee.staticField = 100;
        }catch (Exception e){
            System.out.println("Exception was caught.");
        }
        employee = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            employee = (Employee) in.readObject();
            in.close();
            System.out.println("\nObject deserialized successfully.");
            System.out.println("Data after deserialization:");
            printEmployeeDetails(employee);
        }catch (Exception e){
            System.out.println("Exception was caught.");
        }
    }
}
