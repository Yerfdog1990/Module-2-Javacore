package CustomAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define the annotation
@Target({ElementType.TYPE, ElementType.METHOD})// Can be applied to classes and methods
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
public @interface Info {
    String author() default "Unknown"; // Default author value
    String version() default "1.0"; // Default version value
}
// Apply the Annotation
@Info(author = "Alice", version = "1.0") // Applied to a class
class MyClass1 {
    @Info(author = "Alice", version = "1.1" ) // Applied to a method
    public void myMethod1() {
        System.out.println("MyClass1: myMethod1 is running");
    }
}
@Info(author = "Juma", version = "2.8") // Applied to a class
class MyClass2 {
    @Info(author = "Juma") // Default version is used
    public void myMethod2() {
        System.out.println("MyClass2: muMethod2 is running\n");
    }
}
//Process the Annotation at Runtime
class AnnotationProcessor {
    public static void main(String[] args) {
        // Array of classes to process
        MyClass1 myClass1 = new MyClass1();
        myClass1.myMethod1();
        MyClass2 myClass2 = new MyClass2();
        myClass2.myMethod2();
        Class<?>[] classes = {MyClass1.class, MyClass2.class};
        for(Class<?> aClass : classes){
            // Check if the class has the Info annotation
            if(aClass.isAnnotationPresent(Info.class)){
                Info info = aClass.getAnnotation(Info.class);
                System.out.printf("Class: %s%n", aClass.getName());
                System.out.printf("Author: %s%n", info.author());
                System.out.printf("Version: %s%n", info.version());
                System.out.println();
            }
            // Process methods of the class
            for(Method method : aClass.getDeclaredMethods()){
                if(method.isAnnotationPresent(Info.class)){
                    Info info = method.getAnnotation(Info.class);
                    System.out.printf("Method: %s%n", method.getName());
                    System.out.printf("Author: %s%n", info.author());
                    System.out.printf("Version: %s%n", info.version());
                    System.out.println();
                }
            }
        }
    }
}