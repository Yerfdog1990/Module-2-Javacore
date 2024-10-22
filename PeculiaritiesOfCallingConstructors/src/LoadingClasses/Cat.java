package LoadingClasses;
/*
Static Blocks in Java
    1.Purpose: Static blocks are used for initializing static variables or executing static logic when the class is loaded into memory.
    2.Execution: When a class is loaded for the first time (on first access), all static blocks are executed in the order they appear, before any static variables or methods are accessed.
    3.Multiple Static Blocks: A class can contain multiple static blocks, and they will be executed sequentially.
    4.Static Variables: Static blocks are useful for performing complex initialization of static variables, such as reading data from files or performing calculations.
    5.Static Constructor Alternative: Java doesn't support static constructors, but static blocks serve a similar purpose by allowing static initialization.

Explanation:
    When a class is loaded into memory for the first time, the Java Virtual Machine (JVM) checks if the class is initialized.
    If not, it executes all the static blocks in the class, which can be used to initialize static variables or perform any static actions needed for the class.
    Static blocks are executed only once, at the time of class loading, and before any instance of the class is created or any static members are accessed.
 */

import java.util.Properties;

class Cat {
    public static int catCount;
    public static String namePrefix;
    public static int maxCatCount;

    // First static block to initialize 'catCount' and 'namePrefix'
    static {
        catCount = 0;  // Setting initial value for catCount
        Properties p = new Properties();
        // Simulating loading 'namePrefix' without exception handling
        namePrefix = p.getProperty("name-prefix", "DefaultName");
    }

    // Second static block to initialize 'maxCatCount'
    static {
        maxCatCount = 50;  // Default value for maxCatCount
        Properties p = new Properties();
        // Simulating loading 'cat-max' without exception handling
        String catMaxStr = p.getProperty("cat-max", "50");
        maxCatCount = Integer.parseInt(catMaxStr);  // Update maxCatCount with value
    }

    public static void main(String[] args) {
        System.out.println("Cat Count: " + Cat.catCount);
        System.out.println("Name Prefix: " + Cat.namePrefix);
        System.out.println("Max Cat Count: " + Cat.maxCatCount);
    }
}
