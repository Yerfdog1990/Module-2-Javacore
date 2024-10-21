package Widening_Narrowing;

import InstanceOf.Animal;

public class School {
    public void population(){
        System.out.println("Total school population is 1000 students.");
    }
}
class Secondary extends School{
    @Override
    public void population() {
        System.out.println("\nPopulation in secondary is 450 students.");
    }
    public void secGenderPopulation(){
        System.out.println("\nSecondary boys: 280.");
        System.out.println("Secondary girls: 170.");
    }
}
class Primary extends School{
    @Override
    public void population() {
        System.out.println("Population in primary is 550 pupils.");
    }
    public void priGenderPopulation(){
        System.out.println("\nPrimary boys: 350.");
        System.out.println("Primary girls: 200.");
    }
}
class Main{
    public static void main(String[] args) {
        // Widening conversion (upcasting) - Implicit and safe
        Secondary secondaryObj = new Secondary();
        School schoolObj1 = secondaryObj;// Widening conversion, Secondary is assigned to School reference
        schoolObj1.population(); // Calls Secondary's overridden population method (polymorphism)

        Primary primaryObj2 = new Primary();
        School schoolObj = primaryObj2;// Widening conversion, Primary is assigned to School reference
        schoolObj.population(); // Calls Primary's overridden population method (polymorphism)

        // Object reference
        Object obj = secondaryObj; // Widening conversion to Object type
        System.out.println("\nThis is an object: " +obj.toString());

        // Narrowing conversion (downcasting) - Explicit and needs casting
        if(schoolObj1 instanceof Secondary){
            Secondary secGender = (Secondary) schoolObj1;
            secGender.secGenderPopulation();
        }
        if(schoolObj instanceof Primary){
            Primary priGender = (Primary) schoolObj; // Narrowing conversion, explicit cast
            priGender.priGenderPopulation(); // Now we can access Dog-specific methods
        }
    }
}
