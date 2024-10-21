package InstanceOf;
/*
In Java, the class that inherits (the subclass) is usually an instance of the class that has been inherited (the superclass).
This is because of the inheritance relationship, where a subclass is a specialized form of the superclass, meaning an object of the subclass can also be treated as an object of the superclass.
 The instanceof operator looks like this: a instanceof B.

In other words, the instanceof operator will return true if:
    1) variable a stores a reference to an object of type B
    2) variable a stores a reference to an object whose class inherits B
    3) variable a stores a reference to an object that implements interface B
Otherwise, the instanceof operator will return false.
 */
public interface Animal {
}
class Pet implements Animal{
}
class Cat extends Pet{
}
class Dog extends Pet implements Animal{
}
class Main{
    public static void main(String[] args) {
        Pet petObj = new Pet();
        boolean isAnimal = petObj instanceof Animal;
        System.out.println(isAnimal);
        boolean isCat = petObj instanceof Cat;
        System.out.println(isCat);
        boolean isPet = petObj instanceof Pet;
        System.out.println(isPet);
        boolean isDog = petObj instanceof Dog;
        System.out.println(isDog);



    }
}
