import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/*
Definition:
Method references are a shorthand way of expressing a lambda expression that calls an existing method.
Instead of defining the method behavior inside a lambda expression, you refer directly to a method by its name.
This makes the code more readable and compact.

Key Features:
1.Simplicity: Replaces simple lambda expressions that merely call an existing method.
2.Types: There are four types of method references:
    -Reference to a static method
    -Reference to an instance method of a particular object
    -Reference to an instance method of an arbitrary object of a particular type
    -Reference to a constructor
3.Functional Interfaces: Method references work well with functional interfaces like BiFunction, Comparator, Supplier, etc.
4.Enhanced Readability: Increases code readability by replacing verbose lambda expressions.

Types of Method References:
1.Reference to a Static Method: Calls a static method of a class directly.
    Syntax: ClassName::staticMethodName
    Example: Person::compareByAge
2.Reference to an Instance Method of a Particular Object: Calls an instance method on a specific object.
    Syntax: instance::instanceMethodName
    Example: myComparisonProvider::compareByName
3.Reference to an Instance Method of an Arbitrary Object of a Particular Type: Calls an instance method on an object of a certain class.
    Syntax: ClassName::instanceMethodName
    Example: String::compareToIgnoreCase
4.Reference to a Constructor: Calls a constructor to create an object.
    Syntax: ClassName::new
    Example: HashSet::new
 */
public class MethodReferencesDemo {
    //Static method
    public static String appendString1(String str1, String str2){
        return str1 + str2;
    }

    // Instance method for a particular object
    public String appendString2(String str3, String str4){
        return str3 + str4;
    }
    //Main method
    public static void main(String[] args) {
        MethodReferencesDemo myApp = new MethodReferencesDemo();

        // 1. Reference to a static method
        BiFunction<String, String, String> staticRef = MethodReferencesDemo::appendString1;
        System.out.println(staticRef.apply("Static", " Method Reference."));

        // 2. Reference to an instance method of a particular object
        BiFunction<String, String, String> instanceRef = myApp::appendString2;
        System.out.println(instanceRef.apply("Instance", " Method Reference."));

        // 3. Reference to an instance method of an arbitrary object of a particular type
        BiFunction<String, String, String> arbitraryRef = String::concat;
        System.out.println(arbitraryRef.apply("Arbitrary", "Method Reference."));

        // 4. Reference to a constructor
        Supplier<ArrayList<String>> constructorRef = ArrayList::new;
        ArrayList<String> list = constructorRef.get();
        list.add("Constructor Reference");
        System.out.println(list);
    }
}
