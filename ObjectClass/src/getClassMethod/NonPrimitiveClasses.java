package getClassMethod;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/*
Java getClass() Method
The getClass() method in Java is part of the Object class, which is the root class for all Java objects.
This method is used to retrieve the runtime class of an object and can provide important metadata about the class.

Key Features of getClass() Method
    1.Runtime Class Retrieval: The getClass() method returns a Class object that represents the actual class of the object at runtime. This is particularly useful in scenarios where the exact type of an object is unknown at compile time.
    2.Locked by Static Synchronized Methods: The Class object returned by getClass() is the object that is locked by any static synchronized method of the represented class. This makes it a key part of the synchronization mechanism for static methods.
    3.Non-Overridable: The getClass() method is declared as final in the Object class. This means it cannot be overridden by subclasses.
    4.Does Not Accept Parameters: The getClass() method takes no parameters and returns the runtime class of the object on which it is called.
    5.Cannot Be Used on Primitive Data Types: Since getClass() is a method in the Object class, it cannot be called on primitive data types like int, char, boolean, etc.
    6.No Exceptions: The getClass() method does not throw any exceptions when called.
 */
public class NonPrimitiveClasses {

    // 1. String Class
    public void printStringClass() {
        String str = "Hello, World!";
        System.out.println("Class of str is: " + str.getClass());
    }

    // 2. Wrapper Classes
    public void printWrapperClasses() {
        Integer num = 42;
        System.out.println("Class of num is: " + num.getClass());

        Double decimal = 3.14;
        System.out.println("Class of decimal is: " + decimal.getClass());
    }

    // 3. Collection Framework - List
    public void printListClasses() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Item 1");
        System.out.println("Class of list is: " + list.getClass());

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        System.out.println("Class of linkedList is: " + linkedList.getClass());
    }

    // 4. Collection Framework - Set
    public void printSetClasses() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Element 1");
        System.out.println("Class of hashSet is: " + hashSet.getClass());

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        System.out.println("Class of treeSet is: " + treeSet.getClass());
    }

    // 5. I/O Classes
    public void printIOClasses() {
        File file = new File("example.txt");
        System.out.println("Class of file is: " + file.getClass());

        PrintWriter printWriter = new PrintWriter(System.out);
        System.out.println("Class of printWriter is: " + printWriter.getClass());
    }

    // 6. Concurrency Classes
    public void printConcurrencyClasses() {
        Thread thread = new Thread();
        System.out.println("Class of thread is: " + thread.getClass());

        CountDownLatch latch = new CountDownLatch(1);
        System.out.println("Class of latch is: " + latch.getClass());
    }

    // 7. Utility Classes
    public void printUtilityClasses() {
        Random random = new Random();
        System.out.println("Class of random is: " + random.getClass());

        Date date = new Date();
        System.out.println("Class of date is: " + date.getClass());
    }

    // 9. Object Class
    public void printObjectClass() {
        Object object = new Object();
        System.out.println("Class of object is: " + object.getClass());
    }
    // 9. Custom Classes
    public void printCustomClass() {
        CustomClass customObj = new CustomClass();
        System.out.println("Class of customObj is: " + customObj.getClass());
    }

    // Custom Class Definition
    class CustomClass {
        // Custom class code here
    }

    // Main method to test all the print methods
    public static void main(String[] args) {
        NonPrimitiveClasses npc = new NonPrimitiveClasses();
        npc.printStringClass();
        npc.printWrapperClasses();
        npc.printListClasses();
        npc.printSetClasses();
        npc.printIOClasses();
        npc.printConcurrencyClasses();
        npc.printUtilityClasses();
        npc.printObjectClass();
        npc.printCustomClass();
    }
}

