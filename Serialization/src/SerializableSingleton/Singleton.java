package SerializableSingleton;

import java.io.*;

public class Singleton implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final Singleton INSTANCE = new Singleton();
    private String text = "Hello from singleton";

    private Singleton() {
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public static Singleton getINSTANCE() {
        return INSTANCE;
    }
    /**
     * Ensures that the singleton instance is returned during deserialization.
     *
     * @return The singleton instance of the class.
     * @throws ObjectStreamException If an error occurs during deserialization.
     */
    @Serial
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Singleton obj = Singleton.getINSTANCE();
        ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(obj);

        Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);
        System.out.println(singleton1.getText());
        Singleton singleton2 = deserializeSingletonInstance(byteArrayOutputStream);
        System.out.println(singleton2.getText());
        //Check both singleton1 and singleton2
        System.out.println("Checking singleton1 address: " + singleton1);
        System.out.println("Checking singleton2 address: " + singleton2);
        System.out.println("Both singleton1 and singleton2 point to the same address: " + (singleton1 == singleton2));
    }
    //Method to perform serialization
    public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try(ObjectOutputStream  out = new ObjectOutputStream(byteArrayOutputStream)){
            out.writeObject(instance);
        }
        return byteArrayOutputStream;
    }
    //Method to deserialize singleton instance
    public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try(ObjectInputStream in = new ObjectInputStream(byteArrayInputStream)){
            return (Singleton) in.readObject();
        }
    }
}
