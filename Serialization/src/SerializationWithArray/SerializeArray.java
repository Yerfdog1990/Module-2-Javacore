package SerializationWithArray;

import java.io.*;

/**
 * The SerializeArray class demonstrates the process of serializing and deserializing objects
 * in Java using the ClassRegister class. It handles file input/output operations to persist
 * state and retrieve the serialized object.
 *
 * This class performs the following actions:
 * 1. Prints the names in the ClassRegister object.
 * 2. Serializes the ClassRegister object to a file named "classRegister.ser".
 * 3. Deserializes the ClassRegister object from the file.
 *
 * Exception handling is implemented to provide feedback about the success or failure
 * of serialization and deserialization processes.
 *
 * Instances of ClassRegister are serialized and deserialized using ObjectOutputStream
 * and ObjectInputStream, respectively.
 */
public class SerializeArray {
    public static void main(String[] args) {
        ClassRegister classRegister = new ClassRegister();
        classRegister.printNames();
        //Serialize array objects
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("classRegister.ser"))){
           objectOutputStream.writeObject(classRegister);
            System.out.println("Object was successfully serialized.");
        }catch (Exception e){
            System.out.println("Object was not serialized.");
        }
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("classRegister.ser"))){
            classRegister = (ClassRegister) objectInputStream.readObject();
            System.out.println("Object was successfully deserialized.");
        }catch (Exception e){
            System.out.println("Object was not deserialized.");
        }
    }
}
class ClassRegister implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String[] names = {"John", "George", "June"};

    public void printNames() {
        for (int i = 0; i < names.length; i++) {
            System.out.println((i+1)+ "." +names[i]);
        }
    }
}
