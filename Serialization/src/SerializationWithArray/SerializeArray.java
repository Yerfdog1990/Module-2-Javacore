package SerializationWithArray;

import java.io.*;

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
