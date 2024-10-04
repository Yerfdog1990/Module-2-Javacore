package OOP4_Interface;
/*
Default Methods in Java Interfaces
In Java 8, default methods were introduced in interfaces to allow method implementations directly within the interface.
Previously, interfaces could only declare method signatures without providing any implementation.
With default methods, interfaces can now include methods with a default implementation, making them more flexible without breaking existing implementations of the interface.

Key Features of Default Methods:
1.Backward Compatibility: Default methods allow the addition of new methods to existing interfaces without breaking the code that implements these interfaces.
2.Code Reusability: They enable code reuse within the interface itself, as classes that implement the interface can use the default method without redefining it.
3.Optional Override: Implementing classes have the choice to use the default implementation or override it with their own.
4.Multiple Inheritance Support: Interfaces can have multiple default methods, and classes can implement multiple interfaces that contain default methods.
 */
public interface Family {
    public default void county(){
        System.out.println("I come from Siaya County.");
    }
    public default void tribe(){
        System.out.println("I belong to Luo tribe.");
    }
    public default void clan(){
        System.out.println("I belong to Kanyua class living in Nyalenya.");
    }
    public default void myAge(int age){
        System.out.println("I am " +age+ " year(s) old.");
    }
    public default void myMother(){
        System.out.println("My mother is called Rosemary");
    }
    public void myName();
}
interface Mother {
    public default void myMother(){
        System.out.println("My mother comes from Awendo in Migori.");
    }
}
class Godfrey implements Family{
    @Override
    public void myName() {
        System.out.println("My name is Godfrey Ouma.");
    }
    @Override
    public void myAge(int age) {
        System.out.println("I am the oldest in the family with an age of " +age+ " years old.");
    }
    @Override
    public void myMother() {
        System.out.println("My spouse is called Rosemary.");
    }
}
class Cyril implements Family, Mother{
    @Override
    public void myName() {
        System.out.println("My name is Cyril Okoth.");
    }
    @Override
    public void myMother() {
        Family.super.myMother();
        Mother.super.myMother();
    }
}
class Cyrek implements Family, Mother{
    @Override
    public void myName() {
        System.out.println("My name is Cyrek Okoth.");
    }
    @Override
    public void myMother() {
        Family.super.myMother();
        Mother.super.myMother();
    }
}
class Main{
    public static void main(String[] args) {
        System.out.println("********************************************");
        Godfrey godfreyInfo = new Godfrey();
        godfreyInfo.myName();
        godfreyInfo.clan();
        godfreyInfo.county();
        godfreyInfo.tribe();
        godfreyInfo.myAge(34);
        godfreyInfo.myMother();
        System.out.println("********************************************");
        Cyril cyrilInfo = new Cyril();
        cyrilInfo.myName();
        cyrilInfo.clan();
        cyrilInfo.county();
        cyrilInfo.tribe();
        cyrilInfo.myAge(5);
        cyrilInfo.myMother();
        System.out.println("********************************************");
        Cyrek cyrekInfo = new Cyrek();
        cyrekInfo.myName();
        cyrekInfo.clan();
        cyrekInfo.county();
        cyrekInfo.tribe();
        cyrekInfo.myAge(1);
        cyrekInfo.myMother();
        System.out.println("********************************************");
    }
}

