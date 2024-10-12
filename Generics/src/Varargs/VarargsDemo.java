package Varargs;

import java.util.Arrays;

/*
Definition of Varargs:
Varargs (short for Variable Arguments) is a feature in Java that allows a method to accept zero or more arguments of a specified type. Varargs makes it easier to write methods that need to take a variable number of arguments, without having to overload the method or pass an array explicitly.
In Java, varargs are defined using an ellipsis (...) after the data type in the method signature.

Key Features of Varargs:
1.Flexible Argument Count: Allows passing a variable number of arguments to a method, including no arguments at all.
2.Automatic Array Creation: Internally, Java treats varargs as an array, so you can access arguments just like array elements.
3.Type Safety: Varargs maintain type safety. The type of arguments passed must match the type specified in the varargs declaration.
4.Only One Varargs Parameter: A method can have only one varargs parameter, and it must be the last parameter in the method signature.
5.Can Be Called with an Array: You can pass an array instead of individual elements, and the array will be treated as varargs.
 */
public class VarargsDemo {
    // Method accepting variable number of arguments
    public static int printNumber(int ... numbers){
        int sum = 0;
        for(int num : numbers){
            sum += num;
        }
        return sum;
    }
    //Automatic Array Creation
    public static void printArray(int ... intArray){
        // Varargs 'numbers' is treated as an array internally
        System.out.println("\nArray length: " +intArray.length);
        for(int i = 0; i < intArray.length; i++){
            System.out.println("Element at index " +i+ ": " + intArray[i]);
        }
    }
    //Type Safety
    public static void printMessage(String ... message){
        System.out.println("\nList of messages:");
        for (int i = 0; i < message.length; i++) {
            System.out.println("Message " +(i+1)+ ": " +message[i]);
        }
    }
    // Varargs must be the last parameter
    public static void printStudentScores(String name, int ... scores){
        System.out.println("\nName: " +name);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Subject " +(i+1)+ ": " +scores[i]+ "%");
        }
    }

    //Passing an Array to Varargs
    public static void printCountries(String ... country){
        System.out.println("\nEast African countries");
        for (int i = 0; i < country.length; i++) {
            System.out.println("Country " +(i+1)+ ": " +country[i]);
        }
    }
    //Main method
    public static void main(String[] args) {
        //Flexible argument count
        System.out.println("Sum = " +printNumber());//No argument
        System.out.println("Sum = " +printNumber(1));//1 argument
        System.out.println("Sum = " +printNumber(1,2));//2 arguments
        System.out.println("Sum = " +printNumber(1,2,3,4,5,6,6,7,8,9));//More than 2 arguments

        //Automatic Array Creation
        printArray(23, 45, 90, 67, 12, 98, 73, 47);

        //Type safety
        printMessage("Hello world!", "Welcome to Java programming", "Today is Sunday");

        //Only One Varargs Parameter (Varargs must be the last parameter)
        printStudentScores("Julius", 90, 56, 78, 87, 67);

        //Passing an Array to Varargs
        String[] countryList = {"Kenya", "Uganda", "Tanzania", "Rwanda", "Burundi"};
        printCountries(countryList);
    }
}

