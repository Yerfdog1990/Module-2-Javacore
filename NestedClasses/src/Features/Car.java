package Features;

import java.util.ArrayList;
import java.util.List;

/*
Definition and Key Features of Nested Classes
Definition:
A nested class is a class defined within another class. When the nested class is non-static, it is referred to as an inner class.

Types of Nested Classes:
1.Static Nested Classes:
    -Defined with the static keyword.
    -Can be instantiated without creating an instance of the outer class.
2.Non-Static Inner Classes:
    -Do not use the static keyword.
    -Must be instantiated within an instance of the outer class.
    -Can access the outer class's members (both fields and methods).

Key Features of Inner Classes:
1.Scope and Access:
    -Inner classes can access private members of the outer class.
    -The outer class can also access private members of the inner class.
2.Instantiation:
    -An instance of an inner class can only exist within an instance of the outer class.
3.Restrictions:
    -Inner classes cannot declare static fields or methods.
    -Static methods of the outer class cannot instantiate inner class objects directly.
4.Reference to Outer Class:
    -The inner class holds a reference to the outer class using OuterClass.this.
 */
//Outer class
public class Car {
    //Outer class field
    int height = 160;
    //An array to store door heights
    List<Door> doors = new ArrayList<>();
    // Constructor for Car, adding doors to the car
    public Car() {
        doors.add(new Door());
        doors.add(new Door());
        doors.add(new Door());
        doors.add(new Door());
        doors.add(new Door());
        doors.add(new Door());
    }
    //Inner (Nested) class
    class Door{
        //Inner class field
        int height = 0;
        //Method to get height of doors.
        public int getDoorHeight(){
            if(height != 0){
                return this.height;
            }else{
                return (int) (Car.this.height * 0.8);
            }
        }
        // Method to set the inner class's height
        public void setHeight(int height) {
            this.height = height;
        }
    }
    //Method to display the door heights
    public void displayDoorHeights(){
        for (int i = 0; i < doors.size(); i++) {
            System.out.println("Door " +(i+1)+ " height = " +doors.get(i).getDoorHeight());
        }
    }
    //Main method
    public static void main(String[] args) {
        Car car = new Car();
        car.displayDoorHeights();
        // Setting the height of the first door
        Car.Door firstDoor = car.new Door();
        firstDoor.setHeight(120);
        System.out.println("First door height after setting: " + firstDoor.getDoorHeight());
    }
}
