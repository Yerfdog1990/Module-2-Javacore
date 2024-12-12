package Serialize_Deserialize;

import java.io.*;

/**
 * MyClass is a serializable class that contains a name and age for demonstrating
 * the serialization and deserialization process in Java.

 * This class implements the Serializable interface, allowing objects of this type
 * to be converted into a byte stream and subsequently restored. The primary
 * functionality involves persisting the state of an object and reconstructing it.
 */
public class MyClass implements Serializable {
    //Class fields
    String name;
    int age;

    //Constructor
    public MyClass(int age, String name) {
        this.age = age;
        this.name = name;
    }
    /**
     * The main method demonstrating the process of serializing and deserializing an instance
     * of the MyClass object. It writes the object's state to a file and retrieves it back.
     *
     * @param args the command-line arguments passed to the program
     */
    //Main method
    public static void main(String[] args) {
        //Declare file name
        String fileName = "myClass.ser";
        //Instantiate MyClass
        MyClass myClass = new MyClass(34,"Godfrey");
        //Perform serialization
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(myClass);
            System.out.println("Object serialized successfully.");
        }catch (Exception e){
            System.out.println("Exception was caught.");
        }
        //Perform deserialization
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            MyClass myClass1 = (MyClass) in.readObject();
            System.out.println("Object deserialized successfully.");
            System.out.printf("Name: %s.\n", myClass1.name);
            System.out.printf("Age: %d.\n", myClass1.age);
        }catch (Exception e){
            System.out.println("Exception was caught.");
        }
    }
}
