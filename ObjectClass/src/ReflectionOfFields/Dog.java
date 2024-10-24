package ReflectionOfFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
2. Reflection of Java Fields
Like methods, we can also inspect and modify different fields of a class using the methods of the Field class. See example below.
 */
public class Dog {
    public String type;
}

class Main {
    public static void main(String[] args) {
        try {
            // create an object of Dog
            Dog d1 = new Dog();

            // create an object of Class
            // using getClass()
            Class obj = d1.getClass();

            // access and set the type field
            Field field1 = obj.getField("type");
            field1.set(d1, "labrador");//field1.set() - sets the value of the field

            // get the value of the field type
            String typeValue = (String) field1.get(d1);//field1.get() - returns the value of field
            System.out.println("Value: " + typeValue);

            // get the access modifier of the field type
            int mod = field1.getModifiers();//field1.getModifiers() - returns the value of the field in integer form

            // convert the modifier to String form
            String modifier1 = Modifier.toString(mod);
            System.out.println("Modifier: " + modifier1);
            System.out.println(" ");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
