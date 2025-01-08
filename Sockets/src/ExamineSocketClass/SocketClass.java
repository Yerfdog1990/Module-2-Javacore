package ExamineSocketClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.Socket;

public class SocketClass {
    public static void main(String[] args) {
        Class<?> socketClass = Socket.class;
        System.out.printf("Name of the class: %s%n", socketClass.getName());
        //Get constructors of socket class
        Constructor<?>[] constructors = socketClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.printf("Constructor: %s%n", constructor.toString());
        }
        
        //Get methods of socket class
        Method[] methods = socketClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.printf("Method name: %s%n", method.getName());
        }
        
    }
}
