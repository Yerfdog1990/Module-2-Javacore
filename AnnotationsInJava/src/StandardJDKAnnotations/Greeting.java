package StandardJDKAnnotations;

import java.util.ArrayList;
import java.util.List;
/*
Annotations available in the JDK (`@Deprecated`, `@Override`, `@SuppressWarnings`, `@SafeVarargs`, and `@FunctionalInterface`):
Explanation:
    1. `@Override`: Ensures that a method is correctly overriding a method from its superclass or an interface.
    2. `@Deprecated`: Marks a method or class as deprecated, signaling that it should no longer be used, and usually replaced by another option.
    3. `@SuppressWarnings`: Suppresses compiler warnings for specific issues (like unchecked warnings).
    4. `@SafeVarargs`: Used to indicate that a method with variable arguments is safe to use (no heap pollution).
    5. `@FunctionalInterface`: Marks an interface as a functional interface, which is an interface with a single abstract method (used often in lambda expressions).
 */
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

class AnnotationsDemo {

    @Deprecated
    public void deprecatedMethod() {
        System.out.println("This method is deprecated!");
    }
    @Override
    public String toString() {
        return "AnnotationsDemo Example";
    }
    @SafeVarargs
    private void safeVarargsDemo(List<String>... lists) {
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
    @SuppressWarnings({"unchecked", "deprecation"})
    public void suppressWarningsDemo() {
        List rawList = new ArrayList(); // This would normally throw an "unchecked" warning
        rawList.add("Example");

        deprecatedMethod(); // Suppresses deprecation warnings
        for (Object obj : rawList) {
            System.out.println(obj);
        }
    }
    public static void main(String[] args) {
        AnnotationsDemo demo = new AnnotationsDemo();

        // Using @Deprecated method
        demo.deprecatedMethod();

        // Using @SuppressWarnings
        demo.suppressWarningsDemo();

        // Using @SafeVarargs
        List<String> list1 = List.of("One", "Two");
        List<String> list2 = List.of("Three", "Four");
        demo.safeVarargsDemo(list1, list2);

        // Using @FunctionalInterface
        Greeting greeting = name -> System.out.println("Hello, " + name + "!");
        greeting.sayHello("World");
    }
}