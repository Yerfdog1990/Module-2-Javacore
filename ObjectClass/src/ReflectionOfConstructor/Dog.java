package ReflectionOfConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
3. Reflection of Java Constructor
We can also inspect different constructors of a class using various methods provided by the Constructor class. For example,
 */
public class Dog {
    // public constructor without parameter
    public Dog() {

    }

    // private constructor with a single parameter
    private Dog(int age) {

    }

}

class Main {
    public static void main(String[] args) {
        try {
            // create an object of Dog
            Dog d1 = new Dog();

            // create an object of Class
            // using getClass()
            Class obj = d1.getClass();

            // get all constructors of Dog
            Constructor[] constructors = obj.getDeclaredConstructors();

            for (Constructor c : constructors) {

                // get the name of constructors
                System.out.println("Constructor Name: " + c.getName());//c.getName() - returns the name of the constructor

                // get the access modifier of constructors
                // convert it into string form
                int modifier = c.getModifiers();//c.getModifiers() - returns the access modifiers of the constructor in integer form
                String mod = Modifier.toString(modifier);
                System.out.println("Modifier: " + mod);

                // get the number of parameters in constructors
                System.out.println("Parameters: " + c.getParameterCount());//c.getParameterCount() - returns the number of parameters present in each constructor
                System.out.println("");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
