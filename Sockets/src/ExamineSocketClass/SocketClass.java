package ExamineSocketClass;

import java.lang.reflect.Method;
import java.net.Socket;

public class SocketClass {
    public static void main(String[] args) {
        Class<?> socketClass = Socket.class;
        System.out.printf("Name of the class: %s%n", socketClass.getName());
        //Get methods of socket class
        Method[] methods = socketClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.printf("Method name: %s%n", method.getName());
        }
    }
}
