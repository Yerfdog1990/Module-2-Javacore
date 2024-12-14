package SerializationWithCollection;

import java.io.*;
import java.util.Arrays;
import java.util.List;


/**
 * The SerializeCollection class demonstrates object serialization and deserialization in Java.
 * It uses the ClassList class to serialize and deserialize an object to and from a file.
 * The serialized file is named "classList.ser".
 *
 * This class includes the following functionalities:
 * - Serialization of an object to a file using ObjectOutputStream
 * - Deserialization of an object from a file using ObjectInputStream
 * - Prints names from the ClassList using the printNames method
 *
 * The program handles exceptions for serialization and deserialization processes
 * to ensure proper error management.
 */
public class SerializeCollection {
    public static void main(String[] args) {
        ClassList classList = new ClassList();
        classList.printNames();
        //Serialize array objects
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("classList.ser"))){
            objectOutputStream.writeObject(classList);
            System.out.println("Object was successfully serialized.");
        }catch (Exception e){
            System.out.println("Object was not serialized.");
        }
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("classList.ser"))){
            classList = (ClassList) objectInputStream.readObject();
            System.out.println("Object was successfully deserialized.");
        }catch (Exception e){
            System.out.println("Object was not deserialized.");
        }
    }
}
class ClassList implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String[] names = {"John", "George", "June"};

    public void printNames() {
        List<String> list = Arrays.asList(names);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1)+ "." +names[i]);
        }
    }
}
